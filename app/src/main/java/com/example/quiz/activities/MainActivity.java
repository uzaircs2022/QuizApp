package com.example.quiz.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.quiz.R;
import com.example.quiz.adapters.QuizAdapter;
import com.example.quiz.models.Questions;
import com.example.quiz.models.Quiz;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle actionBarDrawerToggle;
    QuizAdapter adapter;
    private List<Quiz> quizlist = Lists.newArrayList();
    FirebaseFirestore firestore;

    public Map<String,Questions> question123 = Maps.newHashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
        dummyData();
    }

    private void dummyData() {

        quizlist.add(new Quiz("12-12-2021","12-12-2021"));
        quizlist.add(new Quiz("13-12-2021","13-12-2021"));
        quizlist.add(new Quiz("14-12-2021","14-12-2021"));
        quizlist.add(new Quiz("15-12-2021","15-12-2021"));
        quizlist.add(new Quiz("16-12-2021","16-12-2021"));
        quizlist.add(new Quiz("17-12-2021","17-12-2021"));
        quizlist.add(new Quiz("18-12-2021","18-12-2021"));
        quizlist.add(new Quiz("19-12-2021","19-12-2021"));




    }

    void setUpViews()
    {
        setUpFireStore();
        setUpDrawerLayout();
        setUpRecyclerView();

    }

    private void setUpFireStore() {
        firestore = FirebaseFirestore.getInstance();
        CollectionReference collectionReference = firestore.collection("quizzes");
        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(value == null || error != null) {
                    Toast.makeText(getApplicationContext(), "Error in fetching data", Toast.LENGTH_SHORT).show();
                }

                List<DocumentSnapshot> quizes = value.getDocuments();
                Set<String> keys = quizes.get(0).getData().keySet();
                    for (String key : keys) {
                        Log.i("Uzair", "Key: " + key);
                        if (key.equals("questions"))
                        {
                            HashMap<String, Object> questions = (HashMap<String, Object>) quizes.get(0).getData().get(key);
                            Set<String> questionsKeys = questions.keySet();
                            for (String qkey : questionsKeys) {
                                Log.i("Uzair", "Key: " + qkey);
                                Log.i("Uzair", "Data: " + questions.get(qkey));
                                question123 = (Map<String, Questions>) questions.get(qkey);
                                HashMap<String, String> question = (HashMap<String, String>) questions.get(qkey);
                                Set<String> questionparts = question.keySet();
                                for (String part : questionparts)
                                {
                                    Log.i("Uzair", "Key: " + part + "value: " + question.get(part));
                                }
                            }
                        }
                    }

                   // Quiz quiz = new Quiz();
                    //quiz.getQuestions(question123);

                    Log.d("DATA", value.toObjects(Quiz.class).toString());
                    quizlist.clear();
                    quizlist.addAll(value.toObjects(Quiz.class));
                    adapter.notifyDataSetChanged();
            }
        });

    }


    private void setUpRecyclerView() {
        adapter = new QuizAdapter(this, quizlist);
        RecyclerView view;
        view = findViewById(R.id.quizRecyclerView);
        view.setLayoutManager(new GridLayoutManager(this,2));
        view.setAdapter(adapter);
    }

    void setUpDrawerLayout()
    {
        setSupportActionBar(findViewById(R.id.appBar));
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,findViewById(R.id.mainDrawer),R.string.app_name,R.string.app_name);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}