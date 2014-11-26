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
				.add("http://c.hiphotos.baidu.com/image/pic/item/500fd9f9d72a60596f5cd7652b34349b033bba04.jpg");
		imagesList
				.add("http://e.hiphotos.baidu.com/image/pic/item/b90e7bec54e736d1630e8b6498504fc2d56269b8.jpg");
		imagesList
				.add("http://b.hiphotos.baidu.com/image/pic/item/8d5494eef01f3a294cd5d2a29a25bc315c607cb8.jpg");
		imagesList
				.add("http://d.hiphotos.baidu.com/image/pic/item/023b5bb5c9ea15cead3d6f2ab5003af33b87b2c6.jpg");
		imagesList
				.add("http://g.hiphotos.baidu.com/image/pic/item/9e3df8dcd100baa1cb1cc9984410b912c8fc2ee4.jpg");
		imagesList
				.add("http://h.hiphotos.baidu.com/image/pic/item/35a85edf8db1cb1336c81477de54564e92584b34.jpg");
		imagesList
				.add("http://e.hiphotos.baidu.com/image/pic/item/37d12f2eb9389b502b5ec8368635e5dde7116e34.jpg");
		imagesList
				.add("http://g.hiphotos.baidu.com/image/pic/item/d009b3de9c82d158c2b2f42a820a19d8bc3e427c.jpg");
		imagesList
				.add("http://e.hiphotos.baidu.com/image/pic/item/4afbfbedab64034f246e617dacc379310a551d2d.jpg");
		imagesList
				.add("http://b.hiphotos.baidu.com/image/pic/item/8435e5dde71190ef9f463825cc1b9d16fcfa608f.jpg");
		imagesList
				.add("http://f.hiphotos.baidu.com/image/pic/item/d833c895d143ad4bec56de4c80025aafa50f06c5.jpg");
		imagesList
				.add("http://h.hiphotos.baidu.com/image/pic/item/caef76094b36acafe9cd0e707ed98d1001e99c09.jpg");
		imagesList
				.add("http://b.hiphotos.baidu.com/image/pic/item/43a7d933c895d1436cd4f9bb71f082025baf0783.jpg");
		imagesList
				.add("http://g.hiphotos.baidu.com/image/pic/item/0eb30f2442a7d9338e2370bcaf4bd11372f00171.jpg");
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
