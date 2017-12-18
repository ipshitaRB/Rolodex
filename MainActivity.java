package com.ipshita.rolodex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ipshita.rolodex.models.Contact;
import com.ipshita.rolodex.retrofitUtils.ContactApiClient;
import com.ipshita.rolodex.retrofitUtils.ContactApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView nameTextView;

    private ContactApiInterface contactApiInterface;

    private List<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 18-12-2017 retrofit
        // TODO: 18-12-2017 cardview horizontal

        // to check whether response is received
        nameTextView = (TextView) findViewById(R.id.name_textView);

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
                //Log.i(MainActivity.class.getSimpleName(), response.body().get(0).getFirstName());
                nameTextView.setText(contactList.get(0).getFirstName());
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {

            }
        });
    }
}
