package com.kit.imagelib.imageloader;

public interface RequestListener<R> {

  void onLoadFailed();

  void onResourceReady(R resource);
}
