package com.example.store;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class massege extends AppCompatActivity {
    private final Context h=this;
    private String Final_email="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massege);
        darkMode(settings.isIsDark());
        actions();
        BottomNavigationView bar = (BottomNavigationView) findViewById(R.id.bar);
        bar.setSelectedItemId(R.id.messagea12);
        bar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                if (item.getItemId() == R.id.home12){
                    home();
                }else if(item.getItemId() == R.id.setting12){
                    sett();
                }else if(item.getItemId() == R.id.messagea12 ){
                    mess();
                } else{
                    profile();
                }
                return false;
            }
        });
    }
    public void onBackPressed(){
        startActivity(new Intent(massege.this,realStart.class));
        overridePendingTransition(0,0);
    }
    private void actions(){




        cart();
        sendEmail();
    }
    private void darkMode(boolean w){
        RelativeLayout parent=(RelativeLayout) findViewById(R.id.message_parent);
        RelativeLayout m=(RelativeLayout) findViewById(R.id.message_backo);
        EditText e = (EditText) findViewById(R.id.message_txtField);


        TextView y1 =(TextView) findViewById(R.id.topPanel);

        BottomNavigationView bar = (BottomNavigationView) findViewById(R.id.bar);
        if (w){
            bar.setBackgroundColor(Color.parseColor("#444444"));
            y1.setTextColor(Color.parseColor("#FFFFFF"));
            parent.setBackgroundColor(Color.parseColor("#000000"));
            e.setBackgroundColor(Color.parseColor("#000000"));
            e.setTextColor(Color.parseColor("#FFFFFF"));
            e.setHintTextColor(Color.parseColor("#909090"));

            m.setBackgroundResource((R.drawable.dark_message_back));
        }
    }
    private void sendEmail(){
        EditText e = (EditText) findViewById(R.id.message_txtField);
        String f="\nFrom : "  +Sign_in_form.getPeople().get(Start.getSh()).getName()+ "\nEmail: " +Sign_in_form.getPeople().get(Start.getSh()).getE_mail()
                +"\nPhone Number : " + Sign_in_form.getPeople().get(Start.getSh()).getPhone_number() + "\nMy Message :- \n";
        Button b =(Button) findViewById(R.id.send_messageB);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (takeText().length() >0){
                    Final_email =f + takeText();
                    Toast.makeText(h,"The message has send successfully , check your email ,Please." ,Toast.LENGTH_SHORT).show();
                    System.out.println(Final_email);
                    e.setText("");
                }else {
                    Toast.makeText(h,"Message field is empty",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private String takeText(){
        EditText e = (EditText) findViewById(R.id.message_txtField);
        String _e=e.getText().toString();
        return _e;
    }
    private void cart(){
        Intent i = new Intent(this , cart.class);
        ImageView l = (ImageView) findViewById(R.id.image11231);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }
    private void sett(){
        Intent i= new Intent(massege.this,settings.class);
        startActivity(i);
        overridePendingTransition(0,0);
    }
    private void mess(){
        Toast.makeText(massege.this,"you are already in massege",Toast.LENGTH_SHORT).show();
    }
    private void profile(){
        Intent i= new Intent(massege.this,profile.class);
        startActivity(i);
        overridePendingTransition(0,0);
    }
    private void home() {
        Intent i= new Intent(massege.this,realStart.class);
        startActivity(i);
        overridePendingTransition(0,0);
    }
}