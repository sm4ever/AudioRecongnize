package model;

import java.util.List;
import com.google.gson.annotations.SerializedName;



public class Music {

    @SerializedName("acrid")
    private String mAcrid;
    @SerializedName("album")
    private Album mAlbum;
    @SerializedName("artists")
    private List<Artist> mArtists;
    @SerializedName("db_begin_time_offset_ms")
    private Long mDbBeginTimeOffsetMs;
    @SerializedName("db_end_time_offset_ms")
    private Long mDbEndTimeOffsetMs;
    @SerializedName("duration_ms")
    private Long mDurationMs;
    @SerializedName("exids")
    private String mExids;
    @SerializedName("external_ids")
    private ExternalIds mExternalIds;
    @SerializedName("external_metadata")
    private ExternalMetadata mExternalMetadata;
    @SerializedName("genres")
    private List<Genre> mGenres;
    @SerializedName("label")
    private String mLabel;
    @SerializedName("play_offset_ms")
    private Long mPlayOffsetMs;
    @SerializedName("release_date")
    private String mReleaseDate;
    @SerializedName("result_from")
    private Long mResultFrom;
    @SerializedName("sample_begin_time_offset_ms")
    private Long mSampleBeginTimeOffsetMs;
    @SerializedName("sample_end_time_offset_ms")
    private Long mSampleEndTimeOffsetMs;
    @SerializedName("score")
    private Long mScore;
    @SerializedName("title")
    private String mTitle;

    public String getAcrid() {
        return mAcrid;
    }

    public void setAcrid(String acrid) {
        mAcrid = acrid;
    }

    public Album getAlbum() {
        return mAlbum;
    }

    public void setAlbum(Album album) {
        mAlbum = album;
    }

    public List<Artist> getArtists() {
        return mArtists;
    }

    public void setArtists(List<Artist> artists) {
        mArtists = artists;
    }

    public Long getDbBeginTimeOffsetMs() {
        return mDbBeginTimeOffsetMs;
    }

    public void setDbBeginTimeOffsetMs(Long dbBeginTimeOffsetMs) {
        mDbBeginTimeOffsetMs = dbBeginTimeOffsetMs;
    }

    public Long getDbEndTimeOffsetMs() {
        return mDbEndTimeOffsetMs;
    }

    public void setDbEndTimeOffsetMs(Long dbEndTimeOffsetMs) {
        mDbEndTimeOffsetMs = dbEndTimeOffsetMs;
    }

    public Long getDurationMs() {
        return mDurationMs;
    }

    public void setDurationMs(Long durationMs) {
        mDurationMs = durationMs;
    }

    public String getExids() {
        return mExids;
    }

    public void setExids(String exids) {
        mExids = exids;
    }

    public ExternalIds getExternalIds() {
        return mExternalIds;
    }

    public void setExternalIds(ExternalIds externalIds) {
        mExternalIds = externalIds;
    }

    public ExternalMetadata getExternalMetadata() {
        return mExternalMetadata;
    }

    public void setExternalMetadata(ExternalMetadata externalMetadata) {
        mExternalMetadata = externalMetadata;
    }

    public List<Genre> getGenres() {
        return mGenres;
    }

    public void setGenres(List<Genre> genres) {
        mGenres = genres;
    }

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String label) {
        mLabel = label;
    }

    public Long getPlayOffsetMs() {
        return mPlayOffsetMs;
    }

    public void setPlayOffsetMs(Long playOffsetMs) {
        mPlayOffsetMs = playOffsetMs;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public Long getResultFrom() {
        return mResultFrom;
    }

    public void setResultFrom(Long resultFrom) {
        mResultFrom = resultFrom;
    }

    public Long getSampleBeginTimeOffsetMs() {
        return mSampleBeginTimeOffsetMs;
    }

    public void setSampleBeginTimeOffsetMs(Long sampleBeginTimeOffsetMs) {
        mSampleBeginTimeOffsetMs = sampleBeginTimeOffsetMs;
    }

    public Long getSampleEndTimeOffsetMs() {
        return mSampleEndTimeOffsetMs;
    }

    public void setSampleEndTimeOffsetMs(Long sampleEndTimeOffsetMs) {
        mSampleEndTimeOffsetMs = sampleEndTimeOffsetMs;
    }

    public Long getScore() {
        return mScore;
    }

    public void setScore(Long score) {
        mScore = score;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
