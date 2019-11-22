package com.kit.imagelib.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;

import com.kit.app.Callback;
import com.kit.app.SourceWapper;
import com.kit.app.application.AppMaster;
import com.kit.utils.ResWrapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 负责引导使用
 */
public class ImageLoadController {

    public static class LoadStep {
        protected ImageLoader.IImageLoader imageLoader;
        protected Uri mUri;
        protected ImageConfig mImageConfig;

        protected int loopCount;

        ImageConfigStep imageConfigStep;

        public ImageLoader.IImageLoader getImageLoader() {
            return imageLoader;
        }

        public Uri getUri() {
            return mUri;
        }

        public ImageConfig getImageConfig() {
            return mImageConfig;
        }


        public int getLoopCount() {
            return loopCount;
        }

        public ImageConfigStep getImageConfigStep() {
            return imageConfigStep;
        }

        public LoadStep(File file) {
            mUri = Uri.parse("file://" + file.getAbsolutePath());
        }

        public LoadStep(Context context, int resId) {
            mUri = Uri.parse("res://" + context.getPackageName() + "/" + resId);
        }

        public LoadStep(String url) {
            if (url == null) {
                mUri = Uri.EMPTY;
            } else {

                switch (SourceWapper.getType(url)) {
                    case "asset":
                        url = "file:///android_asset" + File.separator + SourceWapper.get(url);
                        break;

                    case "res":
                        url = "android.resource://" + AppMaster.getInstance().getApplicationId() + File.separator + SourceWapper.get(url);
                        break;

                    default:
                        break;
                }
                mUri = Uri.parse(url);
            }
        }

        public LoadStep(Uri uri) {
            if (uri == null) {
                mUri = Uri.EMPTY;
            } else {
                mUri = uri;
            }
        }

        public void setImageLoader(ImageLoader.IImageLoader imageLoader) {
            this.imageLoader = imageLoader;
        }

        /**
         * 非webp、gif动画 请务必不要调用
         *
         * @return
         */
        public LoadStep loop() {
            this.loopCount = -1;
            return this;
        }

        /**
         * 非webp、gif动画 请务必不要调用
         *
         * @return
         */
        public LoadStep loop(int loopCount) {
            this.loopCount = loopCount;
            return this;
        }


        void setImageConfig(ImageConfig imageConfig) {
            mImageConfig = imageConfig;
        }


        /**
         * 图片显示的各种配置，如：缩放，占位图等等，需结合 {@link #into(ImageView)}
         * <p>
         * 你也可以直接对 ImageView 的 Hierarchy 操作
         *
         * @return
         */
        public ImageConfigStep imageConfig() {
            if (imageConfigStep == null) {
                imageConfigStep = new ImageConfigStep(this);
            }
            return imageConfigStep;
        }


        /**
         * 加载图片到 View 上
         *
         * @param draweeView
         */
        public void into(ImageView draweeView, ImageAnimListener animationListener) {
            into(draweeView, null, animationListener);
        }


        /**
         * 加载图片到 View 上
         *
         * @param draweeView
         */
        public void into(ImageView draweeView, RequestListener controllerListener) {
            into(draweeView, controllerListener, null);
        }

        /**
         * 加载图片到 View 上
         *
         * @param draweeView
         */
        public void into(ImageView draweeView) {
            into(draweeView, null, null);
        }

        /**
         * 加载图片到 View 上，可设置回调监听
         *
         * @param draweeView
         * @param listener
         */
        public void into(ImageView draweeView, RequestListener<Drawable> listener, ImageAnimListener animationListener) {
            if (imageLoader != null) {
                imageLoader.into(this,draweeView,listener,animationListener);
            }

        }

    }

    public static class DownloadStep extends LoadStep {

        public DownloadStep(File file) {
            super(file);
        }

        public DownloadStep(Context context, int resId) {
            super(context, resId);
        }

        public DownloadStep(String url) {
            super(url);
        }

        public DownloadStep(Uri uri) {
            super(uri);
        }

        /**
         * 只下载图片到磁盘
         *
         * @param context
         */
        public void downloadOnly(Context context) {
            downloadOnly(context, null);
        }

        /**
         * 只下载图片到磁盘，可设置下载回调
         *
         * @param context
         */
        public void downloadOnly(Context context, Callback<String> callback) {
            //TODO 未做

        }
    }

    public static class ImageConfigStep {
        private LoadStep mLoadStep;
        private ImageConfig mImageConfig;

        public ImageConfigStep(LoadStep loadStep) {
            mLoadStep = loadStep;
            mImageConfig = new ImageConfig();
        }

        /**
         * 完成配置，继续下一步引导
         *
         * @return
         */
        public LoadStep configImage() {
//            if (mImageConfig.scaleType == null) {
//                scaleType(ImageView.ScaleType.FIT_CENTER);
//            }
            mLoadStep.setImageConfig(mImageConfig);
            return mLoadStep;
        }

        /**
         * 减少图片分辨率，降低内存占用
         * 注意：对于动态webp，fresco不支持resize
         *
         * @param width  >0
         * @param height >0
         * @return
         */
        public ImageConfigStep resize(int width, int height) {
            mImageConfig.mWidth = width;
            mImageConfig.mHeight = height;
            return this;
        }

