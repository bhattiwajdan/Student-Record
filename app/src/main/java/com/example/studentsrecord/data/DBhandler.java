package com.example.studentsrecord.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

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
                + COLUMN_ID + " TEXT PRIMARY KEY ,"
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

    public int insertStudent(Student student) {
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

        int i = (int) db.insert(TABLE_NAME, null, values);
        db.close();
        return i;
    }

    public void updateStudetnt(Student student)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SURAH, student.getSurah());
        values.put(COLUMN_PARA, student.getPara());
        values.put(COLUMN_VERSE_START, student.getStartVerse());
        values.put(COLUMN_VERSE_END, student.getEndVerse());
        values.put(COLUMN_SABQI, student.getSabqi());
        values.put(COLUMN_MANZIL, student.getManzil());

        db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[] {student.getId()});
        db.close();

    }

    public void deleteStudent(String rollNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] {rollNo});
        db.close();
    }

    public Student getStudent(String rollNo) {
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to
        // read data from database.
        Cursor cursorStudent
                = db.rawQuery("SELECT * FROM " + TABLE_NAME +" WHERE "+COLUMN_ID+"= "+rollNo, null);

        Student student = null;
        if(cursorStudent.moveToFirst())
        {
            do{

                         student = new Student(
                        cursorStudent.getString(0),
                        cursorStudent.getString(1),
                        cursorStudent.getInt(2),
                        cursorStudent.getInt(3),
                        cursorStudent.getInt(4),
                        cursorStudent.getInt(5),
                        cursorStudent.getInt(6),
                        cursorStudent.getInt(7),
                        cursorStudent.getInt(8));
            }while(cursorStudent.moveToNext());
        }

        cursorStudent.close();

        return student;
    }
    public void showdb(){

        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to
        // read data from database.
        Cursor cursorCourses
                = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<Student> students = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from
                // cursor to our array list.
                students.add(new Student(
                        cursorCourses.getString(0),
                        cursorCourses.getString(1),
                        cursorCourses.getInt(2),
                        cursorCourses.getInt(3),
                        cursorCourses.getInt(4),
                        cursorCourses.getInt(5),
                        cursorCourses.getInt(6),
                        cursorCourses.getInt(7),
                        cursorCourses.getInt(8)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();

        System.out.println(students.size());
        for(int i=0; i<students.size();i++)
        {
            System.out.println("in loop");
            System.out.println(students.get(i));
        }
    }

}


