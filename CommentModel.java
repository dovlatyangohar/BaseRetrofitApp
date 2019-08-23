package com.example.baseretrofitapp.model;

import com.google.gson.annotations.SerializedName;

public class CommentModel {

    @SerializedName("postId")
    private Integer postId;

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    @SerializedName("email")
    private String email;

    @SerializedName("body")
    private String body;

    public Integer getPostId() {
        return postId;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
