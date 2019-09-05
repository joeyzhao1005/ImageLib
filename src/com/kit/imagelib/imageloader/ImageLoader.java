package com.kit.imagelib.imageloader;

import android.widget.ImageView;

public interface ImageLoader {
    void showFile(ImageView imageView, String filePath);

    void showGifFile(ImageView imageView, String filePath);


    void showFile(ImageView imageView, String filePath, RequestListener listener);

    void showGifFile(ImageView imageView, String filePath, RequestListener listener);
    void cancel(ImageView imageView);

}
