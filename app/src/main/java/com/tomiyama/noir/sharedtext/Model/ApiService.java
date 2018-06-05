package com.tomiyama.noir.sharedtext.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {

    @Headers("Accept-Language: ja")
    @GET("/youtube/v3/videos?")
    Call<APIResponse> requestMovie(@Query("id") String id,
                                    @Query("key") String key,
                                    @Query("fields") String fields,
                                    @Query("part") String part);

}

