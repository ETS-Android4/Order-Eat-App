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

public class change_password extends AppCompatActivity {
    private final Context h = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!(settings.isIsDark())){
            setContentView(R.layout.activity_change_password);
        }else {
            setContentView(R.layout.change_password_dark);
        }
        actions();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,checkPassword.class));
    }

    private void actions(){
        backTo_profile();
        change_password();
    }
    private void backTo_profile(){
        TextView t = (TextView) findViewById(R.id.backToProfile1);
        Intent i = new Intent(this , profile.class);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }
    private void change_password(){
        EditText e = (EditText) findViewById(R.id.change_passwordField);
        Button b = (Button) findViewById(R.id.change_passwordB1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _newPass=e.getText().toString();
                if(_newPass.length() >6 && _newPass.length()<15){
                    if(!(Sign_in_form.getPeople().get(Start.getSh()).getPassword11().equals(_newPass))){
                        Sign_in_form.getPeople().get(Start.getSh()).setPassword11(_newPass);
                        Toast.makeText(h,"Done !",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(h,"It Is The Same",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(h, "The Password should contain at less 7 characters and at most 15 characters",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}