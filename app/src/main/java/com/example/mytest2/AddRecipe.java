package com.example.mytest2;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddRecipe extends AppCompatActivity {

    // creating variables for
    // EditText and buttons.
    private EditText recipeNameEdt, ingredientsEdt, instructionsEdt;
    private Button sendRecipebtn;

    // creating a variable for my
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for my Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    // creating a variable for
    // my object class
    RecipeInfo recipeInfo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        // initializing my edittext and button
        recipeNameEdt = findViewById(R.id.idEdtRecipeName);
        ingredientsEdt = findViewById(R.id.idEdtIngredients);
        instructionsEdt = findViewById(R.id.idEdtInstructions);

        // below line is used to get the
        // instance of my Firebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();


        databaseReference = firebaseDatabase.getReference("EmployeeInfo");

        
        recipeInfo = new RecipeInfo();

        sendRecipebtn = findViewById(R.id.idBtnSendData);

        // adding on click listener for my button.
        sendRecipebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from our edittext fields.
                String name = recipeNameEdt.getText().toString();
                String phone = ingredientsEdt.getText().toString();
                String address = instructionsEdt.getText().toString();

                // below line is for checking whether the
                // edittext fields are empty or not.
                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(phone) && TextUtils.isEmpty(address)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(AddRecipe.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to my database.
                    addDatatoFirebase(name, phone, address);
                }
            }
        });
    }

    private void addDatatoFirebase(String name, String ingredients, String instructions) {

        recipeInfo.setRecipeName(name);
        recipeInfo.setIngredientsList(ingredients);
        recipeInfo.setInstructions(instructions);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                databaseReference.setValue(recipeInfo);


                Toast.makeText(AddRecipe.this, "Recipe added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(AddRecipe.this, "Fail to add recipe " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
