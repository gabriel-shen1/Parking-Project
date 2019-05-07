package com.example.ruparkingfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/*
Created by Suva Shahria
Assisted by Anthony Lau
 */

/*
Creates lots database
 */
public class LotsDbHandler extends SQLiteOpenHelper {


    //info to create student table
    public static final String DATABASE_NAME = "lots.db";
    public static final String TABLE_NAME = "lots_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "CAMPUS";
    public static final String COL_4 = "FACULTY";
    public static final String COL_5 = "CURR";

    public static final String COL_6 = "M10_2";
    public static final String COL_7 = "M2_4";
    public static final String COL_8 = "M4_6";
    public static final String COL_9 = "M6_8";
    public static final String COL_10 = "M8_10";

    public static final String COL_11 = "TU10_2";
    public static final String COL_12 = "TU2_4";
    public static final String COL_13 = "TU4_6";
    public static final String COL_14 = "TU6_8";
    public static final String COL_15 = "TU8_10";

    public static final String COL_16 = "W10_2";
    public static final String COL_17 = "W2_4";
    public static final String COL_18 = "W4_6";
    public static final String COL_19 = "W6_8";
    public static final String COL_20 = "W8_10";

    public static final String COL_21 = "TH10_2";
    public static final String COL_22 = "TH2_4";
    public static final String COL_23 = "TH4_6";
    public static final String COL_24 = "TH6_8";
    public static final String COL_25 = "TH8_10";

    public static final String COL_26 = "F10_2";
    public static final String COL_27 = "F2_4";
    public static final String COL_28 = "F4_6";
    public static final String COL_29 = "F6_8";
    public static final String COL_30 = "F8_10";

    //Initialize
    public LotsDbHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,CAMPUS TEXT,FACULTY INTEGER,CURR INTEGER,M10_2 INTEGER,M2_4 INTEGER,M4_6 INTEGER,M6_8 INTEGER,M8_10 INTEGER,TU10_2 INTEGER,TU2_4 INTEGER,TU4_6 INTEGER,TU6_8 INTEGER,TU8_10 INTEGER,W10_2 INTEGER,W2_4 INTEGER,W4_6 INTEGER,W6_8 INTEGER,W8_10 INTEGER,TH10_2 INTEGER,TH2_4 INTEGER,TH4_6 INTEGER,TH6_8 INTEGER,TH8_10 INTEGER,F10_2 INTEGER,F2_4 INTEGER,F4_6 INTEGER,F6_8 INTEGER,F8_10 INTEGER)");    }

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
    public boolean insertDataLot(Lots lot) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put(COL_1,lot.get_id());
        contentValues.put(COL_2,lot.get_name());
        contentValues.put(COL_3,lot.get_campus());
        contentValues.put(COL_4,lot.get_faculty());
        contentValues.put(COL_5,lot.get_curr());
        contentValues.put(COL_6,lot.m10_2);
        contentValues.put(COL_7,lot.m2_4);
        contentValues.put(COL_8,lot.m4_6);
        contentValues.put(COL_9,lot.m6_8);
        contentValues.put(COL_10,lot.m8_10);
        contentValues.put(COL_11,lot.tu10_2);
        contentValues.put(COL_12,lot.tu2_4);
        contentValues.put(COL_13,lot.tu4_6);
        contentValues.put(COL_14,lot.tu6_8);
        contentValues.put(COL_15,lot.tu8_10);
        contentValues.put(COL_16,lot.w10_2);
        contentValues.put(COL_17,lot.w2_4);
        contentValues.put(COL_18,lot.w4_6);
        contentValues.put(COL_19,lot.w6_8);
        contentValues.put(COL_20,lot.w8_10);
        contentValues.put(COL_21,lot.th10_2);
        contentValues.put(COL_22,lot.th2_4);
        contentValues.put(COL_23,lot.th4_6);
        contentValues.put(COL_24,lot.th6_8);
        contentValues.put(COL_25,lot.th8_10);
        contentValues.put(COL_26,lot.f10_2);
        contentValues.put(COL_27,lot.f2_4);
        contentValues.put(COL_28,lot.f4_6);
        contentValues.put(COL_29,lot.f6_8);
        contentValues.put(COL_30,lot.f8_10);







        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }
    /*
        Used to print entire database for testing
         */
    public Cursor getLotData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    /*
        Used to update table. Pass correct student and String ruid.
        RUID is stored as an int but need to pass as string
        ex. String id = "1"
         */
    public boolean updateData(Lots lot, String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,lot.get_id());
        contentValues.put(COL_2,lot.get_name());
        contentValues.put(COL_3,lot.get_campus());
        contentValues.put(COL_4,lot.get_faculty());
        contentValues.put(COL_5,lot.get_curr());
        contentValues.put(COL_6,lot.m10_2);
        contentValues.put(COL_7,lot.m2_4);
        contentValues.put(COL_8,lot.m4_6);
        contentValues.put(COL_9,lot.m6_8);
        contentValues.put(COL_10,lot.m8_10);
        contentValues.put(COL_11,lot.tu10_2);
        contentValues.put(COL_12,lot.tu2_4);
        contentValues.put(COL_13,lot.tu4_6);
        contentValues.put(COL_14,lot.tu6_8);
        contentValues.put(COL_15,lot.tu8_10);
        contentValues.put(COL_16,lot.w10_2);
        contentValues.put(COL_17,lot.w2_4);
        contentValues.put(COL_18,lot.w4_6);
        contentValues.put(COL_19,lot.w6_8);
        contentValues.put(COL_20,lot.w8_10);
        contentValues.put(COL_21,lot.th10_2);
        contentValues.put(COL_22,lot.th2_4);
        contentValues.put(COL_23,lot.th4_6);
        contentValues.put(COL_24,lot.th6_8);
        contentValues.put(COL_25,lot.th8_10);
        contentValues.put(COL_26,lot.f10_2);
        contentValues.put(COL_27,lot.f2_4);
        contentValues.put(COL_28,lot.f4_6);
        contentValues.put(COL_29,lot.f6_8);
        contentValues.put(COL_30,lot.f8_10);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }
    /*
        Uses primary key id to delete data. Deletes entire row
         */
    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}

