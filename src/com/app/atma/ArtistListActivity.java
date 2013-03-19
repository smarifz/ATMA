package com.app.atma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListAdapter;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ArtistListActivity extends ListActivity{

	Database db;
	ArrayAdapter adapter;
	ArrayAdapter tempAdapter;
	ListView lv;
	String[] values;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playlist);

		db = new Database();

		addItemsToAdapter();

		// selecting single ListView item
		lv = getListView();
		lv.setAdapter(adapter);
		

		// listening to single listitem click
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// getting listitem index
				int artistIndex = position;

				// Starting new intent
				Intent in = new Intent(getApplicationContext(),
						FullscreenActivity.class);
				// Sending songIndex to PlayerActivity
				in.putExtra("artistIndex", artistIndex);
				setResult(99, in);
				// Closing PlayListView
				finish();
			}
		});

	}

	public void addItemsToAdapter()
	{
		values = new String[db.getArtists().size()];
		for(int i = 0; i<db.getArtists().size(); i++)
		{
			values[i] = db.getArtist(i).getName();

		}

		// Adding menuItems to ListView
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, values);


	} 




	@Override
	protected void onResume() {
		super.onResume();
		
		
		runOnUiThread(new Runnable() 
        {
            public void run() 
            {
            	Log.v(getPackageName(),"added artist: "+db.getArtist(db.getArtists().size()-1).getName());
            	
                adapter.notifyDataSetChanged();
            }
        });
	}
}
