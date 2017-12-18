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
        currentContact = contactList.get(position);
        holder.nameTextView.setText(currentContact.getFirstName() + " " + currentContact.getLastName());
        holder.startDateTextView.setText(currentContact.getStartDate());
        holder.emailTextView.setText(currentContact.getEmail());
        holder.companyTextView.setText(currentContact.getCompany());
        holder.descriptionTextView.setText(currentContact.getBio());

        // TODO: 18-12-2017 trim email 
        // TODO: 18-12-2017 load avatar thumbnail using picasso
        // TODO: 18-12-2017 format bio - show bold and italics 
        // TODO: 18-12-2017 format start date 
        // TODO: 18-12-2017 in firstname and lastname 
    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
