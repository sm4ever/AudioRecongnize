import com.acrcloud.utils.ACRCloudRecognizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Recognize {
    public static void main(String[] args) {
        Map<String, Object> config = new HashMap<String, Object>();
        config.put("host", "identify-eu-west-1.acrcloud.com");
        config.put("access_key", "dc720e00f273724c99a2ecc563358623");
        config.put("access_secret", "aTbZWDxYCFpqWhtO7Q1TuozBTnPzTkCaWE1kENZ1");

        config.put("debug", false);
        config.put("timeout", 10);

        ACRCloudRecognizer re = new ACRCloudRecognizer(config);
        File wavFile = new File("/Users/Mohamed/RecordAudio.wav");
        // It will skip 80 seconds.
        String result = re.recognizeByFile(wavFile.getPath(),0);
        System.out.println(result);

        /**
         *
         *  recognize by buffer of (Formatter: Audio/Video)
         *     Audio: mp3, wav, m4a, flac, aac, amr, ape, ogg ...
         *     Video: mp4, mkv, wmv, flv, ts, avi ...
         *
         *
         **/
/*
        File file = new File("/Users/Mohamed/RecordAudio.wav");
        byte[] buffer = new byte[3*1024 * 1024];
        if (!file.exists()) {
            return;
        }
        FileInputStream fin = null;
        int bufferLen = 0;
        try {
            fin = new FileInputStream(file);
            bufferLen = fin.read(buffer, 0, buffer.length);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("bufferLen=" + bufferLen);

        if (bufferLen <= 0)
            return;
        result = re.recognizeByFileBuffer(buffer, buffer.length, 0);
        // It will skip 80 seconds from the begginning of (buffer).
       // byte[] audioBytes = MicrophoneListener.recording();
        //String result = re.recognizeByFileBuffer(buffer, buffer.length, 100);
        //String result = re.recognizeByFileBuffer(audioBytes, audioBytes.length, 0);
        System.out.println(result);

 */
    }

}
