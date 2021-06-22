package com.example.quiz.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.quiz.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginIntro extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_intro);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null)
        {
            Toast.makeText(this, "User is already logged in", Toast.LENGTH_SHORT).show();
            try
            {
                Redirect("MAIN");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        //Button to get started
        Button Get_Started;
        Get_Started = findViewById(R.id.btnGetStarted);
        Get_Started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try
                {
                    Redirect("LOGIN");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

    }

    private void Redirect(String Name) throws Exception
    {
        if(Name.equals("LOGIN"))
        {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        else if (Name.equals("MAIN"))
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            throw new Exception("No path Exist");
        }


    }


}