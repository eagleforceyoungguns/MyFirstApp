package com.rich.myfirstapp;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.AdapterView;

public class LoadPatient extends Activity {
	
	DBAdapter myDb;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
      
   
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        openDB();
		populateListViewFromDB();
		//registerListClickCallback();
	}
	private void openDB() {
		myDb = new DBAdapter(this);
		myDb.open();
	}
	private void closeDB() {
		myDb.close();
	}
	private void populateListViewFromDB() {
		Cursor cursor = myDb.getAllRecords();
		
		// Allow activity to manage lifetime of the cursor.
		// DEPRECATED! Runs on the UI thread, OK for small/short queries.
		startManagingCursor(cursor);
		
		// Setup mapping from cursor to view fields:
		String[] fromFieldNames = new String[] 
				{DBAdapter.KEY_ROWID, DBAdapter.KEY_NAME, DBAdapter.KEY_DOB, DBAdapter.KEY_AGE};
		
		// Create adapter to may columns of the DB onto elemesnt in the UI.
		SimpleCursorAdapter myCursorAdapter = 
				new SimpleCursorAdapter(
						this,		// Context
						R.layout.activity_load,	// Row layout template
						cursor,					// cursor (set of DB records to map)
						fromFieldNames		// DB Column names
									// View IDs to put information in
, null
						);
		
		// Set the adapter for the list view
		ListView myList = (ListView) findViewById(R.id.listView1);
		myList.setAdapter(myCursorAdapter);
	}
	
}
	

