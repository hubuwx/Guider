package com.example.weike;

import com.example.weike.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class every_learn_activity extends Activity {
	
	private Button backforward,btn_save;
	private MediaController mediaController;
	private EditText edit_note;
	
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        	// TODO Auto-generated method stub
        	super.onCreate(savedInstanceState);
        	setContentView(R.layout.every_learn_activity);

        	btn_save =(Button) findViewById(R.id.btn_save);
        	edit_note =(EditText) findViewById(R.id.edit_note);
        	VideoView video = (VideoView) findViewById(R.id.videoView1);
        	video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.weikevideo20150729009));
//        	mediaController = (MediaController) findViewById(R.id.mediaController1);
            mediaController = new MediaController(this);
            mediaController.setPadding(40, -200, 40, 20);
            mediaController.setMinimumHeight(30);
            
            video.setMediaController(mediaController);
            video.start();
            
            backforward =(Button) findViewById(R.id.backforward);
            backforward.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(every_learn_activity.this,main.class);
					startActivity(intent);
				}
			});
            
            btn_save.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Toast.makeText(every_learn_activity.this, "您的笔记已保存", 0).show();
					edit_note.setText("");
				}
			});
        }
}
