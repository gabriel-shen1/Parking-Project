package com.example.ruparkingfinal;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

    public class Main2Activity extends AppCompatActivity {
        dbStudentHandler db;
        LotsDbHandler Ldb;
        Button button;
        CreateDB cDB;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            db = new dbStudentHandler(this);
            Ldb = new LotsDbHandler(this);
            //button= (Button)findViewById(R.id.button);

            cDB = new CreateDB(this);


            showData();
        }
        /*
        Used as testing to show data
         */
        public void showData(){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Cursor res = cDB.getLdb().getLotData();
                    if(res.getCount() == 0) {
                        // show message
                        Toast.makeText(Main2Activity.this,"No data",Toast.LENGTH_LONG).show();
                        return;
                    }

                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("Id :"+ res.getString(0)+"\n");
                        buffer.append("NAME :"+ res.getString(1)+"\n");
                        buffer.append("CAMPUS :"+ res.getString(2)+"\n");
                        buffer.append("FACULTY :"+ res.getString(3)+"\n");
                        buffer.append("CURR :"+ res.getString(4)+"\n");
                        buffer.append("M10_2 :"+ res.getString(5)+"\n");
                        buffer.append("M2_4 :"+ res.getString(6)+"\n");
                        buffer.append("M4_6 :"+ res.getString(7)+"\n");
                        buffer.append("M6_8 :"+ res.getString(8)+"\n");
                        buffer.append("M8_10 :"+ res.getString(9)+"\n");
                        buffer.append("T10_2 :"+ res.getString(10)+"\n");
                        buffer.append("T2_4 :"+ res.getString(11)+"\n");
                        buffer.append("T4_6 :"+ res.getString(12)+"\n");
                        buffer.append("T6_8 :"+ res.getString(13)+"\n");
                        buffer.append("T8_10 :"+ res.getString(14)+"\n\n");






                    }

                    //used to show student database
                /*
                Cursor res = db.getStudentData();
                if(res.getCount() == 0) {
                    // show message
                    Toast.makeText(MainActivity.this,"No data",Toast.LENGTH_LONG).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id :"+ res.getString(0)+"\n");
                    buffer.append("EMAIL :"+ res.getString(1)+"\n");
                    buffer.append("NAME :"+ res.getString(2)+"\n");
                    buffer.append("SURNAME :"+ res.getString(3)+"\n\n");
                }
            */
                    showMessage("Data",buffer.toString());
                    String id = "2";
                    cDB.getLdb().deleteData(id);

                }
            });
        }
        /*
        used for testing
         */
        public void showMessage(String title,String Message){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(Message);
            builder.show();
        }

    }