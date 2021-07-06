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

public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedAdapter.MostViewHolder> {

    ArrayList<MostViewedHelperClass> mostViewedHelperClasses;

    public MostViewedAdapter(ArrayList<MostViewedHelperClass> mostViewedHelperClasses) {
        this.mostViewedHelperClasses = mostViewedHelperClasses;
    }

    @NonNull
    @Override
    public MostViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_view,parent,false);
        return new MostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  MostViewedAdapter.MostViewHolder holder, int position) {

        MostViewedHelperClass mvClass = mostViewedHelperClasses.get(position);

        holder.image.setImageResource(mvClass.image);
        holder.title.setText(mvClass.title);
        holder.desc.setText(mvClass.desc);

    }

    @Override
    public int getItemCount() {
        return mostViewedHelperClasses.size();
    }

    public static class MostViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title,desc;

        public MostViewHolder(@NonNull  View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.mv_image);
            title = itemView.findViewById(R.id.mv_title);
            desc = itemView.findViewById(R.id.mv_desc);
        }
    }
}
