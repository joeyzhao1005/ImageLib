package com.kit.imagelib.photoselector;

import com.kit.imagelib.AlbumBean;
import com.kit.imagelib.ImageBean;

public interface OnImageSelectedListener {
        void notifyChecked(AlbumBean albumBean, ImageBean imageBean, int postion);
    }