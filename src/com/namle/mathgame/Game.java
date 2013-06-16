package com.namle.mathgame;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;

public class Game extends Activity {
	
	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		Button menu = (Button) findViewById(R.id.menu);
		
		menu.setOnClickListener(new OnClickListener() {
			@Override
            public void onClick(View v) {
                Intent menu = new Intent(Game.this,Menu.class);
                startActivityForResult(menu, 0);               
            }
        });
		
		Random s = new Random();
		
		int ransubeasy = s.nextInt(21);
		int ransubeasy2 = s.nextInt(21);
		
		int ransubmed = s.nextInt(41);
		int ransubmed2 = s.nextInt(41);
		
		int ransubhard = s.nextInt(61);
		int ransubhard2 = s.nextInt(61);
		
		int randiveasy = s.nextInt(31);
		int randiveasy2 = s.nextInt(31);
		
		int randivmed = s.nextInt(61);
		int randivmed2 = s.nextInt(61);
		
		int randivhard= s.nextInt(101);
		int randivhard2= s.nextInt(101);
		
		TextView num1 =(TextView)findViewById(R.id.num1);
		num1.setText(Integer.toString(ransubeasy));
		
		TextView num2 =(TextView)findViewById(R.id.num2);
		num2.setText(Integer.toString(ransubeasy2));
		
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	     finish();
	}
	
	@Override
	public void onBackPressed() {

		
			AlertDialog.Builder end = new AlertDialog.Builder(context);
			 
			// set dialog message
			end
				.setTitle("END")
				.setMessage("Are you sure you want to END this game?")
				.setIcon(R.drawable.ic_launcher)
				.setCancelable(false)
				.setNegativeButton("YES",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// current activity
						Intent home = new Intent(Game.this,Home.class);
		                startActivity(home);
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
				end.show();
		
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
