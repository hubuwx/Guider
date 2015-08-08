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
public class personalMessage extends Activity implements OnClickListener{
	private TextView personalMessage_title;
	private ImageButton back,question;
	/**
	 * 
	 */
	public personalMessage() {
		// TODO Auto-generated constructor stub
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	setContentView(R.layout.personal_message);
    	init();
    	Intent intent = getIntent();
		String currenttitle = intent.getStringExtra("title");
		
		personalMessage_title.setText(currenttitle);
		
		back.setOnClickListener(this);
		question.setOnClickListener(this);
    }
	private void init() {
		// TODO Auto-generated method stub
		personalMessage_title=(TextView) findViewById(R.id.personalMessage_title);
		back=(ImageButton) findViewById(R.id.personalMessage_imageButton1);
		question=(ImageButton) findViewById(R.id.personalMessage_imageButton2);
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.personalMessage_imageButton1:
			Intent intent = new Intent(personalMessage.this,PersonalActivity.class);
			startActivity(intent);
			break;

		case R.id.personalMessage_imageButton2:
			Intent intent1 = new Intent(personalMessage.this,questions.class);
			startActivity(intent1);
			break;
	}
}
	
}
