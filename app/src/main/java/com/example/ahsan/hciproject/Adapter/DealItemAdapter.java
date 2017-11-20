package com.example.ahsan.hciproject.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ahsan.hciproject.R;
import com.example.ahsan.hciproject.entity.Item;

import java.util.List;

/**
 * Created by AHSAN on 11/20/2017.
 */

public class DealItemAdapter extends RecyclerView.Adapter<DealItemAdapter.MyViewHolder> {

    private List<Item> moviesList;
    private Context mContext;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price;
        public ImageView imageView;
        public Button btn;
        public MyViewHolder(View view) {
            super(view);
            title =  view.findViewById(R.id.title);
            price =  view.findViewById(R.id.price);
            imageView =  view.findViewById(R.id.image);
            btn  =  view.findViewById(R.id.btnChange);
            btn.setVisibility(View.INVISIBLE);
        }
    }


    public DealItemAdapter(List<Item> moviesList,Context context) {
        this.moviesList = moviesList; this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_deal_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Item dealItem = moviesList.get(position);
        holder.title.setText(dealItem.getName());
        holder.price.setText(dealItem.getPrice());
        if(dealItem.isBottle()){
            holder.btn.setVisibility(View.VISIBLE);
            Toast.makeText(mContext, "Visible", Toast.LENGTH_SHORT).show();
        }
        Glide.with(holder.imageView.getContext()).load(dealItem.getImage_url()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}