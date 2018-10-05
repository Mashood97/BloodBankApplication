package com.example.masho.bloodbankapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mUserName;
    private EditText mPassword;
    private Button mSignupBtn;
    private FirebaseAuth mAuths;
    private TextView signin;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        mEmail = (EditText) findViewById(R.id.email);
        mAuths = FirebaseAuth.getInstance();
        mUserName = (EditText) findViewById(R.id.UserName);
        databaseReference = FirebaseDatabase.getInstance().getReference("Users").push().child("Sign-up");
        mPassword = (EditText) findViewById(R.id.password);
        mSignupBtn = (Button) findViewById(R.id.email_sign_up_button);
        signin = (TextView) findViewById(R.id.Signintxt);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });

        mSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = mEmail.getText().toString();
                final String userName = mUserName.getText().toString();
                final String Pass = mPassword.getText().toString();
                if (TextUtils.isEmpty(email) && TextUtils.isEmpty(userName) && TextUtils.isEmpty(Pass)) {
                    Toast.makeText(getApplicationContext(), "Insert data in all the fields", Toast.LENGTH_LONG).show();
                } else {
                    mAuths.createUserWithEmailAndPassword(email, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Registered Succesfully", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(SignupActivity.this, MainPage.class));
                                FirebaseUser user = mAuths.getCurrentUser();
                                if (user != null) {
                                    String uId = user.getUid();
                                    databaseReference.child("UId").setValue(uId);
                                    databaseReference.child("UserName").setValue(userName);
                                    databaseReference.child("Email").setValue(email);
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Not Registered Succesfully", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
