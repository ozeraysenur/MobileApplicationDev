package com.example.mytest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Framecard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framecard);

        getSupportFragmentManager().beginTransaction().add(R.id.framelayout,new RecipeFragment()).commit();
    }
}