package com.example.store;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import static com.example.store.R.*;

public class realStart extends AppCompatActivity {
    ArrayList<service> services;
    Context h=this;
    private static ArrayList<service> serviceArrayList=new ArrayList<>();
    customAdapter CustomAdapter;
    ListView listView;
    private static ImageView wr;

    public static ImageView getWr() {
        return wr;
    }

    public static void setWr1(Bitmap a) {

        wr.setImageBitmap(a);
    }
    public static void setWr2(Uri a) {
        wr.setImageURI(a);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_real_start);
        wr=(ImageView) findViewById(id.image1);
        settings.setIsDark(Sign_in_form.getPeople().get(Start.getSh()).isLike_darkMode());
        TextView textView = (TextView) findViewById(id.name_hello);
        textView.setText("Hi " + Start.getName());
        listView = (ListView) findViewById(id.list_item);
        listView.setClickable(true);

        services = new ArrayList<>();
        services.add(new service("Burger", 15,  (drawable.burger),"hot burger ta3meya fool flafel yaba \n3ash 3lach ya ta3maya"));
        services.add(new service("Pizza", 12,  (drawable.pizza1),"hot burger ta3meya fool flafel yaba \n3ash 3lach ya ta3maya"));
        services.add(new service("pizza er", 10,  (drawable.pizza2),"hot burger ta3meya fool flafel yaba \n3ash 3lach ya ta3maya"));
        services.add(new service("Burger er", 20,  (drawable.logo),"hot burger ta3meya fool flafel yaba \n3ash 3lach ya ta3maya"));
        services.add(new service("Donat", 5,  (drawable.cat_5),"hot burger ta3meya fool flafel yaba \n3ash 3lach ya ta3maya"));
        services.add(new service("CocaCola", 3, (drawable.cat_4),"hot burger ta3meya fool flafel yaba \n3ash 3lach ya ta3maya"));
        CustomAdapter = new customAdapter(this, (layout.tazbeet), services);
        listView.setAdapter(CustomAdapter);
        Intent i=new Intent(this,show_details.class);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                i.putExtra("name",services.get(position).getTitle());
                i.putExtra("desc",services.get(position).getDescription());
                i.putExtra("img",services.get(position).getImageId());
                i.putExtra("price",services.get(position).getPrice());
                i.putExtra("numbers",services.get(position).getNumbers());
                startActivity(i);
            }
        });
        BottomNavigationView bar = (BottomNavigationView) findViewById(id.bar);
        bar.setSelectedItemId(id.home12);
        bar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                System.out.println("id:     "+item.getItemId());
                if (item.getItemId() == id.home12){
                    home();
                }else if(item.getItemId() == id.setting12){
                    sett();
                }else if(item.getItemId() == id.messagea12 ){
                    mess();
                } else{
                    profile();
                }
                return false;
            }
        });
        SearchView s = (SearchView) findViewById(id.serch);
        s.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<service> d=new ArrayList<>();
                for(service s:services){
                    if(s.getTitle().toLowerCase().contains(newText.toLowerCase())){
                        d.add(s);
                    }
                }
                customAdapter c=new customAdapter(h ,(layout.tazbeet),d);
                listView.setAdapter(c);
                return false;
            }
        });
        darkMode(settings.isIsDark());
        actions();
    }
    private void actions(){
        cart();
    }

    @Override
    public void onBackPressed() {

    }

    private void darkMode(boolean r){
        RelativeLayout parent=(RelativeLayout) findViewById(id.parentPP);
//        BottomNavigationView bar = (BottomNavigationView) findViewById(R.id.bar);
//        MenuItem cart = bar.findViewById(R.id.carta);
//        MenuItem home = bar.findViewById(R.id.home);
//        MenuItem profile = bar.findViewById(R.id.profile);
//        MenuItem setting = bar.findViewById(R.id.setting);
        TextView a =(TextView) findViewById(id.order);
        TextView o =(TextView) findViewById(id.ourser);
        SearchView searchView=(SearchView) findViewById(id.serch);
        BottomNavigationView bar = (BottomNavigationView) findViewById(id.bar);
        if(r){

            searchView.setBackgroundResource((drawable.feild_dark));
            parent.setBackgroundColor(Color.parseColor("#000000"));
            bar.setBackgroundColor(Color.parseColor("#444444"));

            a.setTextColor(Color.parseColor("#FFFFFF"));
            o.setTextColor(Color.parseColor("#FFFFFF"));



        }
    }
    private void cart(){
        Intent i =new Intent(this,cart.class);
        ImageView r= (ImageView) findViewById(id.image111);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }
    public static  void setItems(ArrayList<service> y){
        serviceArrayList=y;
    }
    public static  ArrayList<service> getItems(){
        return serviceArrayList;
    }
    private void sett(){
        Intent i= new Intent(realStart.this,settings.class);
        startActivity(i);
        overridePendingTransition(0,0);
    }
    private void mess(){
        Intent i= new Intent(realStart.this,massege.class);
        startActivity(i);

        overridePendingTransition(0,0);
    }
    private void profile(){
        startActivity(new Intent(realStart.this,profile.class));

        overridePendingTransition(0,0);
    }
    private void home(){
        Toast.makeText(realStart.this,"You are in home already !",Toast.LENGTH_SHORT).show();
    }
}

