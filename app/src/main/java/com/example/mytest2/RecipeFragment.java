package com.example.mytest2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class RecipeFragment extends Fragment {

    RecyclerView recipeHorizontalRec,recipeVerticalRec;
    List<RecipeHorModel> recipeHorModelList;
    RecipeHorAdapter recipeHorAdapter;
    List<RecipeVerModel> recipeVerModelList;
    RecipeVerAdapter recipeVerAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recipe,container,false);

        recipeHorizontalRec = root.findViewById(R.id.recipe_hor_rec);
        recipeVerticalRec =root.findViewById(R.id.recipe_ver_rec);
        recipeHorModelList = new ArrayList<>();
        recipeHorModelList.add(new RecipeHorModel(R.drawable.bakery_img,"Bakery"));
        recipeHorModelList.add(new RecipeHorModel(R.drawable.chicken_meat_img,"Chicken Meat"));
        recipeHorModelList.add(new RecipeHorModel(R.drawable.meat_img,"Meat"));
        recipeHorModelList.add(new RecipeHorModel(R.drawable.fastfood_img,"Fastfood"));
        recipeHorModelList.add(new RecipeHorModel(R.drawable.leek_img,"Vegetables"));
        recipeHorModelList.add(new RecipeHorModel(R.drawable.pot_food_img,"Pot Food"));
        recipeHorModelList.add(new RecipeHorModel(R.drawable.dessert_img,"Dessert"));

        recipeHorAdapter = new RecipeHorAdapter(getActivity(),recipeHorModelList);
        recipeHorizontalRec.setAdapter(recipeHorAdapter);
        recipeHorizontalRec.setHasFixedSize(true);
        recipeHorizontalRec.setNestedScrollingEnabled(false);
        recipeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));



        recipeVerModelList = new ArrayList<>();
        recipeVerModelList.add(new RecipeVerModel(R.drawable.bakery_img,"Bakery","0","0"));
        recipeVerModelList.add(new RecipeVerModel(R.drawable.chicken_meat_img,"Chicken","1","0"));
        recipeVerModelList.add(new RecipeVerModel(R.drawable.meat_img,"Meat","2","0"));
        recipeVerModelList.add(new RecipeVerModel(R.drawable.fastfood_img,"Fastfood","3","0"));
        recipeVerModelList.add(new RecipeVerModel(R.drawable.leek_img,"Vegetables","4","0"));
        recipeVerModelList.add(new RecipeVerModel(R.drawable.pot_food_img,"Pot Food","5","0"));
        recipeVerModelList.add(new RecipeVerModel(R.drawable.dessert_img,"Dessert","6","0"));


        recipeVerAdapter = new RecipeVerAdapter(getActivity(),recipeVerModelList);
        recipeVerticalRec.setAdapter(recipeVerAdapter);
        recipeVerticalRec.setHasFixedSize(true);
        recipeVerticalRec.setNestedScrollingEnabled(false);
        recipeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));

        return root;
    }
}