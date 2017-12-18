package com.ipshita.rolodex.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ipshita on 18-12-2017.
 */

public class Contact implements Parcelable{

    @SerializedName("firstName")
    private String firstName;

    @SerializedName("lastName")
    private String lastName;

    @SerializedName("email")
    private String email;

    @SerializedName("company")
    private String company;

    @SerializedName("startDate")
    private String startDate;

    @SerializedName("bio")
    private String bio;

    @SerializedName("avatar")
    private String avatarLink;

    protected Contact(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        email = in.readString();
        company = in.readString();
        startDate = in.readString();
        bio = in.readString();
        avatarLink = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getBio() {
        return bio;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(email);
        parcel.writeString(company);
        parcel.writeString(startDate);
        parcel.writeString(bio);
        parcel.writeString(avatarLink);
    }
}

