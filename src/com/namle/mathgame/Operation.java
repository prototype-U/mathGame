package com.namle.mathgame;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Operation extends Activity {
	String input= null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_operation);
		
		Button back = (Button) findViewById(R.id.back2);
		Button sub = (Button) findViewById(R.id.subop);
		Button div = (Button) findViewById(R.id.divop);
		
		back.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				Intent home = new Intent(Operation.this,Home.class);
		        startActivity(home);
		        finish();
				}
			});		
		
		sub.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				input="sub";
				difficulty(input);
				}
			});	
		
		div.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				input="div";
				difficulty(input);
				}
			});	
		
	}
		
		@Override
		public void onBackPressed() {		
		Intent home = new Intent(Operation.this,Home.class);
        startActivity(home);
        finish();
		
	}

		public void difficulty(String input2) {
			Intent diffi = new Intent(Operation.this,Difficulty.class);
			Bundle send = new Bundle();
			send.putString("key", input2);
			diffi.putExtras(send);
	        startActivity(diffi);
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
