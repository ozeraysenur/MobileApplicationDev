package com.example.mytest2;

public class RecipeInfo {

    // string variable for
    // storing recipe name.
    private String recipeName;

    // string variable for storing
    // recipe ingredients number
    private String ingredientsList;

    // string variable for storing
    // recipe instructions.
    private String instructions;

    // an empty constructor is
    // required when using
    // Firebase Realtime Database.
    public RecipeInfo() {

    }

    // created getter and setter methods
    // for all our variables.
    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(String ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
