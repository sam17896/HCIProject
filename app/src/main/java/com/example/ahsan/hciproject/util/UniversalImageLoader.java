package com.example.ahsan.hciproject.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.ahsan.hciproject.R;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by Sohail Arshad on 8/1/2017.
 */

public class UniversalImageLoader {
    private static final int defaultImaage = R.drawable.ic_android;
    private Context mContext;

    public UniversalImageLoader(Context context){
        mContext = context;
    }

    public ImageLoaderConfiguration getConfig(){
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(defaultImaage)
                .showImageForEmptyUri(defaultImaage)
                .showImageOnFail(defaultImaage)
                .cacheOnDisk(true).cacheInMemory(true)
                .cacheOnDisk(true).resetViewBeforeLoading(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(mContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .diskCacheSize(100*1024*1024).build();

        return configuration;
    }

    public static void setImage(String imgURL, ImageView image, final ProgressBar progressBar, String append){
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(append + imgURL, image, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if(progressBar != null){
                    progressBar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if(progressBar !=null){
                    progressBar.setVisibility(View.GONE);
                }

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if(progressBar !=null){
                    progressBar.setVisibility(View.GONE);
                }

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if(progressBar !=null){
                    progressBar.setVisibility(View.GONE);
                }

            }
        });
    }
}
