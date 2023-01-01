package com.example.mytest2;

public class FinderItem {
    public int imageResource;
    public String title;
    public String key_ingredient;
    public String instructionsfinder;

    public FinderItem(int imageResource, String title, String key_ingredient, String instructions) {
        this.imageResource = imageResource;
        this.title = title;
        this.key_ingredient = key_ingredient;
        this.instructionsfinder = instructions;
    }

    public FinderItem(){

    }


    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey_ingredient() {
        return key_ingredient;
    }

    public void setKey_ingredient(String key_ingredient) {
        this.key_ingredient = key_ingredient;
    }

    public String getInstructionsfinder() {
        return instructionsfinder;
    }

    public void setInstructionsfinder(String instructionsfinder) {
        this.instructionsfinder = instructionsfinder;
    }
}
