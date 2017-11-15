package com.example.ahsan.hciproject.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ahsan.hciproject.R;
import com.example.ahsan.hciproject.entity.DealItem;

import java.util.List;

/**
 * Created by AHSAN on 11/15/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private List<DealItem> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price;
        public ImageView imageView;
        public MyViewHolder(View view) {
            super(view);
            title =  view.findViewById(R.id.title);
            price =  view.findViewById(R.id.price);
            imageView =  view.findViewById(R.id.image);
        }
    }


    public ItemAdapter(List<DealItem> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_listview, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DealItem dealItem = moviesList.get(position);
        holder.title.setText(dealItem.getName());
        holder.price.setText(dealItem.getPrice());
        Glide.with(holder.imageView.getContext()).load(dealItem.getImage_url()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}