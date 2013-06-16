package com.namle.mathgame;

import java.util.Random;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends Activity implements OnClickListener {
	TextView gametitle, operation;
	String name, diffi;
	int a, b;
	Button check;
	TextView num1,num2;

	EditText answer;
	String answerstring=null;
	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		check= (Button) findViewById(R.id.submit);
		check.setOnClickListener(this);
		answer = (EditText) findViewById(R.id.answer);
		
		
		gametitle = (TextView) findViewById(R.id.gameTitle); // initialized this
																// so that we
																// can change
																// text
		operation = (TextView) findViewById(R.id.operation); // to change the
																// sign/operation

		Bundle game = getIntent().getExtras(); // receiving the bundle from
												// intent
		name = game.getString("game"); // name= div or sub
		diffi = game.getString("diff");

		if (name.contentEquals("div")) {
			gametitle.setText("Division");
			operation.setText("/");
		} else if (name.contentEquals("sub")) {
			gametitle.setText("Subtraction");
			operation.setText("-");
		}
		
		Button menu = (Button) findViewById(R.id.menu);

		menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent menu = new Intent(Game.this, Menu.class);
				startActivity(menu);
			}
		});

		
		randomNumber();
		

		
	}



	@Override
	public void onBackPressed() {

		AlertDialog.Builder end = new AlertDialog.Builder(context);

		// set dialog message
		end.setTitle("END")
				.setMessage("Are you sure you want to END this game?")
				.setIcon(R.drawable.ic_launcher)
				.setCancelable(false)
				.setNegativeButton("YES",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// if this button is clicked, close
								// current activity
								Intent home = new Intent(Game.this, Home.class);
								startActivity(home);
								finish();
							}
						})
				.setPositiveButton("NO", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.submit:
			if(name.contentEquals("div")){
				
				
				answerstring = answer.getText().toString();
					int divide = a/b;
					String finalans = Integer.toString(divide);
				if (answerstring.contentEquals(finalans)){
					Toast.makeText(getBaseContext(), "Your answer is right!", Toast.LENGTH_SHORT).show();
					answer.setText("");
					randomNumber();
				}else{
					Toast.makeText(getBaseContext(), "Your answer is wrong!", Toast.LENGTH_SHORT).show();
					answer.setText("");
					randomNumber();
				}
			}
			else if (name.contentEquals("sub")){
				answerstring = answer.getText().toString();
					
					int sub = a-b;
					String finalans = Integer.toString(sub);
				if(answerstring.contentEquals(finalans)){
					Toast.makeText(getBaseContext(), "Your answer is right!", Toast.LENGTH_SHORT).show();
					answer.setText("");
					randomNumber();
				}else{
					Toast.makeText(getBaseContext(), "Your answer is wrong!", Toast.LENGTH_SHORT).show();
					answer.setText("");
					randomNumber();
				
				}
			}
		}
	}

	private void randomNumber() {
		// TODO Auto-generated method stub
		
		Random s = new Random();
		if (diffi.contains("easy") && name.contains("sub")) {
			a = s.nextInt(21);
			if(a==0)
				a=21;
			b = s.nextInt(a);
		} else if (diffi.contains("medium") && name.contains("sub")) {
			a = s.nextInt(41);
			if(a==0)
				a=41;
			b = s.nextInt(a);
		} else if (diffi.contains("hard") && name.contains("sub")) {
			a = s.nextInt(61);
			if(a==0)
				a=61;
			b = s.nextInt(a);
		} else if (diffi.contains("easy") && name.contains("div")) {
			a = s.nextInt(31);
			if(a==0)
				a=31;
			b = s.nextInt(a);
		} else if (diffi.contains("medium") && name.contains("div")) {
			a = s.nextInt(61);
			if(a==0)
				a=61;
			b = s.nextInt(a);
		} else if (diffi.contains("hard") && name.contains("div")) {
			a = s.nextInt(101);
			if(a==0)
				a=101;
			b = s.nextInt(a);
		}
		num1 = (TextView) findViewById(R.id.num1);
		num1.setText(Integer.toString(a));

		num2 = (TextView) findViewById(R.id.num2);
		num2.setText(Integer.toString(b));
		
	}

}
