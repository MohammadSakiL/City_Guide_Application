package com.example.cityguide.HelperClass.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguide.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    ArrayList<FeaturedHelperClass> featuredHelperClasses;

    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredHelperClasses) {
        this.featuredHelperClasses = featuredHelperClasses;
    }

    @NonNull

    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_view,parent,false);
        return new FeaturedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  FeaturedAdapter.FeaturedViewHolder holder, int position) {
        FeaturedHelperClass fClass = featuredHelperClasses.get(position);

        holder.image.setImageResource(fClass.getImage());
        holder.title.setText(fClass.title);
        holder.desc.setText(fClass.desc);
    }

    @Override
    public int getItemCount() {
        return featuredHelperClasses.size();
    }


    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title,desc;

        public FeaturedViewHolder(@NonNull  View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.featured_image);
            title = itemView.findViewById(R.id.featured_title);
            desc = itemView.findViewById(R.id.featured_desc);
        }
    }

}
