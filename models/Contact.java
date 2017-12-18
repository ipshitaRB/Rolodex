package com.ipshita.rolodex.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ipshita on 18-12-2017.
 */

public class Contact {

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
}

