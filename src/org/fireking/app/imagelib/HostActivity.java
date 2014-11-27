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
				.add("http://a.hiphotos.baidu.com/image/pic/item/18d8bc3eb13533fae206ea2cabd3fd1f41345b7b.jpg");
		imagesList
				.add("http://g.hiphotos.baidu.com/image/pic/item/1ad5ad6eddc451da9f2e8e8cb5fd5266d11632f8.jpg");
		imagesList
				.add("http://c.hiphotos.baidu.com/image/pic/item/b3b7d0a20cf431ad99736b5d4836acaf2edd9834.jpg");
		imagesList
				.add("http://d.hiphotos.baidu.com/image/pic/item/6a63f6246b600c33c435e8b7194c510fd9f9a104.jpg");

		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383291_6518.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383291_8239.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383290_9329.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383290_1042.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383275_3977.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383265_8550.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383264_3954.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383264_4787.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383264_8243.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383248_3693.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383243_5120.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383242_3127.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383242_9576.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383242_1721.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383219_5806.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383214_7794.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383213_4418.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383213_3557.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383210_8779.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383172_4577.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383166_3407.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383166_2224.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383166_7301.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383165_7197.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383150_8410.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383131_3736.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383130_5094.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383130_7393.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383129_8813.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383100_3554.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383093_7894.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383092_2432.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383092_3071.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383091_3119.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383059_6589.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383059_8814.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383059_2237.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383058_4330.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406383038_3602.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382942_3079.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382942_8125.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382942_4881.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382941_4559.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382941_3845.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382924_8955.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382923_2141.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382923_8437.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382922_6166.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382922_4843.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382905_5804.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382904_3362.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382904_2312.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382904_4960.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382900_2418.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382881_4490.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382881_5935.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382880_3865.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382880_4662.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382879_2553.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382862_5375.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382862_1748.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382861_7618.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382861_8606.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382861_8949.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382841_9821.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382840_6603.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382840_2405.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382840_6354.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382839_5779.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382810_7578.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382810_2436.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382809_3883.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382809_6269.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382808_4179.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382790_8326.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382789_7174.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382789_5170.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382789_4118.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382788_9532.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382767_3184.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382767_4772.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382766_4924.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382766_5762.jpg");
		imagesList
				.add("http://img.my.csdn.net/uploads/201407/26/1406382765_7341.jpg");
		intent.putExtra("images", (Serializable) imagesList);
		intent.putExtra("position", 2);
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
