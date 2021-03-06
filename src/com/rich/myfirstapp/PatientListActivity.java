package com.rich.myfirstapp;

import com.rich.myfirstapp.database.DatabaseHandler;
import com.rich.myfirstapp.database.Patient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;

/**
 * An activity representing a list of Patients. This activity has different
 * presentations for handset and tablet-size devices. On handsets, the activity
 * presents a list of items, which when touched, lead to a
 * {@link PatientDetailActivity} representing item details. On tablets, the
 * activity presents the list of items and item details side-by-side using two
 * vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link PatientListFragment} and the item details (if present) is a
 * {@link PatientDetailFragment}.
 * <p>
 * This activity also implements the required
 * {@link PatientListFragment.Callbacks} interface to listen for item
 * selections.
 */
public class PatientListActivity extends FragmentActivity implements
		PatientListFragment.Callbacks {

	/**
	 * Whether or not the activity is in two-pane mode, i.e. running on a tablet
	 * device.
	 */
	private boolean mTwoPane;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_list);
		
		//Sets the application to run in full screen mode
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);

		if (findViewById(R.id.patient_detail_container) != null) {
			// The detail container view will be present only in the
			// large-screen layouts (res/values-large and
			// res/values-sw600dp). If this view is present, then the
			// activity should be in two-pane mode.
			mTwoPane = true;

			// In two-pane mode, list items should be given the
			// 'activated' state when touched.
			((PatientListFragment) getSupportFragmentManager()
					.findFragmentById(R.id.patient_list))
					.setActivateOnItemClick(true);
		}

		// TODO: If exposing deep links into your app, handle intents here.
	}

	/**
	 * Callback method from {@link PatientListFragment.Callbacks} indicating
	 * that the item with the given ID was selected.
	 */
	
	 @Override
	    public void onItemSelected(long id) {
	        /*if (mTwoPane) {
	            // In two-pane mode, show the detail view in this activity by
	            // adding or replacing the detail fragment using a
	            // fragment transaction.
	            Bundle arguments = new Bundle();
	            arguments.putLong(PatientDetailFragment.ARG_ITEM_ID, id);
	            PatientDetailFragment fragment = new PatientDetailFragment();
	            fragment.setArguments(arguments);
	            getSupportFragmentManager().beginTransaction()
	                    .replace(R.id.patient_detail_container, fragment)
	                    .commit();

	        } else {*/
	            // In single-pane mode, simply start the detail activity
	            // for the selected item ID.
	            Intent detailIntent = new Intent(this, PatientDetailActivity.class);
	            detailIntent.putExtra(PatientDetailFragment.ARG_ITEM_ID, id);
	            startActivity(detailIntent);
	        //}
	    
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.list_activity, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		boolean result = false;
		if (R.id.newPatient == item.getItemId()){
		result = true;
		//Create a new patient
		Patient p = new Patient();
		DatabaseHandler.getInstance(this).putPatient(p);
		//Open a new fragment with the new id
		onItemSelected(p.id);
		}
		return result;
		}

	
	
}
