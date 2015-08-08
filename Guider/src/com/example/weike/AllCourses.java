package com.example.weike;

import com.example.weike.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class AllCourses extends Activity implements OnClickListener {
	private LinearLayout line1, line2, line3, line4;
	private ImageButton ib1,ib2,ib3,ib4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.allcourses);
		init();
		Events();

	}

	private void init() {
		// TODO Auto-generated method stub
		line1 = (LinearLayout) findViewById(R.id.line1);
		line2 = (LinearLayout) findViewById(R.id.line2);
		line3 = (LinearLayout) findViewById(R.id.line3);
		line4 = (LinearLayout) findViewById(R.id.line4);
		
		ib1=(ImageButton) findViewById(R.id.ib1);
		ib2=(ImageButton) findViewById(R.id.ib2);
		ib3=(ImageButton) findViewById(R.id.ib3);
		ib4=(ImageButton) findViewById(R.id.ib4);
	}

	private void Events() {
		// TODO Auto-generated method stub
		ib1.setOnClickListener(this);
		ib2.setOnClickListener(this);
		ib3.setOnClickListener(this);
		ib4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ib1:
            Intent intent = new Intent(AllCourses.this,courses_list.class);
            startActivity(intent);
			break;

		case R.id.ib2:

			break;
		case R.id.ib3:

			break;
		case R.id.ib4:

			break;
		}
	}
}
