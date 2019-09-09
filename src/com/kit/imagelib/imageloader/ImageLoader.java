package com.kit.imagelib.imageloader;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;

import com.kit.app.SourceWapper;
import com.kit.app.application.AppMaster;
import com.kit.utils.ValueOf;

import java.io.File;


/**
 * 外部尽量不要直接使用ImageLoader
 * 对外统一使用LYGImage
 */
public class ImageLoader {


    private static ImageLoaderProvider imageLoaderProvider;

    private String uri;
    private String uid;
    private ImageLoadController.LoadStep step;
    private boolean isUseDefaultAvatarHolder = false;
    private boolean isUseDefaultAvatarError = false;
    private boolean isAsCircle = false;
    private boolean isForceStaticImage = false;
    private boolean noAnim;
    private boolean noCombine;

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
            step = new ImageLoadController.DownloadStep(uri);
        }
        createImageLoaderIfNeed();
        step.setImageLoader(iImageLoader);

        return step;
    }

    public ImageLoadController.ImageConfigStep imageConfig() {
        apply();
        return step.imageConfig();
    }


    public ImageLoader noAvatarPlaceHolder() {
        isUseDefaultAvatarHolder = false;
        return this;
    }


    public ImageLoader noAvatarFail() {
        isUseDefaultAvatarError = false;
        return this;
    }

    public ImageLoader noAsCircle() {
        isAsCircle = false;
        return this;
    }

    public ImageLoader noAnim() {
        this.noAnim = true;
        return this;
    }

    public ImageLoader source(String uri) {
        this.uri = uri;
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
        this.uri = SourceWapper.res(resId);
        return this;
    }

    /**
     * 加载file
     *
     * @return
     */
    public ImageLoader source(File file) {
        this.uri = SourceWapper.file(file);
        return this;
    }


    public ImageLoader avatar(long uid) {
        return avatar(ValueOf.toString(uid));
    }


    public ImageLoader avatar(String uid) {
        this.uid = uid;

        isUseDefaultAvatarHolder = true;
        isUseDefaultAvatarError = true;
        isAsCircle = true;

        //头像类 要强制静态显示 因为显示gif动图fresco不做剪切 强制静态显示之后 才能使用剪切
        isForceStaticImage = true;


        return this;
    }


    public ImageLoader noCombine() {
        this.noCombine = true;
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
