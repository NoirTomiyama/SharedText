package com.tomiyama.noir.sharedtext.Model;

import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("id")
    private String id;

    @SerializedName("snippet")
    private Snippet snippet;

    @SerializedName("statistics")
    private Statistics statistics;


    public String getId() {
        return id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public Statistics getStatistics() {
        return statistics;
    }

}
