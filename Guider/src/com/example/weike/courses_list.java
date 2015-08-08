package com.example.weike;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.weike.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class courses_list extends Activity {

	private Button btn_search;
	private GridView gridview;
	private MyAdapter adapter;
	private Button search;

	// private int images[] = { R.drawable.weikephoto20150729005,
	// R.drawable.weikephoto20150729002, R.drawable.weikephoto20150729003,
	// R.drawable.weikephoto20150729004, R.drawable.weikephoto20150729011,
	// R.drawable.weikephoto20150729006, R.drawable.weikephoto20150729007,
	// R.drawable.weikephoto20150729008, R.drawable.weikephoto20150729009,
	// R.drawable.weikephoto20150729010, R.drawable.weikephoto20150729001,
	// R.drawable.weikephoto20150729005, R.drawable.weikephoto20150729002,
	// R.drawable.weikephoto20150729003, R.drawable.weikephoto20150729004,
	// R.drawable.weikephoto20150729011, R.drawable.weikephoto20150729006,
	// R.drawable.weikephoto20150729007, R.drawable.weikephoto20150729008,
	// R.drawable.weikephoto20150729009, R.drawable.weikephoto20150729010,
	// R.drawable.weikephoto20150729001 };
	// private String names[] = { "ʮ����ФAPP�����̳�", "���ﳵ���ܽ���", "��Դ������", "�������ֳ",
	// "autoCompleteTextView����", "ˮ����_ ����������", "ˮ����_��֦������",
	// "ˮ����_���ѵİ�˪��ʲô", "ˮ����֮���������⨺���", "ͼ����Ӧ�ü��", "�ɹ���ʿ���߸�����ϰ��",
	// "ʮ����ФAPP�����̳�", "���ﳵ���ܽ���", "��Դ������", "�������ֳ",
	// "autoCompleteTextView����", "ˮ����_ ����������", "ˮ����_��֦������",
	// "ˮ����_���ѵİ�˪��ʲô", "ˮ����֮���������⨺���", "ͼ����Ӧ�ü��", "�ɹ���ʿ���߸�����ϰ��" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.courses_list);
		search = (Button) findViewById(R.id.search);
		gridview = (GridView) findViewById(R.id.gridView1);
		adapter = new MyAdapter(this);
		gridview.setAdapter(adapter);
//		gridview.setAdapter(new MyAdapter());
		

		// ArrayList<HashMap<String, Object>> lstImageItem = new
		// ArrayList<HashMap<String, Object>>();
		// {
		// for (int i = 0; i < images.length; i++) {
		// HashMap<String, Object> map = new HashMap<String, Object>();
		// map.put("itemImage", images[i]);
		// map.put("itemText", names[i]);
		// lstImageItem.add(map);
		// }
		//
		// SimpleAdapter saImageItems = new SimpleAdapter(this, lstImageItem,//
		// ����Դ
		// R.layout.item1,// ��ʾ����
		// new String[] { "itemImage", "itemText" }, new int[] {
		// R.id.imageView1, R.id.textView1 });
		// gridview.setAdapter(saImageItems);
		//
		// }

		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(courses_list.this,
						"��ѡ�����     " + gridview.getItemAtPosition(position).toString() + "   �γ�",
						0).show();
				Intent intent = new Intent(courses_list.this,instruction_activity.class);
				startActivity(intent);
			}
		});
		search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(courses_list.this, "������������ť", 0).show();
			}
		});
	}

	static class MyAdapter extends BaseAdapter {

		private Context context;
		private int images[] = { R.drawable.weikephoto20150729005,
				R.drawable.weikephoto20150729002,
				R.drawable.weikephoto20150729003,
				R.drawable.weikephoto20150729004,
				R.drawable.weikephoto20150729011,
				R.drawable.weikephoto20150729006,
				R.drawable.weikephoto20150729007,
				R.drawable.weikephoto20150729008,
				R.drawable.weikephoto20150729009,
				R.drawable.weikephoto20150729010,
				R.drawable.weikephoto20150729001, };
		private String names[] = { "ʮ����ФAPP�����̳�", "���ﳵ���ܽ���", "��Դ������", "�������ֳ",
				"autoCompleteTextView����", "ˮ����_ ����������", "ˮ����_��֦������",
				"ˮ����_���ѵİ�˪��ʲô", "ˮ����֮���������⨺���", "ͼ����Ӧ�ü��", "�ɹ���ʿ���߸�����ϰ��", };
		public MyAdapter(Context context) {
			// TODO Auto-generated constructor stub
			this.context = context;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return names.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return names[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LayoutInflater inflater = LayoutInflater.from(context);
			View view = inflater.inflate(R.layout.every_course_list_style, null);
			ImageView iv = (ImageView) view.findViewById(R.id.imageView1);
			TextView tv =(TextView) view.findViewById(R.id.textView1);
			iv.setImageResource(images[position]);
			tv.setText(names[position]);
			
			return view;
		}

	}

}
