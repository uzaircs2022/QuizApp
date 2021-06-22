package com.example.quiz.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();

        //redirecting to signup Page
        TextView Re_SIGNUP;
        Re_SIGNUP = findViewById(R.id.btnsignUp);
        Re_SIGNUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });


        //Getting the button
        Button btnLog;
        btnLog = findViewById(R.id.btnLogin);
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }

    private void Login()
    {
        String email,Password;
        EditText temp1,temp2;

        temp1 = findViewById(R.id.etEmailAddress);
        temp2 = findViewById(R.id.etPassword);
        email = temp1.getText().toString();
        Password = temp2.getText().toString();
        if(email.isEmpty() || Password.isEmpty())
        {
            Toast.makeText(this,"Email and Password cant be Empty",Toast.LENGTH_SHORT).show();
            return ;
        }

        firebaseAuth.signInWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

}