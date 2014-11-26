package org.fireking.app.imagelib.widget;

import java.util.ArrayList;
import java.util.List;

import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoView;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class ImageBrowserAdapter extends PagerAdapter {

	private List<String> mPhotos = new ArrayList<String>();
	Context context;

	public ImageBrowserAdapter(Context context, List<String> photos) {
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
		Bitmap bitmap = null;
		// 这里进行图片的缓存操作
		Picasso.with(context).load(mPhotos.get(position % mPhotos.size()))
				.into(photoView);
		photoView.setImageBitmap(bitmap);
		container.addView(photoView, LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		return photoView;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}
}
