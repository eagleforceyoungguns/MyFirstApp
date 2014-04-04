package com.rich.myfirstapp.database;


import android.content.ContentValues;
import android.database.Cursor;

/**
 * A class representation of a row in table "Patient".
 */
public class Patient {

   
    public static final String TABLE_NAME = "Patient";
    // Naming the id column with an underscore is good to be consistent
    // with other Android things. This is ALWAYS needed
    public static final String COL_ID = "_id";
    // These fields can be anything you want.
    public static final String COL_FIRSTNAME = "firstname";
    public static final String COL_LASTNAME = "lastname";
    public static final String COL_HEIGHT	= "height";
    public static final String COL_WEIGHT = "weight";
    public static final String COL_BP = "bloodpressure";
    public static final String COL_TEMP = "temperature";
    public static final String COL_PULSE = "pulse";
    public static final String COL_REASON = "reason";
    
    // Creates the columns of the table
    public static final String[] FIELDS = { COL_ID, COL_FIRSTNAME, COL_LASTNAME,
        COL_HEIGHT, COL_WEIGHT, COL_BP, COL_TEMP, COL_PULSE, COL_REASON };

    /*
     * The SQL code that creates a Table for storing Patients in.
     * Note that the last row does NOT end in a comma like the others.
     * This is a common source of error.
     */
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY,"
            + COL_FIRSTNAME + " TEXT NOT NULL DEFAULT '',"
            + COL_LASTNAME + " TEXT NOT NULL DEFAULT '',"
            + COL_HEIGHT + " TEXT NOT NULL DEFAULT '',"
            + COL_WEIGHT + " TEXT NOT NULL DEFAULT '',"
            + COL_BP + " TEXT NOT NULL DEFAULT '',"
            + COL_TEMP + " TEXT NOT NULL DEFAULT '',"
            + COL_PULSE + " TEXT NOT NULL DEFAULT '',"
            + COL_REASON + " TEXT NOT NULL DEFAULT ''"
            + ")";

    // Fields corresponding to database columns
    public long id = -1;
    public String firstname = "";
    public String lastname = "";
    public String height = "";
    public String weight = "";
    public String bp = "";
    public String temp = "";
    public String pulse = "";
    public String reason = "";

    /**
     * No need to do anything, fields are already set to default values above
     */
    public Patient() {
    }

    /**
     * Convert information from the database into a Person object.
     */
    public Patient(final Cursor cursor) {
        // Indices expected to match order in FIELDS!
        this.id = cursor.getLong(0);
        this.firstname = cursor.getString(1);
        this.lastname = cursor.getString(2);
        this.height = cursor.getString(3);
        this.weight = cursor.getString(4);
        this.bp = cursor.getString(5);
        this.temp = cursor.getString(6);
        this.pulse = cursor.getString(7);
        this.reason = cursor.getString(8);
    }

    /**
     * Return the fields in a ContentValues object, suitable for insertion
     * into the database.
     */
    public ContentValues getContent() {
        final ContentValues values = new ContentValues();
        // Note that ID is NOT included here
        values.put(COL_FIRSTNAME, firstname);
        values.put(COL_LASTNAME, lastname);
        values.put(COL_HEIGHT, height);
        values.put(COL_WEIGHT, weight);
        values.put(COL_BP, bp);
        values.put(COL_TEMP, temp);
        values.put(COL_PULSE, pulse);
        values.put(COL_REASON, reason);

        return values;
    }
}
