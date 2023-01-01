package com.example.mytest2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FinderAdapter extends RecyclerView.Adapter<FinderAdapter.NewsViewHolder> implements Filterable {


    Context context;
    List<FinderItem> fData ;
    List<FinderItem> fDataFiltered ;



    public FinderAdapter(Context context, List<FinderItem> fData) {
        this.context = context;
        this.fData = fData;
        this.fDataFiltered = fData;

    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View layout;
        layout = LayoutInflater.from(context).inflate(R.layout.each_item,viewGroup,false);
        return new NewsViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int position) {
        //LOOK HERE PLS
        newsViewHolder.rec_title.setText(fDataFiltered.get(position).getTitle());
        newsViewHolder.rec_instructions.setText(fDataFiltered.get(position).getInstructionsfinder());
        newsViewHolder.tv_key.setText(fDataFiltered.get(position).getKey_ingredient());
        newsViewHolder.img_rec.setImageResource(fDataFiltered.get(position).getImageResource());



    }

    @Override
    public int getItemCount() {
        return fDataFiltered.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String Key = constraint.toString();
                if (Key.isEmpty()) {

                    fDataFiltered = fData ;

                }
                else {
                    List<FinderItem> lstFiltered = new ArrayList<>();
                    for (FinderItem row : fData) {

                        if (row.getTitle().toLowerCase().contains(Key.toLowerCase())){
                            lstFiltered.add(row);
                        }

                    }

                    fDataFiltered = lstFiltered;

                }


                FilterResults filterResults = new FilterResults();
                filterResults.values= fDataFiltered;
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {


                fDataFiltered = (List<FinderItem>) results.values;
                notifyDataSetChanged();

            }
        };




    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {



        TextView rec_title, rec_instructions, tv_key;
        ImageView img_rec;
        RelativeLayout container;





        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.root_layout);
            rec_title = itemView.findViewById(R.id.tv_title);
            tv_key = itemView.findViewById(R.id.tv_key);
            rec_instructions = itemView.findViewById(R.id.tv_instructions);
            img_rec = itemView.findViewById(R.id.eachImageView);





        }

    }
}
