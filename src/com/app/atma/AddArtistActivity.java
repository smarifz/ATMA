package com.app.atma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddArtistActivity extends Activity {

	Database dbMain;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.artist_form);

		dbMain = new Database();


		final Button submit = (Button) findViewById(R.id.submit);
		submit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(v.getId() == R.id.submit)
				{
					final EditText nameField = (EditText) findViewById(R.id.name);
					final String name = nameField.getText().toString();

					final EditText numberField = (EditText) findViewById(R.id.number);
					final String number = numberField.getText().toString();
					
					// Create the message
					addArtistIntent(name,number);
					Log.v(getPackageName(),"clicked submit");
				}
			}
		});
	}

	public void addArtistIntent(String name, String number) 
	{

		// Starting new intent
		Intent in = new Intent(getApplicationContext(),
				FullscreenActivity.class);
		// Sending songIndex to PlayerActivity
		in.putExtra("name", name);
		in.putExtra("number", number);

		Log.v(getPackageName(),"added artist: "+name);
		
		setResult(100, in);
		// Closing PlayListView
		finish();

	}

}