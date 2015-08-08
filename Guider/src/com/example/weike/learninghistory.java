/**
 * 
 */
package com.example.weike;

import com.example.weike.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * 观看历史页面java代码
 *
 */
public class learninghistory extends Activity implements OnClickListener{
	private TextView title;
	private ImageButton back,question;
	/**
	 * 
	 */
	public learninghistory() {
		// TODO Auto-generated constructor stub
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	setContentView(R.layout.learning_history);
    	init();
    	Intent intent = getIntent();
		String currenttitle = intent.getStringExtra("title2");
		
		title.setText(currenttitle);
		
		back.setOnClickListener(this);
		question.setOnClickListener(this);
    }
	private void init() {
		// TODO Auto-generated method stub
		title=(TextView) findViewById(R.id.learning_history_title);
		back=(ImageButton) findViewById(R.id.learning_history_imageButton1);
		question=(ImageButton) findViewById(R.id.learning_history_imageButton2);
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.learning_history_imageButton1:
			Intent intent = new Intent(learninghistory.this,PersonalActivity.class);
			startActivity(intent);
			break;

		case R.id.learning_history_imageButton2:
			Intent intent1 = new Intent(learninghistory.this,questions.class);
			startActivity(intent1);
			break;
	}
}
	
}
