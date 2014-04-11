package com.rich.myfirstapp;

import com.rich.myfirstapp.database.DatabaseHandler;
import com.rich.myfirstapp.database.Patient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * An activity representing a single Person detail screen. This
 * activity is only used on handset devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link PatientListActivity}.
 * <p>
 * This activity is mostly just a 'shell' activity containing nothing
 * more than a {@link PatientDetailFragment}.
 */
public class PatientDetailActivity extends FragmentActivity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_detail);
        
      //Sets the application to run in full screen mode
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);

        // Show the Up button in the action bar.
        getActionBar().setDisplayHomeAsUpEnabled(true);
      
        

       
		
		

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
        	Bundle arguments = new Bundle();
            arguments.putLong(PatientDetailFragment.ARG_ITEM_ID,
                    getIntent().getLongExtra(PatientDetailFragment.ARG_ITEM_ID, -1));
            PatientDetailFragment fragment = new PatientDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.patient_detail_container, fragment)
                    .commit();
            
        }
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, PatientListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
    @Override
	public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.patient_detail, menu);
		return true;
    }
    PatientDetailFragment detail = new PatientDetailFragment();
    @Override
	public boolean onOptionsItemSelected(MenuItem item){
		boolean result = false;
	
		if (R.id.savePatient == item.getItemId()){
		result = true;
		//updates patient info
		
		detail.updatePatientFromUI();
		
		//Shows a message saying the patient has been added when the save button is clicked
		Toast.makeText(PatientDetailActivity.this, "Patient Added", Toast.LENGTH_LONG).show();
		}
		else if(R.id.addRX == item.getItemId()){
			Intent intent = new Intent(getBaseContext(), RxActivity.class);
    		startActivityForResult(intent, 0);
		}
		else if(android.R.id.home == item.getItemId()){
			NavUtils.navigateUpTo(this, new Intent(this, PatientListActivity.class));
            return true;
		}
		return result;
		}
    
}
