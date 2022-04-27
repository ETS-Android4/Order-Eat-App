package com.example.store;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Start extends AppCompatActivity {
    Context context=this;
    private static String name;
    private static int sh=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Sign_in_form.getPeople().add(new person("Ahmed","01153180577","ebeidahmed2@gmail.com","Male","Ahmed8884"));
        actions();
    }
    @Override
    public void onBackPressed(){

    }
    public static int getSh() {
        return sh;
    }
    private void actions(){
        sin();
        Login();
    }
    private void Login(){
        Button f=(Button) findViewById(R.id.Login);
        TextView textView1=(TextView) findViewById(R.id.namew);
        TextView textView2=(TextView) findViewById(R.id.passw);
        Intent i= new Intent(this,realStart.class);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean a=(textView1.getText().toString().length()!=0 && textView2.getText().toString().length()!=0);
                if (a) {
                    String e = String.valueOf(textView1.getText());
                    name=removeFara7(e);
                    boolean r= false;
                    for(int i =0 ; i<Sign_in_form.getPeople().size();i++){
                        if (name.equals(Sign_in_form.getPeople().get(i).getName()) && textView2.getText().toString().equals(Sign_in_form.getPeople().get(i).getPassword11())){
                            sh=i;
                            r=true;
                            break;
                        }
                    }
                    if (r){
                        startActivity(i);
                    }else {
                        Toast.makeText(context,"Not Found",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(context,"Fill The Blanks Please",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public static String getName(){
        return Sign_in_form.getPeople().get(Start.getSh()).getName();
    }
    private String removeFara7(String a){
        while (a.charAt(a.length()-1) ==' '){
            a=removeLastChar(a);
        }
        return a;
    }
    private String removeLastChar(String a){
        String j ="";
        for(int i =0 ; i< a.length()-1;i++){
            j=j+a.charAt(i);
        }
        a=j;
        return a;
    }
    private void sin(){
        TextView textView=(TextView) findViewById(R.id.sign);
        Intent intent=new Intent(this,Sign_in_form.class);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}