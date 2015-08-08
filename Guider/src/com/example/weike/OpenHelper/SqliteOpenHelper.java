package com.example.weike.OpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteOpenHelper extends SQLiteOpenHelper {

	private final static String DbName = "weike.db";
	private final static int DbVersion = 1;

	public SqliteOpenHelper(Context context) {
		super(context, DbName, null, DbVersion);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table normalusers(_id integer primary key autoincrement,"
				+ "username varchar(20)," + "password varchar(20))");
		db.execSQL("create table Managers(_id integer primary key autoincrement,"
				+ "User varchar(20)," + "Pass varchar(20))");
		

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int OldVersion, int NewVersion) {
		// TODO Auto-generated method stub

	}

}
