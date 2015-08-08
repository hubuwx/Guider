package com.example.weike;




import com.example.weike.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class main extends Activity implements OnClickListener{
	private Button btn_return,btn_forward,btn1,btn2,btn3,btn4;
//	TabHost mTabHost;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.main);
    	
    	btn_return = (Button) findViewById(R.id.back);    	
    	btn_forward = (Button) findViewById(R.id.forward);    	
    	btn1 = (Button) findViewById(R.id.button1);    	
    	btn2 = (Button) findViewById(R.id.button2);   
    	btn3 = (Button) findViewById(R.id.button3);   
    	btn4 = (Button) findViewById(R.id.button4);   
    	
    	btn_return.setOnClickListener(this); 
    	btn_forward.setOnClickListener(this); 
    	btn1.setOnClickListener(this); 
    	btn2.setOnClickListener(this); 
    	btn3.setOnClickListener(this); 
    	btn4.setOnClickListener(this); 
    	
				
		
    	
    	
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.back:
			Intent intent =new Intent(main.this,MainActivity.class);
			startActivity(intent);
			break;

		case R.id.forward:
			Intent intent2 =new Intent(main.this,activity1.class);
			startActivity(intent2);
			break;
			
		case R.id.button1:
			Intent intent3 =new Intent(main.this,instruction_activity.class);
			startActivity(intent3);
			break;
			
		case R.id.button2:
			Intent intent4 =new Intent(main.this,every_learn_activity.class);
			startActivity(intent4);
			break;
		case R.id.button3:
			Intent intent5 =new Intent(main.this,courses_list.class);
			startActivity(intent5);
			break;
		case R.id.button4:
			Intent intent6 =new Intent(main.this,PersonalActivity.class);
			startActivity(intent6);
			break;
		}
		
	}


   
	
}
