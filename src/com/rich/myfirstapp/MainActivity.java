package com.rich.myfirstapp;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends Activity{

	protected static final int REQUEST_OK = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
      
        //Sets the application to run in full screen mode
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        
        //Creates variable from the Login button in the xml file
        Button Login = (Button) findViewById(R.id.Login);
        
        //Creates an activity for when the Login button is clicked
        //It opens the SelectActivity class
        Login.setOnClickListener(new OnClickListener(){
        	
        public void onClick(View v){
        	Intent intent = new Intent (v.getContext(), PatientListActivity.class);
        		startActivityForResult(intent, 0);
        		Toast.makeText(MainActivity.this, "Hello Doctor, loading your patient list now", Toast.LENGTH_LONG).show();
        }
        });
        
   

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
   
}
