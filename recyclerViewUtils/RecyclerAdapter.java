package com.ipshita.rolodex.recyclerViewUtils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ipshita.rolodex.R;
import com.ipshita.rolodex.models.Contact;

import java.util.List;

/**
 * Created by Ipshita on 18-12-2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private List<Contact> contactList;

    private Contact currentContact;

    private Context context;

    public RecyclerAdapter(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.card_layout,
                parent,false);

        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
