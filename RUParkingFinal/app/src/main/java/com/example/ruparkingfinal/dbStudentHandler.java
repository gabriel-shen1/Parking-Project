package com.example.ruparkingfinal;


/*
Created by Suva Shahria
Assisted by Anthony Lau and KRITHIKA UTHAMAN
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
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,EMAIL TEXT,NAME TEXT,SURNAME TEXT,LOT INTEGER,TMPLOT TEXT,PASSWORD TEXT,DAY INTEGER,FACULTY INTEGER)");
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
    public boolean insertDataStudent(int id, String email, String first, String surname, int lot, String templot, String password, int day, int faculty) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,email);
        contentValues.put(COL_3,first);
        contentValues.put(COL_4,surname);
        contentValues.put(COL_5,lot);
        contentValues.put(COL_6,templot);
        contentValues.put(COL_7,password);
        contentValues.put(COL_8,day);
        contentValues.put(COL_9,faculty);
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

    public Boolean checkemail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from student_table where _email = ?", new String[]{email});
        if(cursor.getCount() > 0) return false;
        else
            return true;
    }

    public Boolean emailpassword(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from student_table where email = ? and password = ?", new String[] {email, password});
        if(cursor.getCount()>0) return true;
        else return false;
    }

    public int getStudentInfo(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from student_table where COL_2 = email", new String[]{email});
        cursor.moveToFirst();
        int Lot_ID;

        Lot_ID = cursor.getInt(cursor.getColumnIndex(COL_5));
       /* Students student = new Students();
        //set related infomation into Student object
        student.set_id(cursor.getInt(cursor.getColumnIndex(COL_1)));
        student.set_email(cursor.getString(cursor.getColumnIndex(COL_2)));
        student.set_name(cursor.getString(cursor.getColumnIndex(COL_3)));
        student.setSurname(cursor.getString(cursor.getColumnIndex(COL_4)));
        student.setLot(cursor.getString(cursor.getColumnIndex(COL_5)));
        student.setTmplot(cursor.getString(cursor.getColumnIndex(COL_6)));
        student.setPassword(cursor.getString(cursor.getColumnIndex(COL_7)));
        student.setDay(cursor.getInt(cursor.getColumnIndex(COL_8)));
        student.set_Faculty(cursor.getInt(cursor.getColumnIndex(COL_9)));

        cursor.close();
        db.close();

        return student;
*/
        return Lot_ID;
    }

    //Takes in the ID of the Lot and the ID of the Student
    //Returns Boolean of whether they can enter the lot or not and if True increases occupancy
    public Boolean Enter(String LotID, String StudentID){
        SQLiteDatabase db = this.getWritableDatabase();

        String [] Student = {dbStudentHandler.COL_5};
        Cursor cursor = db.query(dbStudentHandler.TABLE_NAME, Student,dbStudentHandler.COL_1+" = '"+StudentID+"'", null, null, null, null);

        String StudentCampus = cursor.getString(1);


        String [] Lot = {LotsDbHandler.COL_3, LotsDbHandler.COL_5};
        Cursor cursor1 = db.query(LotsDbHandler.TABLE_NAME, Lot,LotsDbHandler.COL_1+" = '"+LotID+"'", null, null, null, null);
        String LotCampus = cursor1.getString(1);
        String curr = cursor1.getString(2);

        Integer current = Integer.valueOf(curr);

        if(StudentCampus==LotCampus){
            current = current +1;

            ContentValues contentValues = new ContentValues();
            contentValues.put(LotsDbHandler.COL_5, current);
            String[] whereArgs = {LotID};
            db.update(LotsDbHandler.TABLE_NAME, contentValues, LotsDbHandler.COL_1+"=?", whereArgs);
            return true;
        }

        else{
            return false;
        }

    }


}
