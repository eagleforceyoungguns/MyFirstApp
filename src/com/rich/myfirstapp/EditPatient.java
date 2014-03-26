package com.rich.myfirstapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditPatient extends Activity {
	Button save;
	EditText edtName, edtSex, edtDOB, edtAge, edtAddr, edtCity, edtState, edtZip;
	
	DBAdapter db = new DBAdapter(this);
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_edit);
	    save=(Button) findViewById(R.id.Login);
	    edtName = (EditText) findViewById(R.id.editText1);
	    edtSex = (EditText) findViewById(R.id.editText2);
	    edtDOB = (EditText) findViewById(R.id.editText3);
	    edtAge = (EditText) findViewById(R.id.editText4);
	    edtAddr = (EditText) findViewById(R.id.editText5);
	    edtCity = (EditText) findViewById(R.id.editText6);
	    edtState = (EditText) findViewById(R.id.editText7);
	    edtZip = (EditText) findViewById(R.id.editText8);
	    
	    
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        
        save.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Log.d("test", "adding");
        		
        		db.open();
        		long id = db.insertRecord(edtName.getText().toString(), edtSex.getText().toString(), edtDOB.getText().toString(), edtAge.getText().toString(), edtAddr.getText().toString(), edtCity.getText().toString(), edtState.getText().toString(), edtZip.getText().toString());
        		
        		db.close();
        		Toast.makeText(EditPatient.this, "Patient Added", Toast.LENGTH_LONG).show();
        	}
        });
	}
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
  
	
    public void speak1(View v) {
    		Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    	         	i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
    	        	 	try {
    	        	 		startActivityForResult(i, 11);
    	        	 	} catch (Exception e) {
    	        	 		Toast.makeText(this, "Error initializing speech to text engine.", Toast.LENGTH_LONG).show();
    	        	 	}
    		
    	}
    public void speak2(View v) {
		Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	         	i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
	        	 	try {
	        	 		startActivityForResult(i, 12);
	        	 	} catch (Exception e) {
	        	 		Toast.makeText(this, "Error initializing speech to text engine.", Toast.LENGTH_LONG).show();
	        	 	}
		
	}
    public void speak3(View v) {
		Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	         	i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
	        	 	try {
	        	 		startActivityForResult(i, 13);
	        	 	} catch (Exception e) {
	        	 		Toast.makeText(this, "Error initializing speech to text engine.", Toast.LENGTH_LONG).show();
	        	 	}
		
	}
    public void speak4(View v) {
		Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	         	i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
	        	 	try {
	        	 		startActivityForResult(i, 14);
	        	 	} catch (Exception e) {
	        	 		Toast.makeText(this, "Error initializing speech to text engine.", Toast.LENGTH_LONG).show();
	        	 	}
		
	}
    public void speak5(View v) {
		Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	         	i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
	        	 	try {
	        	 		startActivityForResult(i, 15);
	        	 	} catch (Exception e) {
	        	 		Toast.makeText(this, "Error initializing speech to text engine.", Toast.LENGTH_LONG).show();
	        	 	}
		
	}
    public void speak6(View v) {
		Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	         	i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
	        	 	try {
	        	 		startActivityForResult(i, 16);
	        	 	} catch (Exception e) {
	        	 		Toast.makeText(this, "Error initializing speech to text engine.", Toast.LENGTH_LONG).show();
	        	 	}
		
	}
    public void speak7(View v) {
		Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	         	i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
	        	 	try {
	        	 		startActivityForResult(i, 17);
	        	 	} catch (Exception e) {
	        	 		Toast.makeText(this, "Error initializing speech to text engine.", Toast.LENGTH_LONG).show();
	        	 	}
		
	}
    public void speak8(View v) {
		Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	         	i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
	        	 	try {
	        	 		startActivityForResult(i, 18);
	        	 	} catch (Exception e) {
	        	 		Toast.makeText(this, "Error initializing speech to text engine.", Toast.LENGTH_LONG).show();
	        	 	}
		
	}
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
          
            if (resultCode==RESULT_OK) {
            	switch (requestCode){
            	case(11):{
            		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            		((EditText)findViewById(R.id.editText1)).setText(thingsYouSaid.get(0));
            		String name = edtName.getText().toString();
            	}break;
            	case(12):{
            		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            		((EditText)findViewById(R.id.editText2)).setText(thingsYouSaid.get(0));
            		String sex = edtSex.getText().toString();
            	}break;
            	case(13):{
            		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            		((EditText)findViewById(R.id.editText3)).setText(thingsYouSaid.get(0));
            		String dob = edtDOB.getText().toString();
            	}break;
            	case(14):{
            		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            		((EditText)findViewById(R.id.editText4)).setText(thingsYouSaid.get(0));
            		String age = edtAge.getText().toString();
            	}break;
            	case(15):{
            		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            		((EditText)findViewById(R.id.editText5)).setText(thingsYouSaid.get(0));
            		String addr = edtAddr.getText().toString();
            	}break;
            	case(16):{
            		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            		((EditText)findViewById(R.id.editText6)).setText(thingsYouSaid.get(0));
            		String city = edtCity.getText().toString();
            	}break;
            	case(17):{
            		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            		((EditText)findViewById(R.id.editText7)).setText(thingsYouSaid.get(0));
            		String state = edtState.getText().toString();
            	}break;
            	case(18):{
            		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            		((EditText)findViewById(R.id.editText8)).setText(thingsYouSaid.get(0));
            		String zip = edtZip.getText().toString();
            	}break;
            	
            }
            } 	
        }
}
