package com.example.store;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class cart extends AppCompatActivity {
    private final Context h= this;
    private double u=0;
    private ArrayList<service> arrayList=new ArrayList<>();
    private TextView f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        f=(TextView)findViewById(R.id.total);
        ListView listView=(ListView) findViewById(R.id.list2);
        arrayList=realStart.getItems();
        for (int i =0;i<arrayList.size();i++){
            if(arrayList.get(i).getNumbers() ==0){
                arrayList.remove(arrayList.get(i));
            }
        }
        myAdapter adapter=new myAdapter(this,(R.layout.cartll),arrayList);
        listView.setClickable(true);
        listView.setAdapter(adapter);
        Intent y=new Intent(this,show_details.class);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                y.putExtra("name",arrayList.get(position).getTitle());
                y.putExtra("desc",arrayList.get(position).getDescription());
                y.putExtra("img",arrayList.get(position).getImageId());
                y.putExtra("price",arrayList.get(position).getPrice());
                y.putExtra("numbers",arrayList.get(position).getNumbers());
                y.putExtra("number",position);
                startActivity(y);
            }
        });
        TextView t= (TextView) findViewById(R.id.items_numbers);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayList.remove(arrayList.get(position));
                u=0;
                t.setText(""+arrayList.size());
                calculateTotal();
                myAdapter a = new myAdapter(h,(R.layout.cartll),arrayList);
                listView.setAdapter(a);
                Toast.makeText(h,"The Item has removed successfully",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        t.setText(""  +arrayList.size());
        for (int i =0;i<arrayList.size();i++){
            if(arrayList.get(i).getNumbers() ==0){
                arrayList.remove(arrayList.get(i));
            }
        }
        darkMode(settings.isIsDark());
        actions();
    }
    private void actions(){
        calculateTotal();
        Buy();
        back();
    }
    public void onBackPressed(){
        startActivity(new Intent(cart.this,realStart.class));
        overridePendingTransition(0,0);
    }
    private void darkMode(boolean r){
        RelativeLayout parent=(RelativeLayout) findViewById(R.id.parentC);
        TextView back =(TextView) findViewById(R.id.back2);
        LinearLayout pb=(LinearLayout) findViewById(R.id.parentBottom);
        TextView noi =(TextView) findViewById(R.id.nboi);
        TextView ot=(TextView) findViewById(R.id.totaloo);
        TextView ds=(TextView) findViewById(R.id.ds);
        TextView t= (TextView) findViewById(R.id.items_numbers);
        TextView _5=(TextView) findViewById(R.id.dollar5);
        if(r){
            _5.setTextColor(Color.parseColor("#FFFFFF"));
            t.setTextColor(Color.parseColor("#FFFFFF"));
            noi.setTextColor(Color.parseColor("#FFFFFF"));
            ot.setTextColor(Color.parseColor("#FFFFFF"));
            ds.setTextColor(Color.parseColor("#FFFFFF"));
            f.setTextColor(Color.parseColor("#FFFFFF"));
            back.setBackgroundResource(R.drawable.back_b_dark);
            parent.setBackgroundColor(Color.parseColor("#000000"));
            pb.setBackgroundResource(R.drawable.p);
        }
    }
    private void back(){
        TextView t = (TextView) findViewById(R.id.back2);
        Intent i = new Intent(this , realStart.class);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }
    private void calculateTotal(){
        for (int i =0 ; i<arrayList.size();i++){
            u=u+(arrayList.get(i).getNumbers()  * arrayList.get(i).getPrice());
        }
        if(u != 0){
            u=u+5;
        }
        f.setText("$"+u);
    }
    private void Buy(){
        Button b=(Button) findViewById(R.id.buy);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(u > 0){
                    Toast.makeText(h,"Ok we are going to call you",Toast.LENGTH_SHORT).show();
                    System.out.println(getSummary(arrayList,Sign_in_form.getPeople().get(Start.getSh())));
                }else {
                    Toast.makeText(h,"Not Item Found !",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private String getSummary(ArrayList<service> a, person p){
        double total =0;
        String y ="From : " +p.getName()+"\n"+"Phone Number : " + p.getPhone_number()+"\nEmail : " + p.getE_mail()+"\nHis Orders :-\n";
        for(int i =0 ;i<a.size();i++){
            service s =a.get(i);
            double r =(s.getNumbers() * s.getPrice());
            String j = (i+1) +":-\n"+"Name : "+s.getTitle()+"\nNumbers: " +s.getNumbers()+"\nPrice : $" +s.getPrice()+"\n" +"Total in this Item : $" + r+"\n";
            total=total +(s.getNumbers() * s.getPrice());
            y=y+j;
        }
        y=y+"\n\nTotal = $"+(total+5);
        return y;
    }
}
class myAdapter extends ArrayAdapter<service> {
    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    private static class ViewHolder {
        ImageView image;
        TextView title;
        TextView Price;
        TextView Var;
        TextView nums;
        TextView prices;
    }

    public myAdapter(Context context, int resource, ArrayList<service> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String title = getItem(position).getTitle();
        double price = getItem(position).getPrice();
        int source = getItem(position).getImageId();
        int number = getItem(position).getNumbers();

        service service = new service(title, price, source);
        service.setNumbers(number);
        final View result;

        ViewHolder holder;


        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.titlee);
            holder.Price = (TextView) convertView.findViewById(R.id.pricesss);
            holder.image = (ImageView) convertView.findViewById(R.id.imggg);
            holder.Var = (TextView) convertView.findViewById(R.id.numbersss);
            holder.nums =(TextView) convertView.findViewById(R.id.numssss);
            holder.prices =(TextView) convertView.findViewById(R.id.pricessss);


            result = convertView;

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        lastPosition = position;

        holder.Var.setText(String.valueOf(service.getNumbers()));
        holder.title.setText(service.getTitle());
        holder.image.setImageResource(service.getImageId());
        holder.Price.setText("$" + String.valueOf(service.getPrice() * service.getNumbers()));
        if(settings.isIsDark()){
            holder.Var.setTextColor(Color.parseColor("#FFFFFF"));
            holder.prices.setTextColor(Color.parseColor("#FFFFFF"));
            holder.Price.setTextColor(Color.parseColor("#FFFFFF"));
            holder.title.setTextColor(Color.parseColor("#FFFFFF"));
            holder.nums.setTextColor(Color.parseColor("#FFFFFF"));
        }

        return convertView;
    }
}