package com.example.store;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Sign_in_form extends AppCompatActivity {
    private Context context=this;
    private RadioButton male;
    private  static  ArrayList<person> people =new ArrayList<>();
    private RadioButton female;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_form);
        people.add(new person("Ahmed","01153180577","ebeidahmed2@gmail.com","Male","Ahmed8884"));
        login();
        check();
        chf();
    }
    private void check(){
        male=(RadioButton) findViewById(R.id.male);
        female=(RadioButton) findViewById(R.id.female);
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(female.isChecked()){
                    female.setChecked(false);
                }
                male.setChecked(true);
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(male.isChecked()){
                    male.setChecked(false);
                }
                female.setChecked(true);
            }
        });
    }
    private void login(){
        TextView textView=(TextView) findViewById(R.id.ligon);
        Intent i=new Intent(this,Start.class);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }
    private void chf(){
        Button b=(Button) findViewById(R.id.sign_in);
        EditText fName = (EditText) findViewById(R.id.fNameField);
        EditText sName = (EditText) findViewById(R.id.SNameField);
        EditText PNumber = (EditText) findViewById(R.id.NumberField);
        EditText email = (EditText) findViewById(R.id.emailField);
        EditText pass=(EditText) findViewById(R.id.passwordField);
        male=(RadioButton) findViewById(R.id.male);
        female=(RadioButton) findViewById(R.id.female);
        Intent i =new Intent(this,Start.class);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean l=(male.isChecked() || female.isChecked());
                boolean u=Contains(email.getText().toString());
                boolean r=((iSEmpty(fName)) && (iSEmpty(sName)) && (iSEmpty(PNumber)) && (iSEmpty(email) ) && (iSEmpty(pass)) && (l));
                if(r){
                    boolean c=true;
                    String gender="";
                    if (male.isChecked()){
                        gender="Male";
                    } else if(female.isChecked()){
                        gender="Female";
                    }else {
                        c=false;
                        Toast.makeText(context,"Choose your gender please",Toast.LENGTH_SHORT).show();
                    }
                    if(u){
                        Toast.makeText(context,"check email",Toast.LENGTH_SHORT).show();
                    }
                    System.out.println("bool : "+u);
                    String gname = removeFara7(fName.getText().toString());
                    String gname1 = removeFara7(sName.getText().toString());
                    String name =gname + " " +gname1;
                    boolean a = ValidOrNo(gname) && ValidOrNo(gname1);
                    if (!a){
                        Toast.makeText(context,"Check Name",Toast.LENGTH_SHORT).show();
                    }
                    boolean b=checkNumber(PNumber.getText().toString());
                    if(!b){
                        Toast.makeText(context,"Check Number",Toast.LENGTH_SHORT).show();
                    }
                    if (a && b && c && (!u)){
                        people.add(new person(name,geTText(PNumber),geTText(email),gender,geTText(pass)));
                        startActivity(i);
                    }
                }else {
                    Toast.makeText(context,"Fill The Blanks Please",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean Contains(String e){
        boolean t = false;
        for(int i =0 ; i<e.length();i++){
            if(e.charAt(i) == ' '){
                System.out.println(i);
                t=true;
            }
        }
        return t;
    }
    private boolean iSEmpty(TextView t){
        boolean y=t.getText().toString().length()!=0;
        return y;
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
    private boolean ValidOrNo(String an){
        boolean is = true;
        String f="";
        if (an.charAt(an.length()-1) == ' '){
            for(int i =0 ;i<an.length()-1;i++){
                f=f+an.charAt(i);
            }
            an=f;
        }
        ArrayList<String> characters = new ArrayList<>();
        String[] arr = {"+", "-", "*", "(", ")", "^", "$", "@", "!", "?", "%", "~", "=", "?", "/", "|", "\\", "<", ">", " ", ",", "’", " ' ", "\""};
        try {
            int a = Integer.parseInt(String.valueOf(an.charAt(0)));
            if (a >= 0 || a < 0) {
                is = false;
            }
        } catch (Exception e) {
            for (int i = 0; i < an.length(); i++) {
                characters.add(String.valueOf(an.charAt(i)));
            }
            for (int i = 0; i < arr.length; i++) {
                for (int y = 0; y < characters.size(); y++) {
                    if (arr[i].equals(characters.get(y))) {
                        is = false;
                        break;
                    }
                }
            }
        }
        return is;
    }

    public static ArrayList<person> getPeople() {
        return people;
    }

    public static void setPeople(ArrayList<person> people1) {
        people = people1;
    }

    private String geTText(TextView t){
        return t.getText().toString();
    }
    private boolean checkNumber(String an){
        boolean w =(an.charAt(0) == '0' && an.charAt(1) == '1' && (an.charAt(2) == '1' || an.charAt(2) == '2' || an.charAt(2) == '5' || an.charAt(2) == '0' ));
        boolean g=an.length() ==11;
        return w&g;
    }
}
