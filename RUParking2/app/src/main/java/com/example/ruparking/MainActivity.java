package com.example.ruparking;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private FirebaseAuth mAuth;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonRegister;
    private Button buttonLogin;
    private TextView Info;
    private int counter = 5;

    private FirebaseAuth.AuthStateListener  mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        Info = (TextView) findViewById(R.id.txtAttempts);
        Info.setText("Number of Attempts Remaining: 5");

        //Get Instance of Firebase Authentication
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };

        //Login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if(!email.equals("") && !password.equals("")){      //checks to see if email and password field is empty
                    //Firebase method for signing in with authentication
                    mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //If email and password is not in the system, will not allow user to login
                            if(!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                                counter--;
                                Info.setText("Number of remaining attempts: " + String.valueOf(counter));
                                if (counter == 0) {
                                    buttonLogin.setEnabled(false);
                                    //startActivity(new Intent(MainActivity.this, MainActivity.class));
                                }
                            }
                            //If account is in system, go to the select campus screen
                            if(task.isSuccessful()){
                                startActivity(new Intent(MainActivity.this, SelectCampus.class));
                            }
                        }
                    });


                }else{
                    Toast.makeText(MainActivity.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Button to go to the registration page
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        mAuth.addAuthStateListener(mAuthListener);
        updateUI(currentUser);
    }

    @Override
    public void onStop() {
        super.onStop();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        mAuth.removeAuthStateListener(mAuthListener);
    }
    private void updateUI(FirebaseUser user){
        if(user != null){
            startActivity(new Intent(MainActivity.this, SelectCampus.class));
        }
    };
}




