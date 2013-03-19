package com.app.atma;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class FullscreenActivity extends Activity {

	Database db = new Database();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        
        
        
        
        final Button listArtist = (Button) findViewById(R.id.list_of_artist);
        listArtist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // loads playlist activity
            	Intent i = new Intent(getApplicationContext(), ArtistListActivity.class);
				startActivityForResult(i, 99);	
            }
        });
        
        final Button addArtist = (Button) findViewById(R.id.add_artist);
        addArtist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent i = new Intent(getApplicationContext(), AddArtistActivity.class);
				startActivityForResult(i, 100);		
            }
        });
        
    }
    
    protected void onActivityResult(int requestCode,
			int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == 100)
		{
			String name = data.getStringExtra("name");
			String number	= data.getStringExtra("name");
			
			Log.v(getPackageName(), name);
			Log.v(getPackageName(), number);
			
			Artist newArtist = new Artist(name,number);
			db.addArtist(newArtist);
			
			//Log.v(getPackageName(),"added artist");
			//Log.i(getPackageName(), "Artist Name once added: "+db.getArtist(db.getArtists().size()-1).getName());

		}
		else if(resultCode == 99)
		{
			
		}

	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_fullscreen, menu);
        return true;
    }
    
}
