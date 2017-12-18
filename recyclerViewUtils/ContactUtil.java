package com.ipshita.rolodex.recyclerViewUtils;

/**
 * Created by Ipshita on 18-12-2017.
 */

class ContactUtil {


    public static final String SPACE = " ";

    public static String getFullName(String firstName, String lastName) {

        StringBuilder fullNameBuilder = new StringBuilder();
        fullNameBuilder.append(firstName).append(SPACE).append(lastName);
        return fullNameBuilder.toString();
    }

    // This method has been taken from https://gist.github.com/kristopherjohnson/bb27d58350ab85fa89a1
    public static String truncateString(String s, int maxLength) {
        final int length = s.length();
        if (length <= maxLength)
            return s;
        else if (maxLength > 3)
            return s.substring(0, maxLength - 3) + "...";
        else
            return s.substring(0, maxLength);
    }
}
