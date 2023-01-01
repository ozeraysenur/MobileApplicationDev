package com.example.mytest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginRegister extends AppCompatActivity {

    EditText username, password;
    Button btnLogin,btnRegister;
    DBHelperLogin myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        username = (EditText) findViewById(R.id.usernameEdt);
        password = (EditText) findViewById(R.id.passwordEdt);

        btnLogin = (Button) findViewById(R.id.loginBtn);
        btnRegister = (Button) findViewById(R.id.registerBtn);

        myDB = new DBHelperLogin(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                //checking user fill al the blanks or not.
                if(user.equals("") || pass.equals("")){
                    Toast.makeText(LoginRegister.this,"Please fill all",Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean usercheckResult = myDB.checkuserName(user);

                    //if yes adding new user to the database
                    if(usercheckResult == false){
                        myDB.insertData(user,pass);
                    }
                    //if user already have an account below message will shown.
                    else{
                        Toast.makeText(LoginRegister.this,"You already have an account please login.",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(LoginRegister.this,"Please fill all",Toast.LENGTH_SHORT).show();

                }
                else{
                    Boolean result =myDB.checkuserNamePassword(user,pass);
                        if(result == true){
                            Intent intent =  new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);

                        }
                        else{
                            Toast.makeText(LoginRegister.this,"Invalid password or username.Try again.",Toast.LENGTH_SHORT).show();
                        }

                }
            }
        });
    }
}