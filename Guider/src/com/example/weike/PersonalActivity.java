package com.example.weike;

import java.util.Currency;

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
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PersonalActivity extends Activity {

	private ListView listView;
//	private ImageView imageView1,imageView2;
	private TextView tv_xiaoshishu,tv_jieshu;
	private ImageButton personalMessage;
	private MyAdapter adapter;
	private Intent intent = new Intent();
//	private Button feedback;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_personal);
		
		tv_jieshu=(TextView) findViewById(R.id.jieshu);
		tv_xiaoshishu=(TextView) findViewById(R.id.xiaoshishu);
		
		personalMessage= (ImageButton) findViewById(R.id.personalMessage);
		personalMessage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(PersonalActivity.this,personalMessage.class);
				intent.putExtra("title", "个人信息");
				startActivity(intent);
			}
		});
		listView = (ListView) findViewById(R.id.listView1);
		adapter= new MyAdapter(this);
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				String values = listView.getItemAtPosition(position).toString();
//				Toast.makeText(PersonalActivity.this, "当前点击的item值为"+values, 0).show();
			
				if(values.equals("我的课程")){
					
					intent.setClass(PersonalActivity.this,mycourses.class);
					intent.putExtra("title", values);
					startActivity(intent);
				}
				
				if(values.equals("直播课堂")){
					
					intent.setClass(PersonalActivity.this,livecourses.class);
					intent.putExtra("title1", values);
					startActivity(intent);
				}
				
				if(values.equals("观看历史")){
					intent.setClass(PersonalActivity.this,learninghistory.class);
					intent.putExtra("title2", values);
					startActivity(intent);
				}
				
				if(values.equals("我的疑问")){
					intent.setClass(PersonalActivity.this,myquestions.class);
					intent.putExtra("title3", values);
					startActivity(intent);
				}
				
				if(values.equals("我的笔记")){
					intent.setClass(PersonalActivity.this,mynotes.class);
					
					intent.putExtra("title4", values);
					startActivity(intent);
				}
				
			}
		});
			

//        feedback=(Button) findViewById(R.id.feed_back_btn);
//        feedback.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				Intent intent = new Intent(personalActivity.this,FeedbackMainActivity.class);
//				startActivity(intent);
//			}
//		});
	
		
	}
   public class MyAdapter extends BaseAdapter{

	   private int image1[] = {R.drawable.course,R.drawable.focuson,R.drawable.history,R.drawable.action_help1,R.drawable.note,R.drawable.course,R.drawable.focuson,R.drawable.history,R.drawable.action_help1,R.drawable.note,R.drawable.course,R.drawable.focuson,R.drawable.history,R.drawable.action_help1,R.drawable.note};
	   private String names[] = {"我的课程","直播课堂","观看历史","我的疑问","我的笔记","我的课程","直播课堂","观看历史","我的疑问","我的笔记","我的课程","直播课堂","观看历史","我的疑问","我的笔记"};
//	   private int image2[] = {};
	   private Context context;
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
		View view = inflater.inflate(R.layout.personal_items, null);
		ImageView iv1 = (ImageView)view.findViewById(R.id.imageView1);
//		ImageView iv2 = (ImageView)view.findViewById(R.id.imageView2);
		TextView tv = (TextView)view.findViewById(R.id.textView1);
		 
		iv1.setImageResource(image1[position]);
//		iv2.setImageResource(image2[position]);
		tv.setText(names[position]);
//		listView.LayoutParams lp = new listView.LayoutParams(
//                LinearLayout.LayoutParams.FILL_PARENT, 70);
//convertView.setLayoutParams(lp);
		
		return view;
	}
	   
   }

	
	
	
	

}
