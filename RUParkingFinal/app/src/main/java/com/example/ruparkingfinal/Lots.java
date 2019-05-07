package com.example.ruparkingfinal;



/*
Created by Suva Shahria
Assisted by Anthony Lau
 */

/*
Lot object to be stored in database
 */
public class Lots {
    int _id; // primary key. ex 1,2,3
    String _name;
    String _campus; //1 busch, 2 livi, 3 college
    int _faculty; //1 faculty //-1 all
    int _curr; //current number of cars in lot

    /*
    average amount of cars in day x during hours y of a normal working day
    ex: m10_2 - monday 10am to 2pm
     */
    int m10_2;
    int m2_4;
    int m4_6;
    int m6_8;
    int m8_10;

    int tu10_2;
    int tu2_4;
    int tu4_6;
    int tu6_8;
    int tu8_10;

    int w10_2;
    int w2_4;
    int w4_6;
    int w6_8;
    int w8_10;

    int th10_2;
    int th2_4;
    int th4_6;
    int th6_8;
    int th8_10;

    int f10_2;
    int f2_4;
    int f4_6;
    int f6_8;
    int f8_10;


    public Lots(int _id, String _name, String _campus, int _faculty, int _curr) {
        this._id = _id;
        this._name = _name;
        this._campus = _campus;
        this._faculty = _faculty;
        this._curr = _curr;
    }

    /*
    Used to initialize values
     */
    public void setM(int m1, int m2, int m3, int m4, int m5){
        this.m10_2 = m1;
        this.m2_4 = m2;
        this.m4_6 = m3;
        this.m6_8 = m4;
        this.m8_10 = m5;
    }
    /*
       Used to initialize values
        */
    public void setTu(int tu1, int tu2, int tu3, int tu4, int tu5){
        this.tu10_2 = tu1;
        this.tu2_4 = tu2;
        this.tu4_6 = tu3;
        this.tu6_8 = tu4;
        this.tu8_10 = tu5;
    }
    /*
       Used to initialize values
        */
    public void setW(int w1, int w2, int w3, int w4, int w5){
        this.w10_2 = w1;
        this.w2_4 = w2;
        this.w4_6 = w3;
        this.w6_8 = w4;
        this.w8_10 = w5;
    }
    /*
       Used to initialize values
        */
    public void setTh(int th1, int th2, int th3, int th4, int th5){
        this.th10_2 = th1;
        this.th2_4 = th2;
        this.th4_6 = th3;
        this.th6_8 = th4;
        this.th8_10 = th5;
    }
    /*
       Used to initialize values
        */
    public void setF(int f1, int f2, int f3, int f4, int f5){
        this.f10_2 = f1;
        this.f2_4 = f2;
        this.f4_6 = f3;
        this.f6_8 = f4;
        this.f8_10 = f5;
    }

    /*
    Getters and setters
     */
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_campus() {
        return _campus;
    }

    public void set_campus(String _campus) {
        this._campus = _campus;
    }

    public int get_faculty() {
        return _faculty;
    }

    public void set_faculty(int _faculty) {
        this._faculty = _faculty;
    }

    public int get_curr() {
        return _curr;
    }

    public void set_curr(int _curr) {
        this._curr = _curr;
    }
}