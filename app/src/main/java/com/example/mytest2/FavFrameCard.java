package com.example.mytest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FavFrameCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_frame_card);
        getSupportFragmentManager().beginTransaction().add(R.id.favframelayout,new FavoritesFragment()).commit();
    }
}