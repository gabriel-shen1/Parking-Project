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

public class BuschLots extends AppCompatActivity {

    //private TextView Spot1;
    private boolean table_flg = false;

    private TextView lot48;
    private TextView lot51;
    private TextView lot51A;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busch_lots);

        lot48 = (TextView) findViewById(R.id.lot48);
        lot51 = (TextView) findViewById(R.id.lot51);
        lot51A = (TextView) findViewById(R.id.lot51A);


        lot48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                Intent intent = new Intent(BuschLots.this, Busch_Lot48.class);
                startActivity(intent);
            }
        });

        lot51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                Intent intent = new Intent(BuschLots.this, Busch_Lot51.class);
                startActivity(intent);
            }
        });

        lot51A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                Intent intent = new Intent(BuschLots.this, Busch_Lot51A.class);
                startActivity(intent);
            }
        });
    }
    public void collapseTable(View view) {
        TableLayout table = findViewById(R.id.table);
        Button switchBtn = findViewById(R.id.switchBtn);

        // setColumnCollapsed(int columnIndex, boolean isCollapsed)
        table.setColumnCollapsed(1, table_flg);
        table.setColumnCollapsed(2, table_flg);

        if (table_flg) {
            // Close
            table_flg = false;
            switchBtn.setText("Show Detail");
        } else {
            // Open
            table_flg = true;
            switchBtn.setText("Hide Detail");
        }

    }
}