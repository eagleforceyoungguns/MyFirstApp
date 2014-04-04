package com.rich.myfirstapp.database;

import com.rich.myfirstapp.database.PatientProvider;
import com.rich.myfirstapp.database.Patient;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper{

	 private static DatabaseHandler eagleforce;

	    public static DatabaseHandler getInstance(final Context context) {
	        if (eagleforce == null) {
	            eagleforce = new DatabaseHandler(context);
	        }
	        return eagleforce;
	    }

	    private static final int DATABASE_VERSION = 1;
	    private static final String DATABASE_NAME = "patientProvider";

	    private final Context context;

	    public DatabaseHandler(Context context) {
	        super(context, DATABASE_NAME, null, DATABASE_VERSION);
	        // Good idea to use process context here
	        this.context = context.getApplicationContext();
	    }
	@Override
	public void onCreate(SQLiteDatabase db) {
        //Creates table in database
		db.execSQL(Patient.CREATE_TABLE);

        Patient patient = new Patient();
        
        patient.firstname = "Ryan";
        patient.lastname = "Clagett";
        patient.reason = "Sore throat";
        db.insert(Patient.TABLE_NAME, null, patient.getContent());

        patient.firstname = "Richard";
        patient.lastname = "Heil";
        patient.reason = "Broken Arm";
        db.insert(Patient.TABLE_NAME, null, patient.getContent());
    }

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	public synchronized Patient getPatient(final long id) {
        final SQLiteDatabase db = this.getReadableDatabase();
        final Cursor cursor = db.query(Patient.TABLE_NAME,
                Patient.FIELDS, Patient.COL_ID + " IS ?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor == null || cursor.isAfterLast()) {
            return null;
        }

        Patient item = null;
        if (cursor.moveToFirst()) {
            item = new Patient(cursor);
        }
        cursor.close();

        return item;
    
    }
    //Adds the patient data do the database
    public synchronized boolean putPatient(final Patient patient) {
        boolean success = false;
        int result = 0;
        final SQLiteDatabase db = this.getWritableDatabase();

        if (patient.id > -1) {
            result += db.update(Patient.TABLE_NAME, patient.getContent(),
                    Patient.COL_ID + " IS ?",
                    new String[] { String.valueOf(patient.id) });
        }

        if (result > 0) {
            success = true;
        } else {
            // Update failed or wasn't possible, insert instead
            final long id = db.insert(Patient.TABLE_NAME, null,
                    patient.getContent());

            if (id > -1) {
                patient.id = id;
                success = true;
            }
            if(success) {
            	notifyProviderOnPatientChange();
            }
        }

        return success;
    }
    //Removes patient data from the database
    public synchronized int removePatient(final Patient patient) {
        final SQLiteDatabase db = this.getWritableDatabase();
        final int result = db.delete(Patient.TABLE_NAME,
                Patient.COL_ID + " IS ?",
                new String[] { Long.toString(patient.id) });
        if (result > 0){
        	notifyProviderOnPatientChange();
        }
        return result;
    }
    private void notifyProviderOnPatientChange() {
        context.getContentResolver().notifyChange(
                PatientProvider.URI_PATIENTS, null, false);
    }
}
