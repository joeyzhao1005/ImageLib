package com.kit.imagelib.imageloader;

import android.graphics.ImageDecoder;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;

import androidx.annotation.Nullable;


public abstract class ImageAnimListener {
    public void onAnimationStart(Drawable drawable) {
//        LogUtils.d("ZhaoAnim", "onAnimationStart:" + drawable);
    }

    public void onAnimationStop(Drawable drawable) {
//        LogUtils.d("ZhaoAnim", "onAnimationStop:" + drawable);
    }

    public void onAnimationReset(Drawable drawable) {
//        LogUtils.d("ZhaoAnim", "onAnimationReset:" + drawable);

    }

    public void onAnimationRepeat(Drawable drawable) {
//        LogUtils.d("ZhaoAnim", "onAnimationRepeat:" + drawable);
    }

    public void onAnimationFrame(Drawable drawable, int frameNumber) {
//        LogUtils.d("ZhaoAnimFrame", "onAnimationFrame drawable.getFrameCount():" + drawable.getFrameCount() + " now:" + frameNumber + " isRunning():" + drawable.isRunning());
    }


    public void onFinalImageSet(
            String id,
            @Nullable ImageDecoder.ImageInfo imageInfo,
            @Nullable Animatable animatable) {
//        LogUtils.d("ZhaoAnim", "onFinalImageSet:" + id);
    }

    public void onLoadFail(String uri) {
//        LogUtils.d("ZhaoAnim", "onLoadFail:" + uri);
    }

    public void onRelease(String uri) {
//        LogUtils.d("ZhaoAnim", "onRelease:" + uri);
    }

}
