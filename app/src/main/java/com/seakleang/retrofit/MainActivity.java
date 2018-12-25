package com.seakleang.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.seakleang.retrofit.data.service.ArticleService;
import com.seakleang.retrofit.data.service.ServiceGenerator;
import com.seakleang.retrofit.model.response.ArticleResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArticleService service;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service  = ServiceGenerator.createServices(ArticleService.class);

        Call<ArticleResponse> call = service.getArticle(1,20);

        call.enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                Log.e(TAG,"DataEntity: "+response.body().toString());
            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {
                Log.e(TAG,"onFailure "+t.toString());
            }
        });
    }
}
