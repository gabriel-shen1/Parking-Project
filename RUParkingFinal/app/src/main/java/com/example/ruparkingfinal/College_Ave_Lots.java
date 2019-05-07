package com.example.ruparkingfinal;

/*
    Created by Andrew Schneeloch
    Assisted by Anthony Lau
*/


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TableLayout;
import android.widget.Button;

public class College_Ave_Lots extends AppCompatActivity {

    //private TextView Spot1;
    private boolean table_flg1 = false;

    private TextView lot7;
    private TextView lot11;
    private TextView lot12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busch_lots);

        lot7 = (TextView) findViewById(R.id.lot7);
        lot11 = (TextView) findViewById(R.id.lot11);
        lot12 = (TextView) findViewById(R.id.lot12);


        lot7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                Intent intent = new Intent(College_Ave_Lots.this, CA_Lot7.class);
                startActivity(intent);
            }
        });

        lot11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                Intent intent = new Intent(College_Ave_Lots.this, CA_Lot11.class);
                startActivity(intent);
            }
        });

        lot12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                Intent intent = new Intent(College_Ave_Lots.this, CA_Lit12.class);
                startActivity(intent);
            }
        });
    }
    public void collapseTable(View view) {
        TableLayout table1 = findViewById(R.id.table);
        Button switchBtn1 = findViewById(R.id.switchBtn);

        // setColumnCollapsed(int columnIndex, boolean isCollapsed)
        table1.setColumnCollapsed(1, table_flg1);
        table1.setColumnCollapsed(2, table_flg1);

        if (table_flg1) {
            // Close
            table_flg1 = false;
            switchBtn1.setText("Show Detail");
        } else {
            // Open
            table_flg1 = true;
            switchBtn1.setText("Hide Detail");
        }

    }
}