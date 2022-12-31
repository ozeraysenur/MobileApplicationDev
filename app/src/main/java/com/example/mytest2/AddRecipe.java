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


    EditText recipeNameEdt, ingredientsEdt, instructionsEdt;
    Button sendRecipebtn;

    FirebaseDatabase firebaseDatabase;


    DatabaseReference databaseReference;

    RecipeInfo recipeInfo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        recipeNameEdt = findViewById(R.id.idEdtRecipeName);
        ingredientsEdt = findViewById(R.id.idEdtIngredients);
        instructionsEdt = findViewById(R.id.idEdtInstructions);

        // below line is used to get the instance of my firebase database
        firebaseDatabase = FirebaseDatabase.getInstance();


        databaseReference = firebaseDatabase.getReference("Recipes");

        
        recipeInfo = new RecipeInfo();

        sendRecipebtn = findViewById(R.id.idBtnSendData);

        // adding on click listener for my button.
        sendRecipebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = recipeNameEdt.getText().toString();
                String ingredients = ingredientsEdt.getText().toString();
                String instructions = instructionsEdt.getText().toString();


                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(ingredients) && TextUtils.isEmpty(instructions)) {
                    // if the text fields are empty show the below message
                    Toast.makeText(AddRecipe.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add data
                    addDatatoFirebase(name, ingredients, instructions);
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
