package com.example.weike;

import com.example.weike.R;
import com.example.weike.OpenHelper.SqliteOpenHelper;

import android.app.TabActivity;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

public class activity1 extends TabActivity {

	private SQLiteDatabase db;
	private SqliteOpenHelper mysql;
	// 声明TabHost对象
	TabHost mTabHost;
	private ListView listView1, listView2, listView3;
	private Button load;
	private EditText edit_note;
	private CheckBox ck_baomi, ck_save_zhudian;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table);
		// 通过FindViewByID找到每个控件
		listView1 = (ListView) findViewById(R.id.listView1);
		listView2 = (ListView) findViewById(R.id.listView2);
		listView3 = (ListView) findViewById(R.id.listView3);
		load = (Button) findViewById(R.id.load);
		edit_note = (EditText) findViewById(R.id.editText1);
		ck_baomi = (CheckBox) findViewById(R.id.checkBox1);
		ck_save_zhudian = (CheckBox) findViewById(R.id.checkBox2);

		// listView1.setOnItemClickListener(this);
		// listView2.setOnItemClickListener(this);
		// listView3.setOnItemClickListener(this);

		// 对三个listView设置并绑定适配器
		listView1.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, new String[] { "兰州", "北京",
						"上海", "北京", "上海", "北京", "上海", "北京", "上海", "北京", "上海",
						"北京", "上海", "北京", "上海", "北京", "上海", "北京", "上海", "北京",
						"上海", "guizhou", "上海", "guizhou", "上海", "北京", "上海",
						"guizhou", "上海", "guangd", "guizhou", "上海", "guizhou",
						"上海", "guizhou", "上海", "guizhou", "上海", "guizhou",
						"上海", "北京", "上海", "北京", "上海", "北京", "上海", "北京", "上海",
						"北京", "上海", "guizhou", "上海", "guizhou", "上海", "北京",
						"上海", "guizhou", "上海", "guangd", "guizhou", "上海",
						"guizhou", "上海", "guizhou", "上海", "guizhou", "上海",
						"guizhou", "上海" }));

		listView2.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, new String[] { "nanjin",
						"北京", "上海", "北京", "上海", "guizhou", "上海", "guizhou",
						"上海", "guizhou", "上海", "guizhou", "上海", "guizhou",
						"上海", "guizhou", "上海", "guizhou", "上海", "guizhou",
						"上海", "guizhou", "上海", "guizhou", "上海", "guizhou",
						"上海", "guizhou", "上海", "guizhou", "上海", "guizhou",
						"上海", "guizhou", "上海", "guizhou", "上海", "北京", "上海",
						"北京", "上海", "guizhou", "上海", "guizhou", "上海",
						"guizhou", "上海", "guizhou", "上海", "guizhou", "上海",
						"guizhou", "上海", "guizhou", "上海", "guizhou", "上海",
						"guizhou", "上海", "guizhou", "上海", "guizhou", "上海",
						"guizhou", "上海", "guizhou", "上海", "guizhou", "上海",
						"guizhou", "上海", "guizhou", "上海" }));
		listView3.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, new String[] { "兰州",
						"guizhou", "上海", "guizhou", "guizhou", "上海", "guizhou",
						"上海", "guizhou", "上海", "guizhou", "上海", "guizhou",
						"上海", "guizhou", "上海", "guizhou", "上海", "guizhou",
						"上海", "guizhou", "上海", "guizhou", "上海", "guizhou",
						"上海", "guizhou", "上海", "上海", "guizhou", "上海",
						"guizhou", "上海", "guizhou", "guizhou", "上海", "guizhou",
						"上海", "guizhou", "上海", "guizhou", "上海", "guizhou",
						"上海", "guizhou", "上海", "guizhou", "上海", "guizhou",
						"上海", "guizhou", "上海", "guizhou", "上海", "guizhou",
						"上海", "guizhou", "上海", "上海", "guizhou", "上海" }));
		// 取得TabHost对象
		mTabHost = getTabHost();

		/* 为TabHost添加标签 */
		// 新建一个newTabSpec(newTabSpec)
		// 设置其标签和图标(setIndicator)
		// 设置内容(setContent)
		mTabHost.addTab(mTabHost
				.newTabSpec("tab_test1")
				.setIndicator("目录",
						getResources().getDrawable(R.drawable.discuss))
				.setContent(R.id.line1));
		mTabHost.addTab(mTabHost
				.newTabSpec("tab_test2")
				.setIndicator("讨论",
						getResources().getDrawable(R.drawable.content))
				.setContent(R.id.line2));
		mTabHost.addTab(mTabHost
				.newTabSpec("tab_test3")
				.setIndicator("笔记", getResources().getDrawable(R.drawable.xt16))
				.setContent(R.id.line3));

		// 设置TabHost的背景颜色
		// mTabHost.setBackgroundColor(Color.argb(50, 10, 70, 150));
		// 设置TabHost的背景图片资源
		mTabHost.setBackgroundResource(R.drawable.topic);

		// 设置当前显示哪一个标签
		mTabHost.setCurrentTab(0);

		// 标签切换事件处理，setOnTabChangedListener
		mTabHost.setOnTabChangedListener(new OnTabChangeListener() {
			// TODO Auto-generated method stub
			@Override
			public void onTabChanged(String tabId) {

			}
		});
		// 三个listView中item的点击时间
		listView1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(
						activity1.this,
						"你点击的是    "
								+ listView1.getItemAtPosition(position)
										.toString(), 0).show();
			}
		});
		listView2.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(
						activity1.this,
						"你点击的是    "
								+ listView2.getItemAtPosition(position)
										.toString(), 0).show();
			}
		});
		listView3.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(
						activity1.this,
						"你点击的是    "
								+ listView3.getItemAtPosition(position)
										.toString(), 0).show();
			}
		});
	
		
	
	}

}
