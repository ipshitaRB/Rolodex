package com.ipshita.rolodex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ipshita.rolodex.models.Contact;
import com.ipshita.rolodex.retrofitUtils.ContactApiClient;
import com.ipshita.rolodex.retrofitUtils.ContactApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    private ContactApiInterface contactApiInterface;

    private List<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Done: 18-12-2017 retrofit
        // TODO: 18-12-2017 cardview horizontal



        contactApiInterface = ContactApiClient.getContactApiClient().
                create(ContactApiInterface.class);

        contactList = new ArrayList<>();

        loadContacts();
    }


    /**
     * Fetches response using retrofit client
     *
     */
    private void loadContacts() {

        Call<List<Contact>> call = contactApiInterface.getContacts();
        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {

                contactList = (ArrayList<Contact>) response.body();

                // TODO: 18-12-2017 update recyclerview
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {

            }
        });
    }
}
