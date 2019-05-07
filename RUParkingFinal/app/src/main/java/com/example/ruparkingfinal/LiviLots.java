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

public class LiviLots extends AppCompatActivity {

    //private TextView Spot1;
    private boolean table_flg = false;

    private TextView yellow;
    private TextView lot101;
    private TextView lot105;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busch_lots);

        yellow = (TextView) findViewById(R.id.yellow);
        lot101 = (TextView) findViewById(R.id.lot101);
        lot105 = (TextView) findViewById(R.id.lot105);


        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                Intent intent = new Intent(LiviLots.this, Livi_Yellow.class);
                startActivity(intent);
            }
        });

        lot101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                Intent intent = new Intent(LiviLots.this, Livi_Lot101.class);
                startActivity(intent);
            }
        });

        lot105.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                Intent intent = new Intent(LiviLots.this, Livi_Lot105.class);
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