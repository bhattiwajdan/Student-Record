package com.example.studentsrecord.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhandler extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "students.db";
    private static final String TABLE_NAME = "students";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_CLASS = "class";
    private static final String COLUMN_AGE = "age";

    private static final String COLUMN_SURAH = "surah_no";
    private static final String COLUMN_PARA = "para_no";
    private static final String COLUMN_VERSE_START = "start_verse";
    private static final String COLUMN_VERSE_END = "end_verse";
    private static final String COLUMN_SABQI = "sabqi";
    private static final String COLUMN_MANZIL = "manzil";


    public DBhandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_AGE + " INTEGER,"
                + COLUMN_CLASS + " INTEGER,"
                + COLUMN_SURAH + " INTEGER,"
                + COLUMN_PARA + " INTEGER,"
                + COLUMN_VERSE_START + " INTEGER,"
                + COLUMN_VERSE_END + " INTEGER,"
                + COLUMN_SABQI + " INTEGER,"
                + COLUMN_MANZIL + " INTEGER"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_AGE, student.getAge());
        values.put(COLUMN_CLASS, student.get_Class());
        values.put(COLUMN_SURAH, student.getSurah());
        values.put(COLUMN_PARA, student.getPara());
        values.put(COLUMN_VERSE_START, student.getStartVerse());
        values.put(COLUMN_VERSE_END, student.getEndVerse());
        values.put(COLUMN_SABQI, student.getSabqi());
        values.put(COLUMN_MANZIL, student.getManzil());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }


}


