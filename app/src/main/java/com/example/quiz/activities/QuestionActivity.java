package com.example.quiz.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.quiz.R;
import com.example.quiz.adapters.OptionAdapter;
import com.example.quiz.models.Questions;

public class QuestionActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        bindViews();
    }

    //@RequiresApi(api = Build.VERSION_CODES.R)
    private void bindViews()
    {
        Questions question = new Questions("Which is the only bird that fly backward","Sunbird","KingFisher","Honey Eater","Humingbird","Humminbird","");
        TextView descrip = findViewById(R.id.description);
        descrip.setText(question.getDescription());
        OptionAdapter optionAdapter = new OptionAdapter(this,question);
        RecyclerView recyclerView = findViewById(R.id.optionlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(optionAdapter);
        recyclerView.setHasFixedSize(true);
        

    }
}