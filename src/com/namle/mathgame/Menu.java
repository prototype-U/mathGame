package com.namle.mathgame;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

public class Menu extends Activity {
	
	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		Button home = (Button) findViewById(R.id.home);
		Button quitmenu = (Button) findViewById(R.id.quitmenu);
		
		home.setOnClickListener(new OnClickListener() {
			@Override
            public void onClick(View v) {
                Intent home = new Intent(Menu.this,Home.class);
                startActivity(home);
                finish();
            }
        });
		
		// add quit button listener
		quitmenu.setOnClickListener(new OnClickListener() {		 
		@Override
		public void onClick(View arg0) {
			AlertDialog.Builder quit = new AlertDialog.Builder(context);
					 
			// set dialog message
			quit
				.setTitle("QUIT")
				.setMessage("Are you sure you want to QUIT?")
				.setIcon(R.drawable.ic_launcher)
				.setCancelable(false)
				.setNegativeButton("YES",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close all activities
						// and end program		
						setResult(RESULT_OK);
						finish();
						
					}
						})
				.setPositiveButton("NO",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						dialog.cancel();
					}
				});

				// show it
				quit.show();
			}
		});
	}
	
	@Override
	public void onBackPressed() {
		// the activity wants to receive bundles which we dont send here
		finish();
	}
	
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
