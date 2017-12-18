package com.ipshita.rolodex.retrofitUtils;

import com.ipshita.rolodex.models.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ipshita on 18-12-2017.
 */

public interface ContactApiInterface {


    @GET("udacity-mobile-interview/CardData.json")
    Call<List<Contact>> getContacts();
}
