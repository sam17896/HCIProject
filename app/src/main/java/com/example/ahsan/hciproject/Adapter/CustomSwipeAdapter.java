package com.example.ahsan.hciproject.Adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.ahsan.hciproject.R;

/**
 * Created by Sohail Arshad on 11/10/2017.
 */

public class CustomSwipeAdapter extends PagerAdapter {
    private int[] image_resources = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g
    };

    private Context context;
    private LayoutInflater layoutInflater;
    public CustomSwipeAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view= layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView = item_view.findViewById(R.id.image_view);
        TextView textView = item_view.findViewById(R.id.image_count);

        imageView.setImageResource(image_resources[position]);
        textView.setText("image: " + position);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
