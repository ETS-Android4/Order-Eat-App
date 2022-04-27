package com.example.store;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class settings extends AppCompatActivity {
    private Context h = this;
    private Switch s;
    private static boolean isDark;

    public void onBackPressed() {
        startActivity(new Intent(settings.this, realStart.class));
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        s = (Switch) findViewById(R.id.dark_modeS);
        s.setChecked(isDark);
        DarkMode(isDark);

        actions();
        BottomNavigationView bar = (BottomNavigationView) findViewById(R.id.bar);
        bar.setSelectedItemId(R.id.setting12);
        bar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.home12) {
                    home();
                } else if (item.getItemId() == R.id.profile12) {
                    profile();
                } else if (item.getItemId() == R.id.messagea12) {
                    mess();
                } else if (item.getItemId() == R.id.setting12) {
                    sett();
                }
                return false;
            }
        });
    }

    private void actions() {
        cart();
        logOut();
        setChecked();
    }

    private void DarkMode(boolean r) {
        RelativeLayout parent = (RelativeLayout) findViewById(R.id.parentP);
        BottomNavigationView bar = (BottomNavigationView) findViewById(R.id.bar);
        if (r) {
            parent.setBackgroundColor(Color.parseColor("#000000"));
            bar.setBackgroundColor(Color.parseColor("#444444"));

        } else {
            parent.setBackgroundColor(Color.parseColor("#FFFFFF"));
            bar.setBackgroundColor(Color.parseColor("#FFFFFF"));

        }
    }

    private void setChecked() {
        LinearLayout l = (LinearLayout) findViewById(R.id.dark_mode_back);
        l.setClickable(true);
        Switch s = (Switch) findViewById(R.id.dark_modeS);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s.isChecked()) {
                    s.setChecked(false);
                    isDark = false;

                } else {
                    isDark = true;
                    s.setChecked(true);
                }
                Sign_in_form.getPeople().get(Start.getSh()).setLike_darkMode(isDark);
                DarkMode(isDark);
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s.isChecked()) {
                    s.setChecked(true);
                    isDark = true;
                } else {
                    isDark = false;
                    s.setChecked(false);
                }
                Sign_in_form.getPeople().get(Start.getSh()).setLike_darkMode(isDark);
                DarkMode(isDark);
            }
        });
    }

    public static boolean isIsDark() {
        return isDark;
    }

    public static void setIsDark(boolean isDark) {
        settings.isDark = isDark;
    }

    private void logOut() {
        TextView t = (TextView) findViewById(R.id.logout);
        Intent i = new Intent(this, Start.class);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(i);
            }
        });
    }

    private void cart() {
        Intent i = new Intent(this, cart.class);
        ImageView l = (ImageView) findViewById(R.id.image11111);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }

    private void sett() {
        Toast.makeText(settings.this, "you are already in settings", Toast.LENGTH_SHORT).show();
    }

    private void mess() {
        Intent i = new Intent(settings.this, massege.class);
        startActivity(i);
        overridePendingTransition(0, 0);
    }

    private void profile() {
        Intent i = new Intent(settings.this, profile.class);
        startActivity(i);
        overridePendingTransition(0, 0);
    }

    private void home() {
        Intent i = new Intent(settings.this, realStart.class);
        startActivity(i);
        overridePendingTransition(0, 0);
    }
}