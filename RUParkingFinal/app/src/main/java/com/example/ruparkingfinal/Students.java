package com.example.ruparkingfinal;

/*
Created By Suva Shahria
Assisted by Anthony Lau
 */

/*
Stuent class to be added to database
 */
public class Students {
    int _id; //primary key, ruid ex 159003711
    String _email;//scarletmail
    String _name;
    String surname;
    int lot;//access to which lot, 1 busch, 2 livi, 3 college ave
    String tmplot; // access to this lot tmp
    String password;
    int day; // int for day of month
    int _faculty;//-1 student, 1 faculty

    /*
    Initialize data
     */
    public Students(String _email, int _id, String _name, String surname, int lot, String tmplot, String password, int day, int faculty) {
        this._email = _email;
        this._id = _id;
        this._name = _name;
        this.surname = surname;
        this.lot = lot;
        this.tmplot = tmplot;
        this.password = password;
        this.day = day;
        this._faculty= faculty;
    }

    /*
    Getters and setters for variables
     */
    public int get_Faculty() {
        return _faculty;
    }

    public void set_Faculty(int _faculty) {
        this._faculty = _faculty;
    }
    public Students() {
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getLot() {
        return lot;
    }

    public void setLot(int lot) {
        this.lot = lot;
    }

    public String getTmplot() {
        return tmplot;
    }

    public void setTmplot(String tmplot) {
        this.tmplot = tmplot;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}

