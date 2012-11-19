package net.scott.myfirstproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class DisplayMessageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		// Show the Up button in the action bar.
		//getActionBar().setDisplayHomeAsUpEnabled(true);
		SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		String oldMessage = sp.getString("old_value", "nothing");		
		String newMessage = "Last time you said: " + oldMessage + "\n\nThis time you said: " + message;
//		Button btn = new Button(this);
//		setContentView(btn);
		TextView textView = (TextView) findViewById(R.id.result_message);
		textView.setTextSize(40);
		textView.setText(newMessage);
	//	setContentView(textView);
		SharedPreferences.Editor ed = sp.edit();
		ed.putString("old_value", message);
		ed.commit();
	}
	
	public void goBack(View view){
		Intent intent = new Intent(this,MainActivity.class);
		startActivity(intent);
	}

}
