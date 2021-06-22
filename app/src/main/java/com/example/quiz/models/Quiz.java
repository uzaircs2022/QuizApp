package com.example.quiz.models;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;



public class Quiz {
    String title = "";
    String id = "";
    public Map<String,Questions> questions = Maps.newHashMap();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Questions> getQuestions(Map<String, Questions> question123) {
        return questions;
    }

    public void setQuestions(Map<String, Questions> questions) {
        this.questions = questions;
    }

    public Quiz(String title, String id, Map<String, Questions> questions) {
        this.title = title;
        this.id = id;
        this.questions = questions;
    }

    public Quiz(){}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public Quiz(String id , String title)
    {
        this.title = title;
        this.id = id;
    }



    @Override
    public String toString() {
        return "Quiz{" +
                "title='" + title + '\'' +
                ", id='" + id + '\'' +
                ", questions=" + questions +
                '}';
    }
}
