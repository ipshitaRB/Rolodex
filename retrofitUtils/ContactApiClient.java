package com.ipshita.rolodex.retrofitUtils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ipshita on 18-12-2017.
 */

public class ContactApiClient {

    public static final String BASE_URL = "https://s3-us-west-2.amazonaws.com";


    public static Retrofit retrofit;

    public static Retrofit getContactApiClient(){
        if( retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
