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

public class change_number extends AppCompatActivity {
    private final Context h = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!(settings.isIsDark())) {
            setContentView(R.layout.activity_change_number);
        }else {
            setContentView(R.layout.activity_change_number_dark);
        }
        actions();
    }

    private void actions() {
        back();
        changeNumber();
    }

    private void changeNumber() {
        Button b = (Button) findViewById(R.id.change_numberB);
        EditText r = (EditText) findViewById(R.id.numberTextField);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String j = r.getText().toString();
                if (j.length() > 0) {
                    boolean k = (j.length() == 11);
                    boolean r =j.charAt(0) == '0' && j.charAt(1) =='1';
                    boolean r1 = j.charAt(2) =='0' || j.charAt(2) =='1' || j.charAt(2) =='2' || j.charAt(2) =='5';
                    boolean s =r && r1;
                    if (k && s) {
                        String y = Sign_in_form.getPeople().get(Start.getSh()).getPhone_number();
                        if (!y.equals(j)) {
                            Sign_in_form.getPeople().get(Start.getSh()).setPhone_number(j);
                            Toast.makeText(h, "The number has changed successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(h, "It Is same", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(h, "The Number Is Invalid", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(h, "Fill The Blank Please", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void back() {
        Intent i = new Intent(this, profile.class);
        TextView t = (TextView) findViewById(R.id.back0_3);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }
}