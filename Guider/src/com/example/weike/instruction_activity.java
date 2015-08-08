package com.example.weike;

import java.util.ArrayList;
import java.util.List;

import com.example.weike.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * ��һ��ʵ�ֵ��������ݿ�״̬�µ�������ʾ
 * �ڶ����ڴ�ҳ��ʵ�ֶ����ݿ��еĿγ̽��м���
 * ͨ���γ����ҵ����ݿ��ж�Ӧ��ID��Ȼ����ص���ҳ����ʾ
 */
public class instruction_activity extends Activity {
	private TextView course_name,course_source,course_brif_introducation;
	private ImageView course_mindmap;
	private ListView listView_courses;
	private Button backforward;
//	private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.instruction_activity);
    	backforward =(Button) findViewById(R.id.backforward);
    	backforward.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(instruction_activity.this,main.class);
				startActivity(intent);
			}
		});
    	course_name = (TextView) findViewById(R.id.course_name);
    	course_source=(TextView) findViewById(R.id.course_source);
    	course_brif_introducation = (TextView) findViewById(R.id.course_brif_introducation);
    	course_mindmap = (ImageView) findViewById(R.id.course_mindmap);
    	listView_courses = (ListView) findViewById(R.id.listView_courses);
    	
    	listView_courses.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getData()));
    	listView_courses.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?>  parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				
				Toast.makeText(instruction_activity.this, "�����"+listView_courses.getItemAtPosition(position).toString(), 0).show();
			}
    		
		});
    }
	public List<String> getData() {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i < 100; i++) {
			list.add("JSP������Ƶ�   " + i + "  ��");
		}
		return list;
	}
	
	
    
}
