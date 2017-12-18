package com.ipshita.rolodex.recyclerViewUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

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

    // to replace asterisks and underscores with bold and italic tags
    public static String getFormattedText(String unformattedText) {
        String formattedText = unformattedText;
        boolean boldOpen = false;
        boolean italicsOpen = false;

        for (int i = 0; i < formattedText.length(); i++) {
            //Check for bold
            if (formattedText.charAt(i) == '*'){
                if(!boldOpen){
                    boldOpen = true;
                    formattedText = replaceCharWithTag(formattedText, i, "<b>");
                    i = i + 2;
                } else {
                    boldOpen = false;
                    formattedText = replaceCharWithTag(formattedText, i, "</b>");
                    i = i + 3;
                }
            } //Check for italics
            else if (formattedText.charAt(i) == '_') {
                if (!italicsOpen) {
                    italicsOpen = true;
                    formattedText = replaceCharWithTag(formattedText, i, "<i>");
                    i = i + 2;
                } else {
                    italicsOpen = false;
                    formattedText = replaceCharWithTag(formattedText, i, "</i>");
                    i = i + 3;
                }
            }
        }

        return formattedText;
    }

    private static String replaceCharWithTag(String inputStr, int index, String htmlTag) {
        StringBuilder outputStringBuilder = new StringBuilder(inputStr);
        outputStringBuilder.deleteCharAt(index);
        outputStringBuilder.insert(index, htmlTag);

        return outputStringBuilder.toString();
    }

    // This method has been taken from https://gist.github.com/nickrussler/7527851
    public static String getISO8601UTCDate(String dateStr) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(tz);

        try {
            return df.parse(dateStr).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return null;
    }
}
