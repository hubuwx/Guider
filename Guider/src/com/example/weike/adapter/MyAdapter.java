package com.example.weike.adapter;

import java.util.List;

import com.example.weike.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	
	private List<String> list;
	private Context context;

	public MyAdapter(List<String> list,Context context) {
		this.list = list;
		this.context = context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView ==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.items, null);
		}
		TextView tv = (TextView) convertView.findViewById(R.id.tv);
		tv.setText(list.get(position));
		
		return convertView;
	}

}
