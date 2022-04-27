package com.example.store;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class E_mail extends AppCompatActivity {
    private final Context h = this;
    public static String RealCode="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!(settings.isIsDark())){
            setContentView(R.layout.activity_email);
        }else {
            setContentView(R.layout.activity_e_mail_dark);
        }
        actions();
    }
    private void actions(){
        write_the_Message();
        back();
        checkCode();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this , profile.class));
    }

    private void write_the_Message(){
        String Email;
        Email = h1(Sign_in_form.getPeople().get(Start.getSh()).getE_mail());
        TextView t = (TextView) findViewById(R.id.email_here_0_0);
        t.setText("We send to " + Email+" a code please check your email and write the code here");
    }
    private void checkCode(){
        Intent i = new Intent(this , change_email.class);
        Button b = (Button) findViewById(R.id.submitCode);
        EditText _1 =(EditText) findViewById(R.id.number1);
        EditText _2 =(EditText) findViewById(R.id.number2);
        EditText _3 =(EditText) findViewById(R.id.number3);
        EditText _4 =(EditText) findViewById(R.id.number4);
        EditText _5 =(EditText) findViewById(R.id.number5);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = _1.getText().toString();
                String b = _2.getText().toString();
                String c = _3.getText().toString();
                String d = _4.getText().toString();
                String e = _5.getText().toString();
                boolean r = (a.length() ==1) &&(b.length() ==1) &&(c.length() ==1) && (d.length() ==1)&&(e.length()==1);
                if(r){
                   String userCode=a+b+c+d+e;
                   if (!userCode.equals(RealCode)){                          // we will change it when the backend or the api exist (we will Remove '!');
                       startActivity(i);
                   }else {
                       Toast.makeText(h,"Not Correct",Toast.LENGTH_SHORT).show();
                   }
                }else {
                    Toast.makeText(h,"Every field should contain a one char",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private void back(){
        Intent i = new Intent(this , profile.class);
        TextView t = (TextView ) findViewById(R.id.back0_0);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }
    private String h1(String a) {
        String r = "";
        for (int i = 0; i < a.length(); i++) {
            if (i == 0 || i == 1 || i == 2 || i == (a.length() - 1) || i == (a.length() - 2) || i == (a.length() - 3) || i == (a.length() - 4)) {
                r = r + a.charAt(i);
            } else {
                r = r + "*";
            }
        }
        return r;
    }
}