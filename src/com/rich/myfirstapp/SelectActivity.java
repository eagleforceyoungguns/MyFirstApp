package com.rich.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SelectActivity extends Activity{
	protected static final int REQUEST_OK = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      
   //Sets the application to run full screen
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        
   //Initializes the buttons as variables
        Button btnAdd = (Button) findViewById(R.id.Add);
        Button btnLoad = (Button) findViewById(R.id.Load);
        btnAdd.setOnClickListener(new OnClickListener(){
   
  //Creates click activity for the Add Patient button. It opens the EditPatient class
        public void onClick(View v){
        	Intent intent = new Intent (v.getContext(), EditPatient.class);
        		startActivityForResult(intent, 0);
        }
        });
  //Creates click activity for the Load PAtient button. It opens the PatientListActivity class
        btnLoad.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent intent = new Intent (v.getContext(), PatientListActivity.class);
        		startActivityForResult(intent, 0);
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
