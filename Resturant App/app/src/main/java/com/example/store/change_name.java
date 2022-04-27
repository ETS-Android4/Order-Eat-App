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

import java.util.ArrayList;

public class change_name extends AppCompatActivity {
    private Context o=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!(settings.isIsDark())){
            setContentView(R.layout.activity_change_name);
        }else {
            setContentView(R.layout.activity_change_name_dark);
        }
        actions();
    }
    private void actions(){
        back();
        changeName();
    }
    private void changeName(){
        EditText e=(EditText) findViewById(R.id.nameTextField);
        Button b = (Button) findViewById(R.id.change_nameB);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e.getText().toString().length() != 0){
                    String h = e.getText().toString();
                    h=removeFara7(h);
                    if(ValidOrNo(h)){
                        if(!h.toLowerCase().equals(Sign_in_form.getPeople().get(Start.getSh()).getName().toLowerCase())){
                            Sign_in_form.getPeople().get(Start.getSh()).setName(h);
                            Toast.makeText(o,"Name has changed successfully",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(o,"The name is the same",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(o,"The name is invalid",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(o,"please fill the blank",Toast.LENGTH_SHORT).show();
                }
            }
        });
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
        String[] arr = {"+", "-", "*", "(", ")", "^", "$", "@", "!", "?", "%", "~", "=", "?", "/", "|", "\\", "<", ">", ",", "’", " ' ", "\""};
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
            int q=0;
            for(int i =0;i<an.length();i++){
                if(an.charAt(i) == ' '){
                    q++;
                }
            }
            if(q>1){
                is=false;
            }
        }
        return is;
    }
    private void back(){
        Intent i = new Intent(this , profile.class);
        TextView g = (TextView) findViewById(R.id.back);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this , profile.class));
    }
}