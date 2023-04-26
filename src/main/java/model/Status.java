package model;

import com.google.gson.annotations.SerializedName;


public class Status {

    @SerializedName("code")
    private Long mCode;
    @SerializedName("msg")
    private String mMsg;
    @SerializedName("version")
    private String mVersion;

    public Long getCode() {
        return mCode;
    }

    public void setCode(Long code) {
        mCode = code;
    }

    public String getMsg() {
        return mMsg;
    }

    public void setMsg(String msg) {
        mMsg = msg;
    }

    public String getVersion() {
        return mVersion;
    }

    public void setVersion(String version) {
        mVersion = version;
    }

}
