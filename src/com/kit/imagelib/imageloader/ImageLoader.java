package com.kit.imagelib.imageloader;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;

import com.kit.app.SourceWrapper;
import com.kit.utils.ResWrapper;

import java.io.File;


/**
 * 外部尽量不要直接使用ImageLoader
 * 对外统一使用LYGImage
 *
 * @author joeyzhao
 */
public class ImageLoader {


    private static ImageLoaderProvider imageLoaderProvider;

    private String uri;
    private Drawable drawable;
    private ImageLoadController.LoadStep step;

    private IImageLoader iImageLoader;

    public static void setImageLoaderProvider(ImageLoaderProvider provider) {
        imageLoaderProvider = provider;
    }

    private void createImageLoaderIfNeed() {
        if (imageLoaderProvider != null) {
            iImageLoader = imageLoaderProvider.create();
        }
    }

    private ImageLoadController.LoadStep apply() {
        if (step == null) {
            if (drawable != null) {
                step = new ImageLoadController.DownloadStep(drawable);
            } else {
                step = new ImageLoadController.DownloadStep(uri);
            }
        }
        createImageLoaderIfNeed();
        step.setImageLoader(iImageLoader);

        return step;
    }

    public ImageLoadController.ImageConfigStep imageConfig() {
        apply();
        return step.imageConfig();
    }


    public ImageLoader source(String uri) {
        if (uri.startsWith(File.separator)) {
            this.uri = SourceWrapper.file(uri);
        } else {
            this.uri = uri;
        }
        return this;
    }

    public ImageLoader source(Uri uri) {
        this.uri = uri.getPath();
        return this;
    }


    /**
     * 加载 res 内的资源图片
     *
     * @param resId
     * @return
     */
    public ImageLoader source(@DrawableRes int resId) {
        this.uri = SourceWrapper.res(resId);
        return this;
    }

    /**
     * 加载file
     *
     * @return
     */
    public ImageLoader source(File file) {
        this.uri = SourceWrapper.file(file);
        return this;
    }


    /**
     * 加载file
     *
     * @return
     */
    public ImageLoader source(Drawable drawable) {
        this.drawable = drawable;
        return this;
    }

    /**
     * 加载file
     *
     * @return
     */
    public ImageLoader source(Bitmap bitmap) {
        this.drawable = new BitmapDrawable(ResWrapper.getResources(), bitmap);
        return this;
    }

    /**
     * 加载图片到 View 上
     *
     * @param draweeView
     */
    public void into(ImageView draweeView, ImageAnimListener animationListener) {
        apply().into(draweeView, null, animationListener);
    }


    /**
     * 加载图片到 View 上
     *
     * @param draweeView
     */
    public void into(ImageView draweeView, RequestListener controllerListener) {
        apply().into(draweeView, controllerListener, null);
    }

    public void into(ImageView view) {
        apply().into(view, null, null);
    }


    public void resume() {
        createImageLoaderIfNeed();
        if (iImageLoader != null) {
            iImageLoader.resume();
        }
    }

    public void pause() {
        createImageLoaderIfNeed();
        if (iImageLoader != null) {
            iImageLoader.pause();
        }
    }

    public void clearCaches() {
        createImageLoaderIfNeed();
        if (iImageLoader != null) {
            iImageLoader.clearCaches();
        }
    }

    public void clearMemoryCaches() {
        createImageLoaderIfNeed();
        if (iImageLoader != null) {
            iImageLoader.clearMemoryCaches();
        }
    }

    public void clearDiskCaches() {
        createImageLoaderIfNeed();
        if (iImageLoader != null) {
            iImageLoader.clearDiskCaches();
        }
    }

    public static ImageLoader create() {

        return new ImageLoader();
    }


    public interface ImageLoaderProvider {
        IImageLoader create();
    }

    public interface IImageLoader {

        void resume();

        void pause();

        void clearCaches();

        void clearMemoryCaches();

        void clearDiskCaches();

        void into(ImageLoadController.LoadStep loadStep, ImageView imageView, RequestListener<Drawable> listener, ImageAnimListener animationListener);
    }

}
