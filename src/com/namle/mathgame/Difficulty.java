package com.namle.mathgame;

import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class Difficulty extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_difficulty);
		
		Button back = (Button) findViewById(R.id.back3);
		Button easy = (Button) findViewById(R.id.easy);
		Button medium = (Button) findViewById(R.id.medium);
		Button hard = (Button) findViewById(R.id.hard);
		
		back.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				Intent oper = new Intent(Difficulty.this,Operation.class);
		        startActivity(oper);
		        finish();
				}
			});		
		
		easy.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				launchGame();
				}
			});	
		
		medium.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				launchGame();
				}
			});	
		
		hard.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				launchGame();
				}
			});	
	}
	
	@Override
	public void onBackPressed() {		
	Intent operation = new Intent(Difficulty.this,Operation.class);
    startActivity(operation);
    finish();
	
}
	
	public void launchGame() {
		Intent game = new Intent(Difficulty.this,Game.class);
        startActivity(game);
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
