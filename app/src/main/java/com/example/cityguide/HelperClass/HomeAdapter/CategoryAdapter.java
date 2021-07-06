package com.example.cityguide.HelperClass.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguide.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CatrgoryViewHolder> {

    ArrayList<CategoryHelperClass> categoryHelperClasses;

    public CategoryAdapter(ArrayList<CategoryHelperClass> categoryHelperClasses) {
        this.categoryHelperClasses = categoryHelperClasses;
    }

    @NonNull
    @Override
    public CatrgoryViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_view,parent,false);
        return new CatrgoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  CategoryAdapter.CatrgoryViewHolder holder, int position) {

        CategoryHelperClass catClass = categoryHelperClasses.get(position);

        holder.gradient.setBackground(catClass.gradient);
        holder.image.setImageResource(catClass.image);
        holder.title.setText(catClass.title);


    }

    @Override
    public int getItemCount() {
        return categoryHelperClasses.size();
    }

    public static class CatrgoryViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout gradient;
        ImageView image;
        TextView title;

        public CatrgoryViewHolder(@NonNull View itemView) {
            super(itemView);
            gradient = itemView.findViewById(R.id.cat_layout);
            image = itemView.findViewById(R.id.cat_image);
            title = itemView.findViewById(R.id.cat_title);

        }
    }
}
