package net.scott.myfirstproject;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    public static final String EXTRA_MESSAGE =  "com.example.myfirstapp.MESSAGE" ;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void sendMessage(View view) {
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText =  (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE,  message);
    	startActivity(intent);
    }
    
    public void getRiverData(View view) {
    	System.out.println( "Button was clicked");
        ConnectivityManager connMgr = (ConnectivityManager) 
                getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
            	Intent intent = new Intent(this, GetRiverLevelsActivity.class);
            	startActivity(intent);
            } else {
            	EditText editText =  (EditText) findViewById(R.id.edit_message);
            	editText.setText("no network connction");
            }

    }
    
    
    
}
