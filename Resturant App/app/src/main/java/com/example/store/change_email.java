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

public class change_email extends AppCompatActivity {
    private final Context h =this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(settings.isIsDark()){
            setContentView(R.layout.activity_change_email_dark);
        }else {
            setContentView(R.layout.activity_change_email);
        }
        actions();
    }
    private void actions(){
        back();
        change_email();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this , profile.class));
    }

    private void change_email(){
        Button b = (Button) findViewById(R.id.change_EmailFB);
        EditText e = (EditText)findViewById(R.id.Change_EmailTxtField);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e.getText().toString().length()>0){
                    String r = e.getText().toString();
                    if(!r.equals(Sign_in_form.getPeople().get(Start.getSh()).getE_mail())){
                        if (r.contains("@")){
                            Sign_in_form.getPeople().get(Start.getSh()).setE_mail(r);
                            Toast.makeText(h,"Done !",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(h,"The E-mail is incorrect",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(h,"It is The same",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(h,"Fill The Blank",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void back(){
        Intent i = new Intent(this , profile.class);
        TextView t = (TextView) findViewById(R.id.back0_1);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }
}