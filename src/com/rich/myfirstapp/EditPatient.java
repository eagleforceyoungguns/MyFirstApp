package com.rich.myfirstapp;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;






import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditPatient extends Activity {
	//Initializes button variables
	Button save, rx;
	//Initializes our edit text field variables
	EditText edtLastName, edtFirstName, edtHeight, edtWeight, edtBP, edtTemp, edtPulse, edtReasonVisit, edtDocAsses;
	
	
	/** Called when the activity is first created. */
	
	
	
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_edit);
	    //Set the corresponding buttons to their variables
	    save=(Button) findViewById(R.id.Save);
	    rx=(Button) findViewById(R.id.Prescription);
	    
	    //Set the corresponding edit text fields to their variables
	    edtLastName = (EditText) findViewById(R.id.txtLastName);
	    edtFirstName = (EditText) findViewById(R.id.txtFirstName);
	    edtHeight = (EditText) findViewById(R.id.txtHeight);
	    edtWeight = (EditText) findViewById(R.id.txtWeight);
	    edtReasonVisit = (EditText) findViewById(R.id.txtReasonVisit);
	    edtBP = (EditText) findViewById(R.id.txtBP);
	    edtTemp = (EditText) findViewById(R.id.txtTemp);
	    edtPulse = (EditText) findViewById(R.id.txtPulse);
	    edtDocAsses = (EditText) findViewById(R.id.txtDocAsses);
	    
	    //Makes the application run in full screen
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        
        save.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Log.d("test", "adding");
        		
        		//Shows a message saying the patient has been added when the save button is clicked
        		Toast.makeText(EditPatient.this, "Patient Added", Toast.LENGTH_LONG).show();
        	}
        });
        //Creates a click event for the prescription button that opens the prescription menu
        rx.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent intent = new Intent(v.getContext(), RxActivity.class);
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
    
  
	//Each one of these runs the speech to text when a field is clicked
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
    //Each one of these saves the speech that is said into the corresponding text field
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
          
            if (resultCode==RESULT_OK) {
            	switch (requestCode){
            	case(11):{
            		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            		((EditText)findViewById(R.id.txtLastName)).setText(thingsYouSaid.get(0));
            		String name = edtLastName.getText().toString();
            	}break;
            	case(12):{
            		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            		((EditText)findViewById(R.id.txtFirstName)).setText(thingsYouSaid.get(0));
            		String sex = edtFirstName.getText().toString();
            	}break;
            	case(13):{
            		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            		((EditText)findViewById(R.id.txtHeight)).setText(thingsYouSaid.get(0));
            		String dob = edtHeight.getText().toString();
            	}break;
            	case(14):{
            		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            		((EditText)findViewById(R.id.txtWeight)).setText(thingsYouSaid.get(0));
            		String age = edtWeight.getText().toString();
            	}break;
            	case(15):{
            		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            		((EditText)findViewById(R.id.txtReasonVisit)).setText(thingsYouSaid.get(0));
            		String addr = edtReasonVisit.getText().toString();
            	}break;
            	case(16):{
            		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            		((EditText)findViewById(R.id.txtBP)).setText(thingsYouSaid.get(0));
            		String city = edtBP.getText().toString();
            	}break;
            	case(17):{
            		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            		((EditText)findViewById(R.id.txtTemp)).setText(thingsYouSaid.get(0));
            		String state = edtTemp.getText().toString();
            	}break;
            	case(18):{
            		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            		((EditText)findViewById(R.id.txtPulse)).setText(thingsYouSaid.get(0));
            		String zip = edtPulse.getText().toString();
            	}break;
            	case(19):{
            		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            		((EditText)findViewById(R.id.txtDocAsses)).setText(thingsYouSaid.get(0));
            		String zip = edtDocAsses.getText().toString();
            	}break;
            }
            } 	
        }
	
}
