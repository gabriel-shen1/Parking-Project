package com.example.ruparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SelectCampus extends AppCompatActivity {

    private Button buttonCollegeAve;
    private Button buttonDouglass;
    private Button buttonBusch;
    private Button buttonLivi;
    private Button buttonCook;

    private Button buttonSignout;
    private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_campus);

        buttonSignout = (Button)findViewById(R.id.buttonSignout);
        buttonCook = (Button)findViewById(R.id.buttonCook);
        buttonCollegeAve = (Button)findViewById(R.id.buttonCollegeAve);
        buttonBusch = (Button)findViewById(R.id.buttonBusch);
        buttonDouglass = (Button)findViewById(R.id.buttonDouglass);
        buttonLivi = (Button)findViewById(R.id.buttonLivi);

        mauth = FirebaseAuth.getInstance();

        buttonSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mauth.signOut();
                Toast.makeText(SelectCampus.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SelectCampus.this, MainActivity.class));

            }
        });

        buttonCollegeAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                Intent intent = new Intent(SelectCampus.this, CollegeAveMap.class);
                startActivity(intent);
            }
        });
        buttonDouglass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                Intent intent = new Intent(SelectCampus.this, DouglassMap.class);
                startActivity(intent);
            }
        });

        buttonBusch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                Intent intent = new Intent(SelectCampus.this, BuschMap.class);
                startActivity(intent);
            }
        });
        buttonLivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                Intent intent = new Intent(SelectCampus.this, LiviMap.class);
                startActivity(intent);
            }
        });
        buttonCook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                Intent intent = new Intent(SelectCampus.this, CookMap.class);
                startActivity(intent);
            }
        });

    }
}
