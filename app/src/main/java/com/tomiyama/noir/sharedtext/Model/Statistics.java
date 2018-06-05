package com.tomiyama.noir.sharedtext.Model;

import com.google.gson.annotations.SerializedName;

public class Statistics {

    @SerializedName("viewCount")
    String viewCount;

    @SerializedName("likeCount")
    String likeCount;

    @SerializedName("dislikeCount")
    String dislikeCount;

    @SerializedName("favoriteCount")
    String favoriteCount;

    @SerializedName("commentCount")
    String commentCount;


    public String getViewCount() {
        return viewCount;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public String getDislikeCount() {
        return dislikeCount;
    }

    public String getFavoriteCount() {
        return favoriteCount;
    }

    public String getCommentCount() {
        return commentCount;
    }
}
