package com.example.mytest2;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.mytest2.FavoriteAdapter;
import com.example.mytest2.FavDB;
import com.example.mytest2.RecipeVerModel;
import com.example.mytest2.R;

public class FavoritesFragment extends Fragment {

    private RecyclerView recyclerView;
    private FavDB favDB;
    private List<RecipeVerModel> favItemList = new ArrayList<>();
    private FavoriteAdapter favAdapter;

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_favorites_fragment, container, false);

        favDB = new FavDB(getActivity());
        recyclerView = root.findViewById(R.id.recyclerView);
        favAdapter= new FavoriteAdapter(getActivity(),favItemList);
        recyclerView.setAdapter(favAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));



        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        loadData();

        return root;
    }

    private void loadData() {
        if (favItemList != null) {
            favItemList.clear();
        }
        SQLiteDatabase db = favDB.getReadableDatabase();
        Cursor cursor = favDB.select_all_favorite_list();
        try {
            // a loop for traversing through db and add data to list.
            while (cursor.moveToNext()) {
                @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex(FavDB.ITEM_TITLE));
                @SuppressLint("Range") String id = cursor.getString(cursor.getColumnIndex(FavDB.KEY_ID));
                @SuppressLint("Range") int image = Integer.parseInt(cursor.getString(cursor.getColumnIndex(FavDB.ITEM_IMAGE)));
                @SuppressLint("Range") String fStatus = cursor.getString(cursor.getColumnIndex(FavDB.FAV_STATUS));
                RecipeVerModel favItem = new RecipeVerModel(image, title, id,fStatus);
                favItemList.add(favItem);
            }
        } finally {
            if (cursor != null && cursor.isClosed())
                cursor.close();
            db.close();
        }

        favAdapter = new FavoriteAdapter(getActivity(), favItemList);

        recyclerView.setAdapter(favAdapter);

    }

    // remove item after swipe
    private ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            final int position = viewHolder.getAdapterPosition();
            final RecipeVerModel favItem = favItemList.get(position);
            if (direction == ItemTouchHelper.LEFT) {
                favAdapter.notifyItemRemoved(position);
                favItemList.remove(position);
                favDB.remove_fav(favItem.getKey_id());
            }
        }
    };

}