class customAdapter extends ArrayAdapter<service> {
    private Context mContext;
    private int mResource;
    private int lastPosition = -1;
    ArrayList<service> services=new ArrayList<>();

    private static class ViewHolder {
        ImageView image;
        TextView title;
        TextView Price;
        TextView Var;
        Button plus;
        Button minus;
        Button add;
    }

    public customAdapter(Context context, int resource, ArrayList<service> objects) {
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
        String desc = getItem(position).getDescription();

        service service = new service(title, price, source);
        service.setDescription(desc);
        service.setNumbers(number);
        final View result;

        ViewHolder holder;


        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(id.title_here);
            holder.Price = (TextView) convertView.findViewById(id.price_here);
            holder.image = (ImageView) convertView.findViewById(id.image_here);
            holder.Var = (TextView) convertView.findViewById(id.var);
            holder.plus = (Button) convertView.findViewById(id.plusButton);
            holder.minus = (Button) convertView.findViewById(id.minusButton);
            holder.add = (Button) convertView.findViewById(id.addToChart);


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
        holder.Price.setText("$" + String.valueOf(service.getPrice()));
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int g = service.getNumbers();
                holder.Var.setText(String.valueOf(++g));
                service.setNumbers(g);
                if (g != 0) {
                    holder.Price.setText("$" + (g * (service.getPrice())));
                }
            }
        });
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(String.valueOf(holder.Var.getText()));
                if (a > 0) {
                    int g = service.getNumbers();
                    holder.Var.setText(String.valueOf(--g));
                    service.setNumbers(g);
                    if (g != 0) {
                        holder.Price.setText("$" + (g * (service.getPrice())));
                    }
                }
            }
        });
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(service.getNumbers() !=0){
                    services.add(service);
                    holder.Price.setText(String.valueOf("$"+service.getPrice()));

                    try {
                        ArrayList <service> services =new ArrayList<>();
                        if (service.getNumbers() !=0){
                            services=realStart.getItems();
                            services.add(service);
                            realStart.setItems(services);
                        }
                    }catch (Exception e){
                        System.out.println(e);
                    }

                    Toast.makeText(mContext,"Added",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(mContext,"It is 0 !!!!!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        if(settings.isIsDark()){
            holder.Var.setTextColor(Color.parseColor("#FFFFFF"));
            holder.title.setTextColor(Color.parseColor("#FFFFFF"));
            holder.Price.setTextColor(Color.parseColor("#FFFFFF"));
        }
        return convertView;
    }

}
