package com.example.ruparkingfinal;

import android.content.Context;
/*
Create by Suva Shahria
Assisted by Anthony Lau
 */

public class CreateDB {
    dbStudentHandler db;
    LotsDbHandler Ldb;
    Students s1;
    Students s2;
    Students s3;
    Students f1;
    Lots b1;
    Lots b2;
    Lots b3;
    Lots a1;
    Lots a2;
    Lots a3;
    Lots c1;
    Lots c2;
    Lots c3;

    Lots bf1;
    Lots lf1;


    /*
    Initializes database variables and addes them to the database
     */
    public CreateDB(Context context) {

        db = new dbStudentHandler(context);
        Ldb = new LotsDbHandler(context);

        s1 = new Students("ss2@scarletmail.rutgers.edu", 145002121, "jerry", "finn",1,null,"pass",-1,-1);

        s2 = new Students("ss3@scarletmail.rutgers.edu", 146004121, "max", "finn",2,null,"psw2",-1,-1);

        s3 = new Students("ss4@scarletmail.rutgers.edu", 145007721, "hal", "finn",3,null,"psw3",-1,-1);

        f1 = new Students("ss5@scarletmail.rutgers.edu", 145008721, "marsic", "finn",4,null,"psw3",-1,1);

        b1 = new Lots(1,"buschLotA","Busch",-1,58);
        b2 = new Lots(2,"buschLotB","Busch",-1,51);
        b3 = new Lots(3,"buschLotC","Busch",-1,46);



        a1 = new Lots(4,"LiviLotA","Livi",-1,44);
        a2 = new Lots(5,"LiviLotB","Livi",-1,56);
        a3 = new Lots(6,"LiviLotC","Livi",-1,48);

        c1 = new Lots(7,"ColLotA","College Ave",-1,40);
        c2 = new Lots(8,"ColLotB","College Ave",-1,51);
        c3 = new Lots(9,"ColLotC","College Ave",-1,49);

        bf1 = new Lots(10,"fbuschLotA","Busch",1,31);
        lf1 = new Lots(11,"fLiviLotA","Busch",-1,33);

        initBuschLots(b1,b2,b3);
        initLiviLots(a1,a2,a3);
        initColLots(c1,c2,c3);
        initFacLots(bf1,lf1);
        boolean x;
        Ldb.insertDataLot(b1);
        Ldb.insertDataLot(b2);
        Ldb.insertDataLot(b3);
        Ldb.insertDataLot(a1);
        Ldb.insertDataLot(a2);
        Ldb.insertDataLot(a3);
        Ldb.insertDataLot(c1);
        Ldb.insertDataLot(c2);
        Ldb.insertDataLot(c3);
        Ldb.insertDataLot(bf1);
        Ldb.insertDataLot(lf1);

        db.insertDataStudent(145002121,"ss2@scarletmail.rutgers.edu", "jerry", "finn",1,null, "psw1" ,-1,-1);
        db.insertDataStudent(146004121, "ss3@scarletmail.rutgers.edu" , "max", "finn",2,null,"psw2",-1,-1);
        db.insertDataStudent(145007721, "ss3@scarletmail.rutgers.edu", "hal", "finn",3, null,"psw3",-1,-1);


        //int id, String email, String first, String surname, String lot, String templot, String password, int day, int faculty



    }
    /*
    Getters and setters for data needed
     */
    public dbStudentHandler getDb() {
        return db;
    }

    public void setDb(dbStudentHandler db) {
        this.db = db;
    }

    public LotsDbHandler getLdb() {
        return Ldb;
    }

    public void setLdb(LotsDbHandler ldb) {
        Ldb = ldb;
    }

    /*
    Initialize lots with data
     */
    public void initBuschLots(Lots b1, Lots b2, Lots b3){
        b1.setM(30,42,55,77,41);
        b1.setTu(42,55,32,61,20);
        b1.setW(31,55,60,80,55);
        b1.setTh(41,47,51,44,66);
        b1.setF(28,31,44,71,34);

        b2.setM(35,45,58,67,33);
        b2.setTu(52,52,41,57,44);
        b2.setW(34,51,44,90,55);
        b2.setTh(31,42,66,77,43);
        b2.setF(34,51,62,73,56);

        b3.setM(41,48,52,55,62);
        b3.setTu(42,45,42,62,30);
        b3.setW(41,47,51,44,66);
        b3.setTh(31,41,61,64,66);
        b3.setF(48,34,42,63,31);

    }

    public void initLiviLots(Lots a1, Lots a2, Lots a3){
        a1.setM(60,52,55,90,41);
        a1.setTu(32,45,42,41,50);
        a1.setW(34,43,44,62,31);
        a1.setTh(52,57,51,54,44);
        a1.setF(71,51,66,71,34);

        a2.setM(33,44,65,88,31);
        a2.setTu(71,51,66,71,34);
        a2.setW(34,43,44,62,31);
        a2.setTh(63,51,55,90,41);
        a2.setF(42,58,66,67,32);

        a3.setM(60,52,55,90,41);
        a3.setTu(66,73,34,41,50);
        a3.setW(30,43,55,51,66);
        a3.setTh(45,42,45,54,44);
        a3.setF(58,51,66,79,34);

    }

    public void initColLots(Lots c1, Lots c2, Lots c3){
        c1.setM(30,42,55,77,41);
        c1.setTu(42,55,32,61,20);
        c1.setW(31,55,60,80,55);
        c1.setTh(41,47,51,44,66);
        c1.setF(28,31,44,71,34);

        c2.setM(42,40,55,44,55);
        c2.setTu(42,55,28,31,44);
        c2.setW(21,45,60,71,35);
        c2.setTh(41,47,31,55,60);
        c2.setF(28,31,30,43,55);

        c3.setM(30,42,55,77,41);
        c3.setTu(32,54,32,81,40);
        c3.setW(42,41,47,51,44);
        c3.setTh(41,47,52,55,62);
        c3.setF(28,31,44,71,34);

    }
    public void initFacLots(Lots bf1, Lots lf1){
        bf1.setM(21,24,33,44,41);
        bf1.setTu(22,37,28,43,20);
        bf1.setW(31,45,50,63,49);
        bf1.setTh(31,39,41,44,39);
        bf1.setF(28,31,57,61,51);

        lf1.setM(32,40,58,34,32);
        lf1.setTu(42,65,48,51,44);
        lf1.setW(21,45,60,71,35);
        lf1.setTh(41,47,55,55,47);
        lf1.setF(28,31,32,40,58);
    }
}