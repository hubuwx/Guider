package com.example.weike;

import com.example.weike.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class welcome extends Activity implements OnViewChangeListener{

	private MyScrollLayout myscroll;
	private ImageView[] imageview;
	private int count;
	private int currentItem;
	private Button startButton;
	private RelativeLayout myRelativeLayout;
	private LinearLayout pointLLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guider);		
		initView();	}


	private void initView() {
		// TODO Auto-generated method stub
		myscroll=(MyScrollLayout) findViewById(R.id.mscroll_leader);
		myRelativeLayout=(RelativeLayout) findViewById(R.id.firstRlayout);
		pointLLayout=(LinearLayout) findViewById(R.id.llayout);
		count = myscroll.getChildCount();
		
		startButton=(Button) findViewById(R.id.startBtn);
		startButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(welcome.this,MainActivity.class);
				startActivity(intent);
			}
		});
		
		imageview = new ImageView[count];
		for(int i = 0; i< count;i++) {
			imageview[i] = (ImageView) pointLLayout.getChildAt(i);
			imageview[i].setEnabled(true);
			imageview[i].setTag(i);
		}
		currentItem = 0;
		imageview[currentItem].setEnabled(false);
		myscroll.SetOnViewChangeListener((OnViewChangeListener) this);
				
	
	}

	

	@Override
	public void OnViewChange(int view) {
		// TODO Auto-generated method stub
		setCurView(view);
		
	}
	private void setCurView(int view) {
		// TODO Auto-generated method stub
		if(view < 0 || view > count -1 || currentItem == view) {
			return;
		}
		imageview[currentItem].setEnabled(true);
		imageview[view].setEnabled(false);
		currentItem = view;
	}
		
	


}
