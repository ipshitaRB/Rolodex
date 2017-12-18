package com.ipshita.rolodex.recyclerViewUtils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ipshita.rolodex.R;

/**
 * Created by Ipshita on 18-12-2017.
 */

public class ContactViewHolder extends RecyclerView.ViewHolder {

    TextView nameTextView;
    TextView companyTextView;
    TextView emailTextView;
    TextView descriptionTextView;
    TextView startDateTextView;
    ImageView avatarImageView;

    public ContactViewHolder(View itemView) {
        super(itemView);

        nameTextView = (TextView)itemView.findViewById(R.id.name_textView);
        companyTextView = (TextView)itemView.findViewById(R.id.company_textView);
        emailTextView = (TextView)itemView.findViewById(R.id.email_textView);
        descriptionTextView = (TextView)itemView.findViewById(R.id.description_textView);
        startDateTextView = (TextView)itemView.findViewById(R.id.start_date_textView);
        avatarImageView = (ImageView)itemView.findViewById(R.id.avatar_imageView);

    }
}
