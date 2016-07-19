package com.example.putuguna.retrofit2post;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by putuguna on 14/06/16.
 */
public class ListFaqModel {

    @SerializedName("pertanyaan")
    private List<FaqModel> pertanyaan;

    public ListFaqModel(List<FaqModel> pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public ListFaqModel() {
    }

    public List<FaqModel> getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(List<FaqModel> pertanyaan) {
        this.pertanyaan = pertanyaan;
    }
}
