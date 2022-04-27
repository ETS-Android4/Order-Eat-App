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

public class checkPassword extends AppCompatActivity {


    Context h = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!(settings.isIsDark())){
            setContentView(R.layout.activity_check_password);
        }else {
            setContentView(R.layout.activity_check_password_dark);
        }
        actions();
    }
    private void actions(){
        backToProfile();
        checkPassword();
    }

    private void backToProfile(){
        Intent i = new Intent( this , profile.class);
        TextView t = (TextView) findViewById(R.id.backToProfile);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }
    private void checkPassword(){
        EditText e = (EditText) findViewById(R.id.checkPasswordField);
        Button b = (Button) findViewById(R.id.checkPasswordB);
        Intent i=new Intent(this , change_password.class);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e.getText().toString().length() >0){
                    if (checkPassword(e.getText().toString())){
                        startActivity(i);
                    }else {
                        Toast.makeText(h,"Not True",Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(h,"Fill The blank Please",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean checkPassword(String Password){
        boolean r = false;
        if(Password.equals(Sign_in_form.getPeople().get(Start.getSh()).getPassword11())){
            r=true;
        }
        return r;
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent( this , profile.class);
        startActivity(i);
    }
}