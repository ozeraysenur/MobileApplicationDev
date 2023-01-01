package com.example.mytest2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public CardView card1,card2,card3,card4,card5,card6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card1 =(CardView) findViewById(R.id.cardview_recipes);
        card2 =(CardView) findViewById(R.id.cardview_add_recipe);
        card3 =(CardView) findViewById(R.id.cardview_favorites);
        card4 =(CardView) findViewById(R.id.cardview_find_recipe);
        //card5 =(CardView) findViewById(R.id.cardview_profile_set);
        //card6 =(CardView) findViewById(R.id.cardview_settings);


        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        //card5.setOnClickListener(this);
        //card6.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        Intent i;
        //for every cardview to access new activity code below write another cases for every one of them.
        switch (view.getId()){
            case R.id.cardview_recipes:
                i = new Intent(this,Framecard.class);
                startActivity(i);
                break;

            case R.id.cardview_add_recipe:
                i = new Intent(this,AddRecipe.class);
                startActivity(i);
                break;

            case R.id.cardview_favorites:
                i = new Intent(this,FavFrameCard.class);
                startActivity(i);
                break;

            case R.id.cardview_find_recipe:
                i= new Intent(this,RecipeFinder.class);
                startActivity(i);
                break;
        }

    }

}