        public ImageConfigStep animFade() {
            mImageConfig.animFade = true;
            return this;
        }

        public ImageConfigStep scaleType(ImageView.ScaleType scaleType) {
            mImageConfig.scaleType = scaleType;
            return this;
        }


        public ImageConfigStep placeholder(Drawable drawable) {
            mImageConfig.placeholderDrawable = drawable;
            return this;
        }

        public ImageConfigStep placeholder(int resId) {
            mImageConfig.placeholderResId = resId;
            return this;
        }


        public ImageConfigStep failure(Drawable drawable) {
            mImageConfig.failureDrawable = drawable;
            return this;
        }

        public ImageConfigStep failure(int resId) {
            mImageConfig.failureResId = resId;
            return this;
        }


        public ImageConfigStep fallback(Drawable drawable) {
            mImageConfig.fallbackDrawable = drawable;
            return this;
        }

        public ImageConfigStep fallback(int resId) {
            mImageConfig.fallbackResId = resId;
            return this;
        }


        public ImageConfigStep asCircle() {
            mImageConfig.asCircle = true;
            return this;
        }

        public ImageConfigStep notAsCircle() {
            mImageConfig.asCircle = false;
            return this;
        }

        public ImageConfigStep loop(int loopCount) {
            mImageConfig.loopCount = loopCount;
            return this;
        }


        public ImageConfigStep asRound(int radius) {
            mImageConfig.asRound = true;
            mImageConfig.cornerRadius = radius;
            return this;
        }

        public ImageConfigStep cornersRadii(int[] cornersRadii) {
            mImageConfig.asRound = true;
            mImageConfig.cornersRadii = cornersRadii;
            return this;
        }


        public ImageConfigStep roundBorderWidth(int width) {
            mImageConfig.roundBorderWidth = width;
            return this;
        }

        public ImageConfigStep roundBorderColor(int color) {
            mImageConfig.roundBorderColor = color;
            return this;
        }


        public ImageConfigStep noTransformation() {
            mImageConfig.noTransformation = true;
            return this;
        }

        public ImageConfigStep forceStaticImage() {
            mImageConfig.forceStaticImage = true;
            return this;
        }

        public ImageConfigStep background(int color) {
            mImageConfig.backgroundColor = color;
            return this;
        }


        public ImageConfigStep background(Drawable drawable) {
            mImageConfig.backgroundDrawable = drawable;
            return this;
        }

        public ImageConfigStep backgroundColor(@ColorRes int color) {
            mImageConfig.backgroundColor = color;
            return this;
        }

        public ImageConfigStep backgroundDrawable(@DrawableRes int drawableResId) {
            mImageConfig.backgroundDrawable = ResWrapper.getDrawable(drawableResId);
            return this;
        }


        /**
         * 所有配置项是否应用在全新的 Hierarchy 中，默认使用 ImageView 自带的 Hierarchy
         *
         * @return
         */
        public ImageConfigStep useNewHierarchy() {
            mImageConfig.useNewHierarchy = true;
            return this;
        }
    }

    public static class ImageConfig {
        boolean useNewHierarchy = false;

        ImageView.ScaleType scaleType;

        Drawable placeholderDrawable = null;
        int placeholderResId = -1;

        Drawable failureDrawable;
        int failureResId = -1;

        Drawable fallbackDrawable;
        int fallbackResId = -1;


        int loopCount = -1;
        boolean asCircle = false;
        boolean asRound = false;
        boolean forceStaticImage = false;
        boolean noTransformation = false;

        int[] cornersRadii = null;


        int backgroundColor = -1;
        Drawable backgroundDrawable = null;

        boolean animFade = false;


        int cornerRadius = -1;

        int roundBorderWidth = -1;
        int roundBorderColor = -1;

        int mWidth,mHeight;


        public int getWidth() {
            return mWidth;
        }

        public int getHeight() {
            return mHeight;
        }

        public boolean isUseNewHierarchy() {
            return useNewHierarchy;
        }



        public ImageView.ScaleType getScaleType() {
            return scaleType;
        }

        public Drawable getPlaceholderDrawable() {
            return placeholderDrawable;
        }

        public int getPlaceholderResId() {
            return placeholderResId;
        }

        public Drawable getFailureDrawable() {
            return failureDrawable;
        }

        public int getFailureResId() {
            return failureResId;
        }

        public Drawable getFallbackDrawable() {
            return fallbackDrawable;
        }

        public int getFallbackResId() {
            return fallbackResId;
        }

        public int getLoopCount() {
            return loopCount;
        }

        public boolean isAsCircle() {
            return asCircle;
        }

        public boolean isAsRound() {
            return asRound;
        }

        public boolean isForceStaticImage() {
            return forceStaticImage;
        }

        public boolean isNoTransformation() {
            return noTransformation;
        }

        public int[] getCornersRadii() {
            return cornersRadii;
        }

        public int getBackgroundColor() {
            return backgroundColor;
        }

        public Drawable getBackgroundDrawable() {
            return backgroundDrawable;
        }

        public boolean isAnimFade() {
            return animFade;
        }

        public int getCornerRadius() {
            return cornerRadius;
        }

        public int getRoundBorderWidth() {
            return roundBorderWidth;
        }

        public int getRoundBorderColor() {
            return roundBorderColor;
        }
    }
}