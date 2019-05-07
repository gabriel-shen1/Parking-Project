package com.example.ruparkingfinal;

/*
    Created by Anthony Lau
    Assisted by Andrew Schneeloch
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.database.Cursor;

public class SelectCampus extends AppCompatActivity {

    dbStudentHandler db;
    private Button Busch;
    private Button Livi;
    private Button CollegeAve;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_campus);


        Busch = (Button) findViewById(R.id.buttonBusch);
        Livi = (Button) findViewById(R.id.buttonLivi);
        CollegeAve = (Button) findViewById(R.id.buttonCollegeAve);

        //text = (TextView) findViewById(R.id.textView);


        //db = new dbStudentHandler(this);

        //Cursor cursor = db.getStudentData();
        Intent intent = getIntent();
        String string = intent.getExtras().getString("Email");

        //text.setText(string);
        Busch.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View v) {
             Intent intent = new Intent(SelectCampus.this, BuschLots.class);
             startActivity(intent);
             }

        });

        Livi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SelectCampus.this, LiviLots.class);
                startActivity(intent1);
            }
        });

        CollegeAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCampus.this, College_Ave_Lots.class);
                startActivity(intent);
            }
        });

    }

}
