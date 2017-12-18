package com.ipshita.rolodex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;

import com.ipshita.rolodex.models.Contact;
import com.ipshita.rolodex.recyclerViewUtils.RecyclerAdapter;
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

    private RecyclerView.LayoutManager layoutManager;

    private RecyclerAdapter adapter;

    private RecyclerView contactRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Done: 18-12-2017 retrofit
        // done: 18-12-2017 make cardview move horizontally


        contactRecyclerView = (RecyclerView) findViewById(R.id.contact_recycler_view);

        contactApiInterface = ContactApiClient.getContactApiClient().
                create(ContactApiInterface.class);

        contactList = new ArrayList<>();

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,
                false);
        contactRecyclerView.setLayoutManager(layoutManager);

        // done: 18-12-2017 change background color
        // TODO: 18-12-2017 check network connection before fetching response - 3
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

                // Done: 18-12-2017 update recyclerview
                adapter = new RecyclerAdapter(contactList);
                contactRecyclerView.setAdapter(adapter);
                SnapHelper snapHelper = new LinearSnapHelper();
                snapHelper.attachToRecyclerView(contactRecyclerView);

                // TODO: 18-12-2017 save contactlist during orientation change - 4

            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {

            }
        });
    }
}
