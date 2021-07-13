package com.example.practical_5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLiteAdapter {
    public static final String MYDATABASE_NAME = "MY_DATABASE";
    public static final String MYDATABASE_TABLE = "MY_TABLE_FOOD";
    public static final int MYDATABASE_VERSION = 2;
    public static final String KEY_CONTENT = "Content";
    public static final String KEY_CONTENT_2 = "Ingredient";
    public static final String VALUE = "Price";

    // CREATE TABLE MY_TABLE_FOOD (id INTEGER PRIMARY KEY AUTOINCREMENT, Content text not null, Ingredient text, Price int);
    private SQLiteHelper sqLiteHelper;
    private static final String SCRIPT_CREATE_DATABASE =
            "create table " + MYDATABASE_TABLE
                    + " (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + KEY_CONTENT + " text not null, "
                    + KEY_CONTENT_2 + " text, "
                    + VALUE + " int);";
    private SQLiteDatabase sqLiteDatabase;
    private Context context;

    public SQLiteAdapter(Context c) {
        context = c;
    }

    public SQLiteAdapter openToRead() throws android.database.SQLException {
        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getReadableDatabase();
        return this;
    }

    public SQLiteAdapter openToWrite() throws android.database.SQLException {
        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        sqLiteHelper.close();
    }

    public long insert(String content, String content_2, int content_3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_CONTENT, content);
        contentValues.put(KEY_CONTENT_2, content_2);
        contentValues.put(VALUE, content_3);
        return sqLiteDatabase.insert(MYDATABASE_TABLE, null, contentValues);
    }

    public int deleteAll() {
        return sqLiteDatabase.delete(MYDATABASE_TABLE, null, null);
    }

    // Question 2
    public String queueMultipleColumn() {
        String[] columns = new String[]{KEY_CONTENT, KEY_CONTENT_2, VALUE};
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
                KEY_CONTENT_2 + "=? OR " + KEY_CONTENT_2 + "=?",
                new String[]{"Rice", "Flour"}, null, null, null);
        String result = "";

        /** Get Column ID*/
        int index_CONTENT = cursor.getColumnIndex(KEY_CONTENT);
        int index_CONTENT_2 = cursor.getColumnIndex(KEY_CONTENT_2);
        int index_CONTENT_3 = cursor.getColumnIndex(VALUE);

        for (cursor.moveToFirst(); !(cursor.isAfterLast());
             cursor.moveToNext()) {
            result = result + cursor.getString(index_CONTENT) + "; "
                    + cursor.getString(index_CONTENT_2) + "; "
                    + cursor.getString(index_CONTENT_3)
                    + "\n";
        }
        return result;
    }

    public class SQLiteHelper extends SQLiteOpenHelper {
        public SQLiteHelper(Context context, String name, CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SCRIPT_CREATE_DATABASE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(SCRIPT_CREATE_DATABASE);
        }
    }
}