package com.example.mytest2;

public class RecipeVerModel {

    String favStatus;
    int verImage;
    String verName;
    String key_id;

    public RecipeVerModel(int verImage, String verName,String key_id,String favStatus) {
        this.verImage = verImage;
        this.verName = verName;
        this.key_id = key_id;
        this.favStatus = favStatus;
    }

    public int getVerImage() {
        return verImage;
    }

    public void setVerImage(int verImage) {
        this.verImage = verImage;
    }

    public String getVerName() {
        return verName;
    }

    public void setVerName(String verName) {
        this.verName = verName;
    }

    public String getKey_id() {return key_id;}

    public void setKey_id(String key_id) {this.key_id = key_id;}

    public String getFavStatus() {return favStatus;}

    public void setFavStatus(String favStatus) {this.favStatus = favStatus;}
}

