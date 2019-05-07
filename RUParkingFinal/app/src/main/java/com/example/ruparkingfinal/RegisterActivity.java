package com.example.ruparkingfinal;

/*
    Created by Anthony Lau
    Assisted by Andrew Schneeloch
 */


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText editFN;
    private EditText editLN;
    private EditText newEmail;
    private EditText newPassword;
    private EditText RUID;
    private EditText Campus;
    private EditText Student;
    private EditText Confirm;

    private Button buttonCreate;

    dbStudentHandler db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editFN = (EditText) findViewById(R.id.editFN);
        editLN = (EditText) findViewById(R.id.editLN);
        newEmail = (EditText) findViewById(R.id.newEmail);
        newPassword = (EditText) findViewById(R.id.newPassword);
        RUID = (EditText) findViewById(R.id.RUID);
        Campus = (EditText) findViewById(R.id.Campus);
        Student = (EditText) findViewById(R.id.Student);
        Confirm = (EditText) findViewById(R.id.Confirm);
        buttonCreate = (Button) findViewById(R.id.buttonCreate);

        db = new dbStudentHandler(this);




        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = newEmail.getText().toString();
                String password = newPassword.getText().toString();
                String confirmPass = Confirm.getText().toString();
                String ruid = RUID.getText().toString();
                String first = editFN.getText().toString();
                String last = editLN.getText().toString();
                String campus = Campus.getText().toString();
                String faculty = Student.getText().toString();

                int temp;
                if(faculty == "Student") {
                    temp = 1;
                }
                else {
                    temp = -1;
                }
                int id = Integer.parseInt(ruid);
                int Campus = Integer.parseInt(campus);
                if(email.equals("")||password.equals("")||confirmPass.equals("")){
                    Toast.makeText(getApplicationContext(), "Some Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.equals(confirmPass)){
                        Boolean chkemail = db.checkemail(email);
                        if(chkemail == true){
                            Boolean insert = db.insertDataStudent(id, email, first, last, Campus, null, password, 1, temp);
                            if(insert == true){
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Email already exist", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }

            }
        });
    }
}
