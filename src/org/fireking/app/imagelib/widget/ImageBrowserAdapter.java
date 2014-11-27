package org.fireking.app.imagelib.widget;

import java.util.ArrayList;
import java.util.List;

import org.fireking.app.imagelib.entity.ImageBean;

import uk.co.senab.photoview.PhotoView;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class ImageBrowserAdapter extends PagerAdapter {

	private List<ImageBean> mPhotos = new ArrayList<ImageBean>();
	Context context;

	public ImageBrowserAdapter(Context context, List<ImageBean> photos) {
		this.context = context;
		if (photos != null) {
			mPhotos = photos;
		}
	}

	@Override
	public int getCount() {
		if (mPhotos.size() > 1) {
			return Integer.MAX_VALUE;
		}
		return mPhotos.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	@Override
	public View instantiateItem(ViewGroup container, int position) {
		PhotoView photoView = new PhotoView(container.getContext());
		// 这里进行图片的缓存操作
		Picasso.with(context).load(mPhotos.get(position % mPhotos.size()).path)
				.into(photoView);
		container.addView(photoView, LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		return photoView;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}
}
