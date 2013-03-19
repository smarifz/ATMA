package com.app.atma;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ArtistActivity extends Activity {

	Database db = new Database();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_activity);
        
        TextView text = (TextView) findViewById(R.id.artistList);
        
        for(int i=0; i<db.mainArtist.size(); i++)
        {
        	text.setText((CharSequence) db.getArtist(i));
        }
                
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_fullscreen, menu);
        return true;
    }
    
}
