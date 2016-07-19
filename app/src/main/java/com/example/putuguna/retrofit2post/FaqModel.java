package com.example.putuguna.retrofit2post;

import com.google.gson.annotations.SerializedName;

/**
 * Created by putuguna on 14/06/16.
 */
public class FaqModel {

    @SerializedName("q")
    private String question;
    @SerializedName("a")
    private String answer;

    public FaqModel() {
    }

    public FaqModel(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
