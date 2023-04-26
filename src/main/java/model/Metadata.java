package model;


import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("music")
    private List<Music> mMusic;
    @SerializedName("timestamp_utc")
    private String mTimestampUtc;

    public List<Music> getMusic() {
        return mMusic;
    }

    public void setMusic(List<Music> music) {
        mMusic = music;
    }

    public String getTimestampUtc() {
        return mTimestampUtc;
    }

    public void setTimestampUtc(String timestampUtc) {
        mTimestampUtc = timestampUtc;
    }

}
