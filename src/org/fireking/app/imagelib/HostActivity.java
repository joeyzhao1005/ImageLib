package org.fireking.app.imagelib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.fireking.app.imagelib.entity.ImageBean;
import org.fireking.app.imagelib.widget.ImageBrowserActivity;
import org.fireking.app.imagelib.widget.PicSelectActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

public class HostActivity extends FragmentActivity {
	GridView image_selector;
	MyAdapter adapter;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.publish);
		image_selector = (GridView) this.findViewById(R.id.image_selector);
		adapter = new MyAdapter(this);
		image_selector.setAdapter(adapter);
	}

	public void test_grally(View view) {
		Intent intent = new Intent(this, ImageBrowserActivity.class);
		List<String> imagesList = new ArrayList<String>();
		imagesList
				.add("http://h.hiphotos.baidu.com/image/pic/item/5366d0160924ab1828b7c95336fae6cd7b890b34.jpg");
		imagesList
				.add("http://a.hiphotos.baidu.com/image/pic/item/18d8bc3eb13533fae206ea2cabd3fd1f41345b7b.jpg");
		imagesList
				.add("http://g.hiphotos.baidu.com/image/pic/item/1ad5ad6eddc451da9f2e8e8cb5fd5266d11632f8.jpg");
		imagesList
				.add("http://c.hiphotos.baidu.com/image/pic/item/b3b7d0a20cf431ad99736b5d4836acaf2edd9834.jpg");
		imagesList
				.add("http://d.hiphotos.baidu.com/image/pic/item/6a63f6246b600c33c435e8b7194c510fd9f9a104.jpg");
		imagesList
				.add("http://img5.imgtn.bdimg.com/it/u=1897883016,3898021083&fm=21&gp=0.jpg");
		imagesList
				.add("http://img2.imgtn.bdimg.com/it/u=1080950228,1050582948&fm=21&gp=0.jpg");
		imagesList
				.add("http://img3.imgtn.bdimg.com/it/u=1765096515,584663826&fm=21&gp=0.jpg");
		imagesList
				.add("http://img2.imgtn.bdimg.com/it/u=1942198271,3688690363&fm=21&gp=0.jpg");
		imagesList
				.add("http://img1.imgtn.bdimg.com/it/u=280482683,1427496842&fm=21&gp=0.jpg");
		imagesList
				.add("http://img4.imgtn.bdimg.com/it/u=213065468,2742478796&fm=21&gp=0.jpg");
		imagesList
				.add("http://img4.imgtn.bdimg.com/it/u=699789675,3758861195&fm=21&gp=0.jpg");
		imagesList
				.add("http://img0.imgtn.bdimg.com/it/u=3778595245,3376395273&fm=23&gp=0.jpg");
		imagesList
				.add("http://img4.imgtn.bdimg.com/it/u=885125359,2667289101&fm=23&gp=0.jpg");
		imagesList
				.add("http://img4.imgtn.bdimg.com/it/u=774122451,2872640083&fm=23&gp=0.jpg");
		imagesList
				.add("http://img2.imgtn.bdimg.com/it/u=2706350221,3692178365&fm=23&gp=0.jpg");
		imagesList
				.add("http://img5.imgtn.bdimg.com/it/u=2102586672,4220894331&fm=23&gp=0.jpg");
		imagesList
				.add("http://img4.imgtn.bdimg.com/it/u=1417739343,1025798077&fm=23&gp=0.jpg");
		imagesList
				.add("http://img4.imgtn.bdimg.com/it/u=2169800527,4077307855&fm=23&gp=0.jpg");
		imagesList
				.add("http://img1.imgtn.bdimg.com/it/u=3833673073,3269827972&fm=23&gp=0.jpg");
		imagesList
				.add("http://img5.imgtn.bdimg.com/it/u=1979450204,3496514545&fm=23&gp=0.jpg");
		imagesList
				.add("http://img1.imgtn.bdimg.com/it/u=3738379885,2881801084&fm=23&gp=0.jpg");
		imagesList
				.add("http://img1.imgtn.bdimg.com/it/u=3833673073,3269827972&fm=23&gp=0.jpg");
		imagesList
				.add("http://img0.imgtn.bdimg.com/it/u=629994361,4157197701&fm=23&gp=0.jpg");
		imagesList
				.add("http://img1.imgtn.bdimg.com/it/u=3467200855,3285163930&fm=23&gp=0.jpg");
		imagesList
				.add("http://img0.imgtn.bdimg.com/it/u=204993536,573935908&fm=23&gp=0.jpg");
		imagesList
				.add("http://img2.imgtn.bdimg.com/it/u=4206973903,1785707081&fm=23&gp=0.jpg");
		imagesList
				.add("http://img1.imgtn.bdimg.com/it/u=3454172964,633414511&fm=23&gp=0.jpg");
		intent.putExtra("images", (Serializable) imagesList);
		intent.putExtra("position", 5);
		startActivity(intent);
	}

	class MyAdapter extends BaseAdapter {
		Context context;
		List<ImageBean> beans;

		public MyAdapter(Context context) {
			this.context = context;
		}

		public void setData(List<ImageBean> beans) {
			this.beans = beans;
		}

		@Override
		public int getCount() {
			return beans == null || beans.size() == 0 ? 0 : beans.size();
		}

		@Override
		public Object getItem(int position) {
			return beans == null || beans.size() == 0 ? null : beans
					.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = View
						.inflate(context, R.layout.item_publish, null);
			}
			return convertView;
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 0x123 && resultCode == RESULT_OK) {
			Intent intent = data;
			List<ImageBean> images = (List<ImageBean>) intent
					.getSerializableExtra("images");
			for (ImageBean b : images) {
				System.out.println("<><<><> ???" + b.toString());
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
}
