package com.example.mytest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartingPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_page);
        //first ı create a button for going another activity but ı changed to a splash screen using thread.


        /*button = (Button) findViewById(R.id.startingpage_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartingPage.this, LoginRegister.class);
                startActivity(intent);
            }
        });*/


        // I use thread here to create a splash screen. It appears 5 seconds.
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(StartingPage.this, LoginRegister.class);
                    startActivity(intent);

                }
            }
        };
        thread.start();


    }


}