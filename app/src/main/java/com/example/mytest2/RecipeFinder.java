package com.example.mytest2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SearchView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class RecipeFinder extends AppCompatActivity {

    RecyclerView recyclerView;
    List<FinderItem> itemList;
    FinderAdapter itemAdapter;
    SearchView searchView;
    ConstraintLayout rootLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recipe_finder);



        rootLayout = findViewById(R.id.root_layout);
        searchView = findViewById(R.id.searchView);
        recyclerView = findViewById(R.id.finderRec);
        itemList = new ArrayList<>();

        //Marinated Lamb Chops
        itemList.add(new FinderItem(R.drawable.meat_img,"Marinated Lamb Chops","meat","Step 1. Place lamb chops in a shallow dish or bowl suitable for marinating.\n" +
                "Step 2. Combine all ingredients in a mixing bowl and mix together.\n" +
                "Step 3. Pour marinade over chops, cover and refrigerate. Leave overnight if possible, otherwise a few hours is sufficient.\n" +
                "Step 4. Cook chops on a barbeque grill or hot plate until done, basting the meat with extra marinade."));
        //Mums Meatloaf
        itemList.add(new FinderItem(R.drawable.meat_img,"Mum's Meatloaf","meat","Step 1. Combine all loaf ingredients and mix well. Put into an ovenproof dish with enough room for basting\n" +
                "Step 2. Shape into a loaf and bake at 180C for 30-45 minutes.\n" +
                "Step 3. While loaf is baking, place sauce ingredients in a pan, bring to the boil then simmer for 5 minutes.\n" +
                "Step 4. Pour over loaf and bake for a further 45 minutes, basting frequently."));
        //Creamy Tuscan Chicken
        itemList.add(new FinderItem(R.drawable.chicken_meat_img,"Creamy Tuscan Chicken","chicken","Step 1. In a skillet over medium heat, heat oil. Add chicken and season with salt, pepper, and oregano. Cook until golden.\n" +
                "Step 2. In the same skillet over medium heat, melt butter. Stir in garlic and cook until fragrant, about 1 minute. Add cherry tomatoes and season with salt and pepper.\n" +
                "Step 3. Stir in heavy cream and parmesan and bring mixture to a simmer. Reduce heat to low and simmer until sauce is slightly reduced, about 3 minutes.\n" +
                "Step 4. Return chicken to skillet and cook until heated through, 5 to 7 minutes.Serve with lemon wedges."));
        //Chicken Cheesesteaks
        itemList.add(new FinderItem(R.drawable.chicken_meat_img,"Chicken Cheesesteaks","chicken","Step 1. In a large skillet over medium heat, heat oil. Add onion and peppers and season with salt and pepper. Cook, stirring occasionally, until very soft, 8 to 10 minutes.\n" +
                "Step 2. Add chicken and Italian seasoning and stir to combine. Cook, stirring occasionally, until chicken is golden and no longer pink inside, about 10 minutes.\n" +
                "Step 3. Cover chicken and peppers with provolone cheese and cover to let melt, 1 minute. \n" +
                "Step 4. Serve on hoagie rolls."));
        //Spaghetti With Olives And Capers
        itemList.add(new FinderItem(R.drawable.fastfood_img,"Spaghetti With Olives And Capers","pasta","Step 1. Heat oil over medium high heat. Add garlic and cook until fragrant.\n" +
                "Step 2. Then add tinned tomatoes, chilli flakes, olives, capers and 1/2 cup water. Simmer 3 minutes.\n" +
                "Step 3. Toss with pasta and cooking water per Base Directions.\n" +
                "Step 4. Toss through parsley and serve with parmesan."));
        //Fiery Pasta
        itemList.add(new FinderItem(R.drawable.fastfood_img,"Fiery Pasta","pasta","Step 1. Heat oil over medium high heat. Add garlic, stir until fragrant.\n" +
                "Step 2. Then add the tinned tomatoes and chilli flakes, simmer on medium for 5 minutes.\n" +
                "Step 3. Toss with pasta and cooking water per Base Directions. \n" +
                "Step 4. Toss through parsley and serve with parmesan."));
        //Baked Zucchini with Pecorino
        itemList.add(new FinderItem(R.drawable.leek_img,"Baked Zucchini with Pecorino","vegetable","Cut Zucchini into 1/3-inch thick disks. \n" +
                "Step 2. Coat with olive oil, salt, pepper, chili flakes and garlic. \n" +
                "Step 3. Lay then zucchini out in a single layer on a parchment-lined sheet pan and sprinkle each piece with 1/3 teaspoon of pecorino cheese. \n" +
                "Step 4. Bake the Zucchini until crispy, golden and tender. About 18 minutes at 425F."));
        //Oven-Roasted Asparagus
        itemList.add(new FinderItem(R.drawable.leek_img,"Oven-Roasted Asparagus","vegetable","Step 1. Preheat the oven to 425 degrees F (220 degrees C).\n" +
                "Step 2. Place asparagus into a mixing bowl; drizzle with olive oil and toss to coat. Sprinkle with Parmesan cheese, garlic, salt, and pepper. \n" +
                "Step 3. Arrange asparagus in a single layer in a baking dish. Bake in the preheated oven until just tender\n" +
                "Step 4. Sprinkle with lemon juice just before serving."));
        //Chocolate-Covered Strawberries
        itemList.add(new FinderItem(R.drawable.dessert_img,"Chocolate-Covered Strawberries","sugar","Step 1. Melt chocolate and shortening in a double boiler, stirring occasionally until smooth.\n" +
                "Step 2. Insert toothpicks into tops of strawberries. Hold a strawberry by the toothpick and dip it into the chocolate mixture.\n" +
                "Step 3. Turn the strawberry upside down and place strawberry on a sheet of waxed paper.\n" +
                "Step 4. Allow chocolate coating to cool. Repeat with remaining strawberries."));
        //Creamy Rice Pudding
        itemList.add(new FinderItem(R.drawable.dessert_img,"Creamy Rice Pudding","sugar","Step 1. Place cooked rice in a medium saucepan. Add 1 1/2 cups milk and salt; cook and stir until thick and creamy.\n" +
                "Step 2. Add remaining 1/2 cup milk, golden raisins, beaten egg, and white sugar.\n" +
                "Step 3. Continue cooking, stirring continuously, until well blended, 2 to 3 minutes.\n" +
                "Step 4. Remove saucepan from heat; stir in butter and vanilla extract."));
        //Garlic Bread
        itemList.add(new FinderItem(R.drawable.bakery_img,"Garlic Bread","flour","Step 1. Preheat oven to 425° and line a large baking sheet with foil. Make garlic compound butter.\n" +
                "Step 2. In a small bowl, mix softened butter with garlic, salt, and parsley until well combined.\n" +
                "Step 3. Spread cut sides of bread liberally with garlic butter. Sprinkle with Parmesan.\n" +
                "Step 4. Bake until bread is toasty and golden at the edges, about 10 minutes."));
        //French Bread Pizza
        itemList.add(new FinderItem(R.drawable.bakery_img,"French Bread Pizza","flour","Step 1. Cut the French bread in half lengthwise and brush it with garlic butter.\n" +
                "Step 2. Place on a baking sheet cut side up and bake until browned\n" +
                "Step 3. Top baked halves with pasta sauce, sprinkle with oregano, cheeses, and toppings of choice.\n" +
                "Step 4. Bake until browned and bubbly and let cool before serving."));


        itemAdapter = new FinderAdapter(this,itemList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(itemAdapter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                List<FinderItem> findAfterList = new ArrayList<>();

                if(s.length()>0){
                    for(int i =0 ; i< itemList.size(); i++){
                        if(itemList.get(i).getTitle().toLowerCase().contains(s.toLowerCase())){
                            FinderItem recItem = new FinderItem();
                            recItem.setTitle(itemList.get(i).getTitle());
                            recItem.setImageResource(itemList.get(i).getImageResource());
                            recItem.setInstructionsfinder(itemList.get(i).getInstructionsfinder());
                            findAfterList.add(recItem);
                        }
                    }
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecipeFinder.this);
                    recyclerView.setLayoutManager(new LinearLayoutManager(RecipeFinder.this));
                    itemAdapter = new FinderAdapter(RecipeFinder.this,itemList);
                    recyclerView.setAdapter(itemAdapter);
                }
                else{
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecipeFinder.this);
                    recyclerView.setLayoutManager(new LinearLayoutManager(RecipeFinder.this));
                    itemAdapter = new FinderAdapter(RecipeFinder.this,itemList);
                    recyclerView.setAdapter(itemAdapter);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String txt) {
                List<FinderItem> findAfterList = new ArrayList<>();

                if(txt.length()>0){
                    for(int i =0 ; i< itemList.size(); i++){
                        if(itemList.get(i).getTitle().toLowerCase().contains(txt.toLowerCase())){
                            FinderItem recItem = new FinderItem();
                            recItem.setTitle(itemList.get(i).getTitle());
                            recItem.setImageResource(itemList.get(i).getImageResource());
                            recItem.setInstructionsfinder(itemList.get(i).getInstructionsfinder());
                            findAfterList.add(recItem);
                        }
                    }
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecipeFinder.this);
                    recyclerView.setLayoutManager(new LinearLayoutManager(RecipeFinder.this));
                    itemAdapter = new FinderAdapter(RecipeFinder.this,itemList);
                    recyclerView.setAdapter(itemAdapter);
                }
                else{
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecipeFinder.this);
                    recyclerView.setLayoutManager(new LinearLayoutManager(RecipeFinder.this));
                    itemAdapter = new FinderAdapter(RecipeFinder.this,itemList);
                    recyclerView.setAdapter(itemAdapter);
                }
                return false;
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


   /* public void findList(String txt){
        List<FinderItem> findAfterList = new ArrayList<>();
        for(FinderItem item : itemList){
            if(item.getKey_ingredient().toLowerCase().contains(txt.toLowerCase())){
                findAfterList.add(item);

            }
        }
    }*/

}