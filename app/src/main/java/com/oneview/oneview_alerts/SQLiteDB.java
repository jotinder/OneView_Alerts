package com.oneview.oneview_alerts;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteDB extends SQLiteOpenHelper  {
    public static final String DATABASE_NAME = "NotificationDetails.db";
    private static final int DATABASE_VERSION = 1;
    public static final String NOTIFICATION_TABLE_NAME = "notification";
    public static final String NOTIFICATION_DETAILS = "notification_text";
    public static final String NOTIFICATION_ID = "_id";

    public SQLiteDB(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NOTIFICATION_TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE " + NOTIFICATION_TABLE_NAME +
                        "(" + NOTIFICATION_ID + " INTEGER PRIMARY KEY, " +
                        NOTIFICATION_DETAILS+ " TEXT)"
        );
    }

    public boolean insertNotification(String notification){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NOTIFICATION_DETAILS,notification);
        db.insert(NOTIFICATION_TABLE_NAME,null,contentValues);
        return true;
    }

    public Cursor getNotification(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res =  db.rawQuery("SELECT * FROM " + NOTIFICATION_TABLE_NAME + " WHERE " +
                NOTIFICATION_ID + "=?", new String[]{Integer.toString(id)});
        return res;
    }

    public Cursor getAllNotifications() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res =  db.rawQuery( "SELECT * FROM " + NOTIFICATION_TABLE_NAME, null );
        return res;
    }
}

