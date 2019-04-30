package com.example.sql_demo;


/*
Created by Suva Shahria
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/*
Creates a database for students
 */
public class dbStudentHandler extends SQLiteOpenHelper {


    //info to create student table
    public static final String DATABASE_NAME = "Students.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "EMAIL";
    public static final String COL_3 = "NAME";
    public static final String COL_4 = "SURNAME";
    public static final String COL_5 = "LOT";
    public static final String COL_6 = "TMPLOT";
    public static final String COL_7 = "PASSWORD";
    public static final String COL_8 = "DAY";
    public static final String COL_9 = "FACULTY";

    //Initialize
    public dbStudentHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,EMAIL TEXT,NAME TEXT,SURNAME TEXT,LOT INTEGER,TMPLOT INTEGER,PASSWORD INTEGER,DAY INTEGER,FACULTY INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    /*
    Adds new data into cell.
    Uses id for unique entries. If id exists will not add. This is an insert not update.
    Update is separate class
     */
    public boolean insertDataStudent(Students student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,student.get_id());
        contentValues.put(COL_2,student.get_email());
        contentValues.put(COL_3,student.get_name());
        contentValues.put(COL_4,student.getSurname());
        contentValues.put(COL_5,student.getLot());
        contentValues.put(COL_6,student.getTmplot());
        contentValues.put(COL_7,student.getPassword());
        contentValues.put(COL_8,student.getDay());
        contentValues.put(COL_9,student.get_Faculty());
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    /*
    Used to print entire database for testing
     */
    public Cursor getStudentData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    /*
    Used to update table. Pass correct student and String ruid.
    RUID is stored as an int but need to pass as string
    ex. String id = "159001111"
     */
    public boolean updateData(Students student,String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,student.get_id());
        contentValues.put(COL_2,student.get_email());
        contentValues.put(COL_3,student.get_name());
        contentValues.put(COL_4,student.getSurname());
        contentValues.put(COL_5,student.getLot());
        contentValues.put(COL_6,student.getTmplot());
        contentValues.put(COL_7,student.getPassword());
        contentValues.put(COL_8,student.getDay());
        contentValues.put(COL_9,student.get_Faculty());
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }
    /*
    Uses primary key id to delete data
     */
    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}