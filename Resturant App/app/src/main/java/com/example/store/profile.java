package com.example.store;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class profile extends AppCompatActivity {
    private static ImageView f;

    Context h = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
         f = (ImageView) findViewById(R.id.imageaaw);

        TextView name = (TextView) findViewById(R.id.object_name);
        TextView gender = (TextView) findViewById(R.id.object_gender);
        TextView email = (TextView) findViewById(R.id.object_email);
        TextView phone = (TextView) findViewById(R.id.object_number);
        TextView password = (TextView) findViewById(R.id.object_pass);

        actions();


        String _name = Sign_in_form.getPeople().get(Start.getSh()).getName();
        String _phone = Sign_in_form.getPeople().get(Start.getSh()).getPhone_number();
        String _gender = Sign_in_form.getPeople().get(Start.getSh()).getGender();
        String _pass = Sign_in_form.getPeople().get(Start.getSh()).getPassword11();
        String _email = Sign_in_form.getPeople().get(Start.getSh()).getE_mail();

        name.setText(_name);
        gender.setText(_gender);
        phone.setText(_phone);
        password.setText(h2(_pass));
        email.setText(h1(_email));
        darkMode(settings.isIsDark());
        changes();

        BottomNavigationView bar = (BottomNavigationView) findViewById(R.id.bar);
        bar.setSelectedItemId(R.id.profile12);
        bar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.home12){
                    home();
                }else if(item.getItemId() == R.id.profile12){
                    profile();
                }else if(item.getItemId() == R.id.messagea12){
                    mess();
                }else if(item.getItemId() == R.id.setting12){
                    sett();
                }
                return false;
            }
        });

    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(profile.this,realStart.class));
        overridePendingTransition(0,0);
    }
    private void darkMode(boolean r){

        TextView name = (TextView) findViewById(R.id.object_name);
        TextView gender = (TextView) findViewById(R.id.object_gender);
        TextView email = (TextView) findViewById(R.id.object_email);
        TextView phone = (TextView) findViewById(R.id.object_number);
        TextView password = (TextView) findViewById(R.id.object_pass);

        TextView _name = (TextView) findViewById(R.id.nameoo);
        TextView _gender=(TextView) findViewById(R.id.genoo);
        TextView _email=(TextView) findViewById(R.id.emailoo);
        TextView _phone=(TextView) findViewById(R.id.phoo);
        TextView pass=(TextView) findViewById(R.id.passoo);

        RelativeLayout parent=(RelativeLayout) findViewById(R.id.paerntoo);
        ////
//        LinearLayout k = (LinearLayout) findViewById(R.id.dse);
//        TextView t =(TextView) findViewById(R.id.portxt);
//        TextView y =(TextView) findViewById(R.id.mess_txt1);
//        TextView u =(TextView) findViewById(R.id.set_tx1);

        TextView chN=(TextView) findViewById(R.id.change_name);
        TextView chE=(TextView) findViewById(R.id.change_emailTB);
        TextView chP=(TextView) findViewById(R.id.change_passwordB);
        TextView chPH=(TextView) findViewById(R.id.change_numberGB);
        BottomNavigationView bar = (BottomNavigationView) findViewById(R.id.bar);


        if(r){
            bar.setBackgroundColor(Color.parseColor("#444444"));
            chN.setBackgroundResource((R.drawable.back_b_dark));
            chE.setBackgroundResource((R.drawable.back_b_dark));
            chP.setBackgroundResource((R.drawable.back_b_dark));
            chPH.setBackgroundResource((R.drawable.back_b_dark));


            parent.setBackgroundColor(Color.parseColor("#000000"));
//            k.setBackgroundResource((R.drawable.p));
//            t.setTextColor(Color.parseColor("#B3B6B7"));
//            y.setTextColor(Color.parseColor("#B3B6B7"));
//            u.setTextColor(Color.parseColor("#B3B6B7"));

            name.setTextColor(Color.parseColor("#FFFFFF"));
            gender.setTextColor(Color.parseColor("#FFFFFF"));
            email.setTextColor(Color.parseColor("#FFFFFF"));
            phone.setTextColor(Color.parseColor("#FFFFFF"));
            password.setTextColor(Color.parseColor("#FFFFFF"));
            
            _name.setTextColor(Color.parseColor("#FFFFFF"));
            _gender.setTextColor(Color.parseColor("#FFFFFF"));
            _email.setTextColor(Color.parseColor("#FFFFFF"));
            _phone.setTextColor(Color.parseColor("#FFFFFF"));
            pass.setTextColor(Color.parseColor("#FFFFFF"));

        }
    }
    private void changes() {
        name();
        changePassword();
        E__mail();
        number();
    }
    private void number(){
        Intent i = new Intent(this,number.class);
        TextView t = (TextView) findViewById(R.id.change_numberGB);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }
    private void E__mail() {
        Intent i = new Intent(this, E_mail.class);
        TextView T = (TextView) findViewById(R.id.change_emailTB);
        T.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }

    private void name() {
        Intent i = new Intent(this, change_name.class);
        TextView t = (TextView) findViewById(R.id.change_name);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }

    private String h2(String a) {
        String r = "";
        for (int i = 0; i < a.length(); i++) {
            r = r + "*";
        }
        return r;
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

    private void actions() {

        image();

    }
    private void image(){
        ImageView image =(ImageView) findViewById(R.id.imageaaw);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog a =new Dialog(profile.this);
                if(ContextCompat.checkSelfPermission(profile.this, "android.permission.CAMERA") != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(profile.this,
                            new String[]{
                                    Manifest.permission.CAMERA
                            },
                            100
                    );
                }
                a.setCancelable(false);
                a.setContentView(R.layout.image_pikker_dialog);
                a.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                RelativeLayout camera=(RelativeLayout) a.findViewById(R.id.camera_father);
                camera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                       Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                       startActivityForResult(i,100);

                    }
                });
                TextView cancel =(TextView) a.findViewById(R.id.dialog_cancel);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        a.dismiss();
                    }
                });
                RelativeLayout galley=(RelativeLayout) a.findViewById(R.id.gallery_father);
                galley.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent we = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                        startActivityForResult(we,200);
                    }
                });
                a.show();
            }
        });
    }

    private void changePassword() {
        TextView tr = (TextView) findViewById(R.id.change_passwordB);
        Intent i = new Intent(this, checkPassword.class);
        tr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }

    private void cart() {
        Intent i = new Intent(this, cart.class);
        ImageView cart = (ImageView) findViewById(R.id.image1111);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }

    private void sett() {
        Intent i= new Intent(profile.this,settings.class);
        startActivity(i);
        overridePendingTransition(0,0);
    }

    private void mess() {
        Intent i= new Intent(profile.this,massege.class);
        startActivity(i);
        overridePendingTransition(0,0);
    }

    private void profile() {
        Toast.makeText(profile.this,"Your are in profile already",Toast.LENGTH_SHORT).show();
    }
    private void home() {
        Intent i= new Intent(profile.this,realStart.class);
        startActivity(i);
        overridePendingTransition(0,0);
    }
/////////
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            Bitmap ci = (Bitmap) data.getExtras().get("data");
            setImage1(ci);
        } else if (requestCode == 200) {
            Uri uri = data.getData();
            setImage2(uri);
        }
    }


    private static void setImage1(Bitmap a){
        f.setImageBitmap(a);
        Sign_in_form.getPeople().get(Start.getSh()).setImage(f);
        realStart.setWr1(a);
    }
    private static void setImage2(Uri u){
        f.setImageURI(u);
        Sign_in_form.getPeople().get(Start.getSh()).setImage(f);
        realStart.setWr2(u);
    }
}