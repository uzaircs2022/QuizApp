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
import com.example.quiz.activities.LoginActivity;
import com.example.quiz.activities.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firebaseAuth = FirebaseAuth.getInstance();

        //redirecting to Login Page
        TextView Re_LOGIN;
        Re_LOGIN = findViewById(R.id.btnLogin);
        Re_LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //Getting the button
        Button btnUpsign;
        btnUpsign = findViewById(R.id.btnSignUp);

        //Click Listener For Signup
        btnUpsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUpUser();
            }
        });
    }


    private void SignUpUser()
    {
        String email,Password,CPassword;
        EditText temp1,temp2,temp3;

        temp1 = findViewById(R.id.etEmailAddress);
        temp2 = findViewById(R.id.etPassword);
        temp3 = findViewById(R.id.etConfirmPassword);
        email = temp1.getText().toString();
        Password = temp2.getText().toString();
        CPassword = temp3.getText().toString();

        if(email.isEmpty() || Password.isEmpty() || CPassword.isEmpty())
        {
            Toast.makeText(this,"Email and Password cant be Empty",Toast.LENGTH_SHORT).show();
            return ;
        }

        if(!Password.equals(CPassword))
        {
            Toast.makeText(this,"Password and Confirm Password must be equal",Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(email, Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext() ,"Error Creating Error" , Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}