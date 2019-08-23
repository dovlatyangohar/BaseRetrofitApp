package com.example.baseretrofitapp.remote;

import com.example.baseretrofitapp.model.CommentModel;
import com.example.baseretrofitapp.model.PostModel;


import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface UserService {

    @GET("posts")
    Call<List<PostModel>> getPosts(@Query("userId") int userId);

    @GET("posts")
    Call<List<PostModel>> getDataMap(@QueryMap Map<String, String> params);

    @GET("posts/{id}/comments")
    Call<List<CommentModel>> getComments(@Path("id") Integer postId);




}
