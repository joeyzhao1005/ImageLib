package com.kit.imagelib.uitls;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kit.imagelib.R;

/**
 * Created by Zhao on 15/5/25.
 */
public class GlideUtils {


    public static void display(Context context, ImageView imageView, String url, Drawable drawablePlace, Drawable drawableError) {
        if (url == null || TextUtils.isEmpty(url))
            return;
        RequestOptions options = new RequestOptions();
        options.placeholder(drawablePlace)
                .error(drawableError)
                .centerCrop()
                .fitCenter();
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }


    public static void display(Context context, ImageView imageView, String url) {
        if (url == null || TextUtils.isEmpty(url))
            return;
        RequestOptions options = new RequestOptions();
        options.error(R.drawable.no_picture)
                .centerCrop()
                .fitCenter();

        Glide.with(context)
                .load(url)
                .into(imageView);
    }

}
