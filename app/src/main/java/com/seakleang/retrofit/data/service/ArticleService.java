package com.seakleang.retrofit.data.service;

import com.seakleang.retrofit.model.form.Article;
import com.seakleang.retrofit.model.response.ArticleResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ArticleService {

    @POST("/v1/api/articles")
    Call<com.seakleang.retrofit.model.response.Article>
    addArticle(
            @Body Article article
    );

    @GET("/v1/api/articles")
    Call<ArticleResponse>
    getArticle(
            @Query("page") int page,
            @Query("limit") int limit
    );

}
