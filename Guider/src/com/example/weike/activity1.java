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
	// ����TabHost����
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
		// ͨ��FindViewByID�ҵ�ÿ���ؼ�
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

		// ������listView���ò���������
		listView1.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, new String[] { "����", "����",
						"�Ϻ�", "����", "�Ϻ�", "����", "�Ϻ�", "����", "�Ϻ�", "����", "�Ϻ�",
						"����", "�Ϻ�", "����", "�Ϻ�", "����", "�Ϻ�", "����", "�Ϻ�", "����",
						"�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "����", "�Ϻ�",
						"guizhou", "�Ϻ�", "guangd", "guizhou", "�Ϻ�", "guizhou",
						"�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou",
						"�Ϻ�", "����", "�Ϻ�", "����", "�Ϻ�", "����", "�Ϻ�", "����", "�Ϻ�",
						"����", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "����",
						"�Ϻ�", "guizhou", "�Ϻ�", "guangd", "guizhou", "�Ϻ�",
						"guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�",
						"guizhou", "�Ϻ�" }));

		listView2.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, new String[] { "nanjin",
						"����", "�Ϻ�", "����", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou",
						"�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou",
						"�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou",
						"�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou",
						"�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou",
						"�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "����", "�Ϻ�",
						"����", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�",
						"guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�",
						"guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�",
						"guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�",
						"guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�",
						"guizhou", "�Ϻ�", "guizhou", "�Ϻ�" }));
		listView3.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, new String[] { "����",
						"guizhou", "�Ϻ�", "guizhou", "guizhou", "�Ϻ�", "guizhou",
						"�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou",
						"�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou",
						"�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou",
						"�Ϻ�", "guizhou", "�Ϻ�", "�Ϻ�", "guizhou", "�Ϻ�",
						"guizhou", "�Ϻ�", "guizhou", "guizhou", "�Ϻ�", "guizhou",
						"�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou",
						"�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou",
						"�Ϻ�", "guizhou", "�Ϻ�", "guizhou", "�Ϻ�", "guizhou",
						"�Ϻ�", "guizhou", "�Ϻ�", "�Ϻ�", "guizhou", "�Ϻ�" }));
		// ȡ��TabHost����
		mTabHost = getTabHost();

		/* ΪTabHost��ӱ�ǩ */
		// �½�һ��newTabSpec(newTabSpec)
		// �������ǩ��ͼ��(setIndicator)
		// ��������(setContent)
		mTabHost.addTab(mTabHost
				.newTabSpec("tab_test1")
				.setIndicator("Ŀ¼",
						getResources().getDrawable(R.drawable.discuss))
				.setContent(R.id.line1));
		mTabHost.addTab(mTabHost
				.newTabSpec("tab_test2")
				.setIndicator("����",
						getResources().getDrawable(R.drawable.content))
				.setContent(R.id.line2));
		mTabHost.addTab(mTabHost
				.newTabSpec("tab_test3")
				.setIndicator("�ʼ�", getResources().getDrawable(R.drawable.xt16))
				.setContent(R.id.line3));

		// ����TabHost�ı�����ɫ
		// mTabHost.setBackgroundColor(Color.argb(50, 10, 70, 150));
		// ����TabHost�ı���ͼƬ��Դ
		mTabHost.setBackgroundResource(R.drawable.topic);

		// ���õ�ǰ��ʾ��һ����ǩ
		mTabHost.setCurrentTab(0);

		// ��ǩ�л��¼�����setOnTabChangedListener
		mTabHost.setOnTabChangedListener(new OnTabChangeListener() {
			// TODO Auto-generated method stub
			@Override
			public void onTabChanged(String tabId) {

			}
		});
		// ����listView��item�ĵ��ʱ��
		listView1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(
						activity1.this,
						"��������    "
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
						"��������    "
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
						"��������    "
								+ listView3.getItemAtPosition(position)
										.toString(), 0).show();
			}
		});
	
		
	
	}

}
