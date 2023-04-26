package model;

import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("cost_time")
    private Double mCostTime;
    @SerializedName("metadata")
    private Metadata mMetadata;
    @SerializedName("result_type")
    private Long mResultType;
    @SerializedName("status")
    private Status mStatus;

    public Double getCostTime() {
        return mCostTime;
    }

    public void setCostTime(Double costTime) {
        mCostTime = costTime;
    }

    public Metadata getMetadata() {
        return mMetadata;
    }

    public void setMetadata(Metadata metadata) {
        mMetadata = metadata;
    }

    public Long getResultType() {
        return mResultType;
    }

    public void setResultType(Long resultType) {
        mResultType = resultType;
    }

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus = status;
    }

}
