package com.example.store;

import android.widget.ImageView;

public class person {
    private String name ;
    private String phone_number;
    private String E_mail;
    private String gender;
    private String password;
    private boolean like_darkMode;
    private ImageView image;
    public person(String name, String password) {
        this.name = name;
        this.password = password;
        image.setImageResource(R.drawable.hbd);
    }

    public boolean isLike_darkMode() {
        return like_darkMode;
    }

    public void setLike_darkMode(boolean like_darkMode) {
        this.like_darkMode = like_darkMode;
    }

    public person(String name, String phone_number, String e_mail, String gender, String password, boolean like_darkMode) {
        this.name = name;
        this.phone_number = phone_number;
        E_mail = e_mail;
        this.gender = gender;
        this.password = password;
        this.like_darkMode = like_darkMode;
        image.setImageResource(R.drawable.hbd);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public person(String name, String phone_number, String e_mail, String gender, String password) {
        this.name = name;
        this.phone_number = phone_number;
        this.E_mail = e_mail;
        this.gender = gender;
        this.password = password;
        this.like_darkMode=false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword11() {
        return password;
    }

    public void setPassword11(String password) {
        this.password = password;
    }
}
