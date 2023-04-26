package model;

import com.google.gson.annotations.SerializedName;

public class Album {

    @SerializedName("name")
    private String mName;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
