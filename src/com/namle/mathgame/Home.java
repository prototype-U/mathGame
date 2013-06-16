package com.namle.mathgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class Home extends Activity {
	
	final Context context = this;
 
	public void onCreate(Bundle savedInstanceState) {
 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
 
		Button quit = (Button) findViewById(R.id.quit);
		Button instruction = (Button) findViewById(R.id.instruction);
		Button start = (Button) findViewById(R.id.start);
		
		start.setOnClickListener(new OnClickListener() {
			@Override
            public void onClick(View v) {
				AlertDialog.Builder name = new AlertDialog.Builder(context);
				
				name.setTitle("Name");
				name.setMessage("Please enter your name");
				name.setIcon(R.drawable.ic_launcher);
				name.setCancelable(false);
				
				// Set an EditText view to get user input 
				final EditText input = new EditText (context);
				input.requestFocus();
                input.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        InputMethodManager keyboard = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                        keyboard.showSoftInput(input, 0);
                    }
                },200);
				
				name.setView(input);

				name.setNegativeButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					String name = input.getText().toString();
					Intent operation = new Intent(Home.this,Operation.class);
	                startActivity(operation);
	                finish();
				  }
				});

				name.setPositiveButton("CANCLE", new DialogInterface.OnClickListener() {
				  public void onClick(DialogInterface dialog, int whichButton) {
					  dialog.cancel();
				  }
				});
				
				name.show();
            }
        });
		
		instruction.setOnClickListener(new OnClickListener() {
			@Override
            public void onClick(View v) {
                Intent instruction = new Intent(Home.this,Instruction.class);
                startActivity(instruction); 
                finish();
            }
        });
		
		// add quit button listener
		quit.setOnClickListener(new OnClickListener() {
 
		@Override
		public void onClick(View arg0) {
			doExit();
			}
		});
	}
	
	@Override
	public void onBackPressed() {

	    doExit();
	}
	
	private void doExit() {
		AlertDialog.Builder quit = new AlertDialog.Builder(context);
		 
		// set dialog message
		quit
			.setTitle("QUIT")
			.setMessage("Are you sure you want to QUIT?")
			.setIcon(R.drawable.ic_launcher)
			.setCancelable(false)
			.setNegativeButton("YES",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, close
					// current activity
					finish();
		            System.exit(0);
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
	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    
}