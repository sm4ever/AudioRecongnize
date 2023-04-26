package utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static String FILE = "recordedAudio.wav";

    public static Map<String, Object> getConfig(){
        Map<String, Object> config = new HashMap<String, Object>();
        config.put("host", "identify-eu-west-1.acrcloud.com");
        config.put("access_key", "dc720e00f273724c99a2ecc563358623");
        config.put("access_secret", "aTbZWDxYCFpqWhtO7Q1TuozBTnPzTkCaWE1kENZ1");
        config.put("debug", false);
        config.put("timeout", 10);
        return config;
    }
}
