package com.example.weike;

import com.example.weike.R;
import com.example.weike.OpenHelper.SqliteOpenHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button btn_login, btn_reg;
	private EditText edit_name, edit_password;
	private SQLiteDatabase db;
	private SqliteOpenHelper mysqlhelper;
//    private CheckBox auto;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mysqlhelper = new SqliteOpenHelper(MainActivity.this);
		db = mysqlhelper.getWritableDatabase();

//		auto = (CheckBox) findViewById(R.id.auto);//暂未实现

		btn_login = (Button) findViewById(R.id.login);
		btn_reg = (Button) findViewById(R.id.reg);
//		not_login = (Button) findViewById(R.id.not_login);
		edit_name = (EditText) findViewById(R.id.edit_name);
		edit_password = (EditText) findViewById(R.id.edit_password);
		

		btn_login.setOnClickListener(this);
		btn_reg.setOnClickListener(this);
//		not_login.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.login:
			if(edit_name.getText().toString().equals("") || edit_name.getText().toString().equalsIgnoreCase(null)
					|| edit_password.getText().toString().equals("")||edit_password.getText().toString().equalsIgnoreCase(null))
				Toast.makeText(MainActivity.this, "别闹了，把用户名或密码填上！",Toast.LENGTH_SHORT).show();	
			else{
			Cursor cursor1 = db.rawQuery(
					"select count(*) from normalusers where username = '"+ edit_name.getText().toString() + "'", null);
			cursor1.moveToNext();
			int count = cursor1.getInt(0);
			if (count == 1) {
				Cursor cursor = db.rawQuery(
						"select username,password from normalusers where username = '"+ edit_name.getText().toString() + "'", null);
				cursor.moveToNext();
		    if ((edit_name.getText().toString()).equals(cursor.getString(0).toString())
		    		&& (edit_password.getText().toString()).equals(cursor.getString(1).toString())) {
					Toast.makeText(MainActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();				
					
				//登录成功即跳转页面					
					Intent intent = new Intent(MainActivity.this,main.class);				 			  
					MainActivity.this.finish();
					startActivity(intent);			    
			   }	
		      else { 
				Toast.makeText(MainActivity.this, "您输入的用户名或密码错误！",Toast.LENGTH_SHORT).show();
				edit_name.setText("");
				edit_password.setText("");
		    	}
		        cursor.close();
		  
			} 
			  else { 
					Toast.makeText(MainActivity.this, "您输入的用户名或密码错误！",Toast.LENGTH_SHORT).show();
					edit_name.setText("");
					edit_password.setText("");
			    	}
				
		
			}
			break;

		case R.id.reg:
			Intent intent = new Intent(MainActivity.this, regActivity.class);
			startActivity(intent);
			break;
			
		
			
		}
	}
}
