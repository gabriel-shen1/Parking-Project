package com.example.loginpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private EditText fName;
    private EditText lName;
    private EditText Netid;
    private EditText dob;
    private EditText email;
    private EditText pp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Username = (EditText) findViewById(R.id.txtUsername);
        Password = (EditText) findViewById(R.id.txtPass);
        fName =(EditText) findViewById(R.id.txtFristname);
        lName = (EditText) findViewById(R.id.txtLastname);
        Netid = (EditText) findViewById(R.id.txtNetid);
        dob = (EditText)findViewById(R.id.txtDob);
        email = (EditText)findViewById(R.id.txtEmail);
        pp =(EditText)findViewById(R.id.txtPermit);
        




    }
}
