package com.rich.myfirstapp;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import android.view.WindowManager;
import android.widget.Button;



public class MainActivity extends Activity{

	protected static final int REQUEST_OK = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
      
   
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        
        Button button1 = (Button) findViewById(R.id.Login);
        
        button1.setOnClickListener(new OnClickListener(){
        	
        public void onClick(View v){
        	Intent intent = new Intent (v.getContext(), SelectActivity.class);
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
