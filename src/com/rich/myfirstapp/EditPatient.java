package com.rich.myfirstapp;

import java.util.ArrayList;




import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
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
	Button save, rx;
	EditText edtName, edtSex, edtDOB, edtAge, edtAddr, edtCity, edtState, edtZip;
	
	DBAdapter db = new DBAdapter(this);
	/** Called when the activity is first created. */
	
	/*
	//wakelock to keep screen on
		protected PowerManager.WakeLock mWakeLock;

		//speach recognizer for callbacks
		private SpeechRecognizer mSpeechRecognizer;

		//handler to post changes to progress bar
		private Handler mHandler = new Handler();
		
		//intent for speech recogniztion
		Intent mSpeechIntent;
		
		//this bool will record that it's time to kill P.A.L.
		boolean killCommanded = false;

		//legel commands
		private static final String[] VALID_COMMANDS = {
			"patient name",
			"height",
			"weight",
			"blood pressure",
			"reason for visit",
			"exit"
		};
		
		private static final int VALID_COMMANDS_SIZE = VALID_COMMANDS.length;
		
		protected void onStart() {
			mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(EditPatient.this);
			SpeechListener mRecognitionListener = new SpeechListener();
			mSpeechRecognizer.setRecognitionListener(mRecognitionListener);
			mSpeechIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

			mSpeechIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"com.androiddev101.ep8");

			// Given an hint to the recognizer about what the user is going to say
			mSpeechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
					RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

			// Specify how many results you want to receive. The results will be sorted
			// where the first result is the one with higher confidence.
			mSpeechIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 20);


			mSpeechIntent.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true);

			//aqcuire the wakelock to keep the screen on until user exits/closes app
			final PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
			
			this.mWakeLock.acquire();
			mSpeechRecognizer.startListening(mSpeechIntent);
			super.onStart();
		}
		private String getResponse(int command){
			switch (command){
			case 0:
				speak1();
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				killCommanded = true;
				break;
			default:
				break;
			}
		}
		
		*/
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_edit);
	    save=(Button) findViewById(R.id.Save);
	    rx=(Button) findViewById(R.id.Prescription);
	    edtName = (EditText) findViewById(R.id.drug);
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
            		((EditText)findViewById(R.id.drug)).setText(thingsYouSaid.get(0));
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
