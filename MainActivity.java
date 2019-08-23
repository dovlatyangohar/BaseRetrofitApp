package com.example.baseretrofitapp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.baseretrofitapp.model.CommentModel;
import com.example.baseretrofitapp.model.PostModel;
import com.example.baseretrofitapp.remote.ApiUtils;
import com.example.baseretrofitapp.remote.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.tv_result);
        userService = ApiUtils.getUserService();


        //getPosts();
        // getPostsByMap();
        //getComments();


    }


    private void getPosts() {

        Call<List<PostModel>> call = userService.getPosts(1);
        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<PostModel> posts = response.body();

                for (PostModel post : posts) {
                    String content = "";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "ID: " + post.getId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Body: " + post.getBody() + "\n\n";

                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void getPostsByMap() {
        Map<String, String> items = new HashMap<>();
        items.put("title", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");

        Call<List<PostModel>> call = userService.getDataMap(items);

        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<PostModel> posts = response.body();

                for (PostModel post : posts) {
                    String content = "";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "ID: " + post.getId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Body: " + post.getBody() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getComments() {
        Call<List<CommentModel>> call = userService.getComments(1);
        call.enqueue(new Callback<List<CommentModel>>() {
            @Override
            public void onResponse(Call<List<CommentModel>> call, Response<List<CommentModel>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<CommentModel> comments = response.body();

                for (CommentModel comment : comments) {
                    String content = "";
                    content += "PostId: " + comment.getPostId() + "\n";
                    content += "ID: " + comment.getId() + "\n";
                    content += "Name: " + comment.getName() + "\n";
                    content += "Email: " + comment.getEmail() + "\n";
                    content += "Body: " + comment.getBody() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<CommentModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
