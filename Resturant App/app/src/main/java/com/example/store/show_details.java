package com.example.store;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class show_details extends AppCompatActivity {
    Button plus1;
    Button minus1;
    TextView title;
    ImageView img;
    TextView desc;
    TextView price;
    TextView Var1;
    Context h = this;
    Button r;
    int i;
    int g;
    String _title;
    String _desc;
    int _img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        plus1=(Button)findViewById(R.id.plusButton1);
        minus1=(Button)findViewById(R.id.minusButton1);
        title=(TextView)findViewById(R.id.titleIn);
        img=(ImageView)findViewById(R.id.image_here1);
        desc = (TextView)findViewById(R.id.desc);
        price=(TextView) findViewById(R.id.pr);
        Var1=(TextView)findViewById(R.id.var1);
        r=(Button)findViewById(R.id.removo);
        Intent intent=this.getIntent();
        if(intent !=null){
             _title =intent.getStringExtra("name");
             _desc =intent.getStringExtra("desc");
             _img =intent.getIntExtra("img",(R.drawable.hbd));
             g =intent.getIntExtra("number",0);
             i=intent.getIntExtra("numbers",0);
             title.setText(_title);
             img.setImageResource(_img);
             desc.setText(_desc);
             price.setText("$"+realStart.getItems().get(g).getPrice());
             Var1.setText(String.valueOf(i));
        }
        darkMode(settings.isIsDark());
        actions();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,cart.class));
    }

    private void actions(){
        removeItem();
        plusB();
        back();
        minusB();
    }
    private void darkMode(boolean r){
        TextView descoo=(TextView) findViewById(R.id.desooo);
        TextView pic =(TextView) findViewById(R.id.picoooo);
        TextView numericalishuny=(TextView) findViewById(R.id.numoioi);
        RelativeLayout relativeLayout=(RelativeLayout) findViewById(R.id.parentSho);
        TextView back=(TextView) findViewById(R.id.back3);
        if(r){
            back.setBackgroundResource(R.drawable.back_b_dark);
            relativeLayout.setBackgroundColor(Color.parseColor("#000000"));
            descoo.setTextColor(Color.parseColor("#FFFFFF"));
            pic.setTextColor(Color.parseColor("#FFFFFF"));
            numericalishuny.setTextColor(Color.parseColor("#FFFFFF"));
            plus1.setBackgroundResource(R.drawable.back_b_dark);
            minus1.setBackgroundResource(R.drawable.back_b_dark);
            title.setTextColor(Color.parseColor("#FFFFFF"));
            desc.setTextColor(Color.parseColor("#FFFFFF"));
            price.setTextColor(Color.parseColor("#FFFFFF"));
            Var1.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }
    private void plusB(){
        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realStart.getItems().get(g).setNumbers((realStart.getItems().get(g).getNumbers()+1));
                Var1.setText(String.valueOf(realStart.getItems().get(g).getNumbers()));
            }
        });
    }
    private void minusB(){
        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(Var1.getText())) >0){
                    realStart.getItems().get(g).setNumbers((realStart.getItems().get(g).getNumbers()-1));
                    Var1.setText(String.valueOf(realStart.getItems().get(g).getNumbers()));
                    if (Integer.parseInt(String.valueOf(Var1.getText())) == 0){
                        realStart.getItems().remove(g);
                        Toast.makeText(show_details.this,"The Item has removed successfully",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    private void removeItem(){
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(realStart.getItems().get(g).getNumbers() !=0){
                    realStart.getItems().get(g).setNumbers(0);
                    Toast.makeText(h,"The Item has removed Successfully", Toast.LENGTH_SHORT).show();
                    Var1.setText(""+realStart.getItems().get(g).getNumbers());
                }else {
                    Toast.makeText(h,"It doesn't exist already",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void back(){
        Intent i = new Intent(this,cart.class);

        TextView t = (TextView) findViewById(R.id.back3);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }
}