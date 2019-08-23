package com.example.baseretrofitapp.model;

import com.google.gson.annotations.SerializedName;

public class PostModel {

    @SerializedName("userId")
    private Integer userId;

    @SerializedName("id")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
