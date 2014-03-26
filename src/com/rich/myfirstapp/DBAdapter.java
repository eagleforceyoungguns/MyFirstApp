package com.rich.myfirstapp;


import android.database.SQLException;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

public class DBAdapter {
	public static final String KEY_ROWID = "id";
	public static final String KEY_NAME = "name";
	public static final String KEY_SEX = "sex";
	public static final String KEY_DOB = "dob";
	public static final String KEY_AGE = "age";
	public static final String KEY_ADDR = "address";
	public static final String KEY_CITY = "city";
	public static final String KEY_STATE = "state";
	public static final String KEY_ZIP = "zip";
	private static final String TAG = "DBAdapter";
	
	public static final String DATABASE_NAME = "PatientDB";
	public static final String DATABASE_TABLE = "PatientData";
	public static final int DATABASE_VERSION = 1;
	
	public static final String[] ALL_KEYS = new String[] {KEY_ROWID, KEY_NAME, KEY_SEX, KEY_DOB, KEY_AGE, KEY_ADDR, KEY_CITY, KEY_STATE, KEY_ZIP};
	
	private static final String DATABASE_CREATE=
			"create table " + DATABASE_TABLE 
			+ " (" + KEY_ROWID + " integer primary key autoincrement, "
			+ KEY_NAME + " text not null, "
			+ KEY_SEX + " text not null,"
			+ KEY_DOB + " text not null, "
			+ KEY_AGE + " integer not null,"
			
			// Rest  of creation:
			+ KEY_ADDR + " text not null,"
			+ KEY_CITY + " text not null,"
			+ KEY_STATE + " text not null,"
			+ KEY_ZIP + " integer not null"
			+");";
	private final Context context;
	
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;
	
	public DBAdapter open() throws SQLException{
		db = DBHelper.getWritableDatabase();
		return this;
	}
	public void close(){
		DBHelper.close();
	}
	public DBAdapter(Context ctx){
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}
	
	private static class DatabaseHelper extends SQLiteOpenHelper{
		DatabaseHelper(Context context){
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		
		@Override
		public void onCreate(SQLiteDatabase db){
			try{
				db.execSQL(DATABASE_CREATE);			
			}catch (SQLException e){
			e.printStackTrace();
			}
		}
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS contacts");
			onCreate(db);
		}
		
	}
	
	
	public long insertRecord(String name, String sex, String dob, String age, String address, String city, String zip, String state){
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_NAME, name);
		initialValues.put(KEY_SEX, sex);
		initialValues.put(KEY_DOB, dob);
		initialValues.put(KEY_AGE, age);
		initialValues.put(KEY_ADDR, address);
		initialValues.put(KEY_CITY,	city);
		initialValues.put(KEY_STATE, state );
		initialValues.put(KEY_ZIP, zip);
		return db.insert(DATABASE_TABLE, null, initialValues);
		
	}
	public boolean deleteContact(long rowId){
		return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) >0;
	}
	public Cursor getAllRecords(){
		String where = null;
		Cursor c = 	db.query(true, DATABASE_TABLE, ALL_KEYS, 
							where, null, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}
	public Cursor getRecord(long rowId) throws SQLException{
		String where = KEY_ROWID + "=" + rowId;
		Cursor c = 	db.query(true, DATABASE_TABLE, ALL_KEYS, 
						where, null, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}
	/*public Cursor getCursor() throws SQLException{
		SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
		queryBuilder.setTables(DATABASE_TABLE);
		String[] asColumnsToReturn = new String[] {KEY_ROWID, KEY_NAME};
		
		Cursor mCursor = queryBuilder.query(db, asColumnsToReturn, null, null, null, null, "name ASC");
		return mCursor;
	}*/
	public String getName(Cursor c){
		return(c.getString(1));
	}
	public boolean updateRecord(long rowId, String name, String sex, String dob, String age, String address, String city, String state, String zip){
		ContentValues args = new ContentValues();
		args.put(KEY_NAME, name);
		args.put(KEY_SEX, sex);
		args.put(KEY_DOB, dob);
		args.put(KEY_ADDR, address);
		args.put(KEY_CITY, city);
		args.put(KEY_STATE, state);
		args.put(KEY_ZIP, zip);
		return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
	}
}
