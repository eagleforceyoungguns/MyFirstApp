package com.rich.myfirstapp.database;

import com.rich.myfirstapp.database.DatabaseHandler;
import com.rich.myfirstapp.database.Patient;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class PatientProvider extends ContentProvider {
	// All URIs share these parts
    public static final String AUTHORITY = "com.rich.myfirstapp.provider";
    public static final String SCHEME = "content://";

    // URIs
    // Used for all patients
    public static final String PATIENTS = SCHEME + AUTHORITY + "/person";
    public static final Uri URI_PATIENTS = Uri.parse(PATIENTS);
    // Used for a single patients, just add the id to the end
    public static final String PATIENT_BASE = PATIENTS + "/";
	
	
	public PatientProvider() {
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// Implement this to handle requests to delete one or more rows.
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public String getType(Uri uri) {
		// TODO: Implement this to handle requests for the MIME type of the data
		// at the given URI.
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO: Implement this to handle requests to insert a new row.
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public boolean onCreate() {
		// TODO: Implement this to initialize your content provider on startup.
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// Implement this to handle query requests from clients.
		Cursor result = null;
		if (URI_PATIENTS.equals(uri)) {
			  result = DatabaseHandler
	                    .getInstance(getContext())
	                    .getReadableDatabase()
	                    .query(Patient.TABLE_NAME, Patient.FIELDS, null, null, null,
	                            null, null, null);
			  result.setNotificationUri(getContext().getContentResolver(), URI_PATIENTS);  
        }
        else if (uri.toString().startsWith(PATIENT_BASE)) {
        	final long id = Long.parseLong(uri.getLastPathSegment());
			result = DatabaseHandler
					.getInstance(getContext())
					.getReadableDatabase()
					.query(Patient.TABLE_NAME, Patient.FIELDS,
							Patient.COL_ID + " IS ?",
							new String[] { String.valueOf(id) }, null, null,
							null, null);
			result.setNotificationUri(getContext().getContentResolver(), URI_PATIENTS);
        }
        else {
        throw new UnsupportedOperationException("Not yet implemented");
        }

        return result;
    }
	

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO: Implement this to handle requests to update one or more rows.
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
