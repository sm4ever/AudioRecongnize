package utils;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class MicrophoneUtil {

    static final long RECORD_DURATION = 10000;
    public static void record() {

        AudioFormat format = new AudioFormat(44100, 16, 1, true, false);

        try {
            // get a target data line for recording audio
            TargetDataLine line = AudioSystem.getTargetDataLine(format);

            // open the line for recording
            line.open(format);

            // start recording
            line.start();

            // create a byte array to hold the recorded audio data
            byte[] data = new byte[line.getBufferSize()*10];
            int bytesRead = 0;
            long endTime = System.currentTimeMillis() + RECORD_DURATION;

            // read audio data from the target data line until the recording duration is reached
            while (System.currentTimeMillis() < endTime) {
                int numBytesRead = line.read(data, bytesRead, data.length - bytesRead);
                if (numBytesRead == -1) {
                    break;
                }
                bytesRead += numBytesRead;
            }

            // stop recording
            line.stop();
            line.close();

            // save the recorded audio data to a WAV file
            AudioInputStream ais = new AudioInputStream(new ByteArrayInputStream(data), format, bytesRead / format.getFrameSize());
            AudioSystem.write(ais, AudioFileFormat.Type.WAVE, new File("recordedAudio.wav"));

        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }

    }
}
