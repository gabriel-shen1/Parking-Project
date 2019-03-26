package com.example.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Username;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;
    private Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText) findViewById(R.id.editUsername);
        Password = (EditText) findViewById(R.id.editPassword);
        Info = (TextView) findViewById(R.id.txtAttempts);
        Login = (Button) findViewById(R.id.btnLogin);
        Register = (Button) findViewById(R.id.btnRegister);
        Info.setText("Number of attempts remaing 5");

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(), Password.getText().toString());


            }
        });



        }

    private void validate(String Username, String Password){
        if((Username.equals("Admin")) && (Username.equals("1234"))){ //this with change to grab from database
            Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
            startActivity(intent);
        }
        else{
            counter--;
            Info.setText("Number of remaining attempts: "+ String.valueOf(counter));
            if(counter == 0 ){
                Login.setEnabled(false);

            }
        }
    }
}
