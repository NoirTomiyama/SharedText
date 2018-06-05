package com.tomiyama.noir.sharedtext.Model;

import com.google.gson.annotations.SerializedName;

public class Snippet {

    @SerializedName("title")
    private String title;

    @SerializedName("thumbnails")
    private Thumbnails thumbnails;

    public class Thumbnails {

        @SerializedName("default")
        public Default aDefault;

        @SerializedName("medium")
        public Medium medium;

        @SerializedName("high")
        public High high;

        public High getHigh() {
            return high;
        }

        @SerializedName("standard")
        public Standard standard;

        @SerializedName("maxres")
        public Maxres maxres;


        public class Default {
            String url;
            String width;
            String height;
        }

        public class Medium {
            String url;
            String width;
            String height;

        }

        public class High {
            String url;
            String width;
            String height;

            public String getUrl() {
                return url;
            }
        }

        public class Standard {
            String url;
            String width;
            String height;
        }

        public class Maxres {
            String url;
            String width;
            String height;
        }

    }

    @SerializedName("channelTitle")
    String channelTitle;

    public String getTitle() {
        return title;
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public String getChannelTitle() {
        return channelTitle;
    }
}
