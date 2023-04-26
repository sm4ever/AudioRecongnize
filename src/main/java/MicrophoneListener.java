import com.acrcloud.utils.ACRCloudRecognizer;

import javax.sound.sampled.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MicrophoneListener {
    static TargetDataLine line;
    static final long RECORD_TIME = 15000;  // 1 minute
    // path of the wav file
    static File wavFile = new File("/Users/Mohamed/RecordAudio.wav");

    // format of audio file
    static AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;

    public static void main(String args[]) {
        //byte[] audioBytes = start();
        Thread stopper = new Thread(() -> {
            try {
                Thread.sleep(RECORD_TIME);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            finish();
        });

        stopper.start();
        start();
        Recognize.main(new String[0]);
        //play(start());
        //ACRCloudRecognizer re = new ACRCloudRecognizer(getConfig());
        //String result = re.recognizeByFileBuffer(audioBytes, audioBytes.length, 0);
        //System.out.println(result);
    }

    private static Map<String, Object> getConfig() {
        Map<String, Object> config = new HashMap<String, Object>();
        config.put("host", "identify-eu-west-1.acrcloud.com");
        config.put("access_key", "dc720e00f273724c99a2ecc563358623");
        config.put("access_secret", "aTbZWDxYCFpqWhtO7Q1TuozBTnPzTkCaWE1kENZ1");

        config.put("debug", false);
        config.put("timeout", 10); // seconds
        return config;
    }

    public static byte[] record() {
        AudioFormat audioFormat = new AudioFormat(44100, 16, 1, true, false);
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);

        if (!AudioSystem.isLineSupported(info)) {
            System.out.println("Line not supported");
            System.exit(0);
        }

        try {
            TargetDataLine targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
            targetDataLine.open(audioFormat);
            targetDataLine.start();

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[512 * 1024];

            System.out.println("Listening to the microphone...");
            for (int i = 0; i < 2; i++) { // Record audio for a short duration, adjust this loop for longer recording
                int bytesRead = targetDataLine.read(buffer, 0, buffer.length);
                outputStream.write(buffer, 0, bytesRead);
            }

            targetDataLine.stop();
            targetDataLine.close();

            byte[] audioBytes = outputStream.toByteArray();
            System.out.println("Audio bytes captured: " + audioBytes.length);
            outputStream.close();
            return audioBytes;

        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
            return new byte[0];
        }

    }

    private static void play(byte[] audioBytes) {

        AudioFormat audioFormat = new AudioFormat(44100, 16, 1, true, true);
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(audioBytes);
            AudioInputStream audioInputStream = new AudioInputStream(byteArrayInputStream, audioFormat, audioBytes.length);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

            System.out.println("Playing audio...");
            Thread.sleep(clip.getMicrosecondLength() / 1000);

            clip.stop();
            clip.close();
            byteArrayInputStream.close();
            audioInputStream.close();
        } catch (LineUnavailableException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    static byte[] recording() {


        AudioFormat audioFormat = new AudioFormat(44100, 16, 1, true, false);
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
        int bufferSize = (int) audioFormat.getSampleRate() * audioFormat.getFrameSize() * 8;
        byte[] buffer = new byte[bufferSize];
        if (!AudioSystem.isLineSupported(info)) {
            System.out.println("Line not supported");
            System.exit(0);
        }

        try {
            TargetDataLine targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
            targetDataLine.open(audioFormat);
            targetDataLine.start();


            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.out.println("Listening to the microphone...");
            int bytesRead = targetDataLine.read(buffer, 0, buffer.length); // Adjust this line for longer or shorter recording
            outputStream.write(buffer, 0, bytesRead);
            targetDataLine.stop();
            targetDataLine.close();

            byte[] audioBytes = outputStream.toByteArray();
            System.out.println("Audio bytes captured: " + audioBytes.length);
            outputStream.close();
            return audioBytes;

        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    static AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                channels, signed, bigEndian);
        return format;
    }

    static byte[] start() {
        try {
            //AudioFormat audioFormat = getAudioFormat();
            AudioFormat audioFormat = new AudioFormat(44100, 16, 1, true, false);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);

            // checks if system supports the data line
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
                System.exit(0);
            }
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(audioFormat);
            line.start();   // start capturing
            AudioInputStream ais = new AudioInputStream(line);

            System.out.println("Start recording...");

            // start recording
            AudioSystem.write(ais, fileType, wavFile);


            ByteArrayOutputStream out = new ByteArrayOutputStream();


            int numBytesRead;
            byte[] data = new byte[line.getBufferSize() / 5];
            System.out.println("Start capturing...");

            long msTime = 15000; //1 Minute = 60000 MS
            long doUntil = (msTime + System.currentTimeMillis()); //1 minute
            while(System.currentTimeMillis() < doUntil){
                //System.out.println(System.currentTimeMillis() +" to " + doUntil);
                // Read the next chunk of data from the TargetDataLine.
                numBytesRead =  line.read(data, 0, data.length);
                // Save this chunk of data.
                out.write(data, 0, numBytesRead);
            }


            BufferedInputStream in = new BufferedInputStream(new FileInputStream(wavFile));

            int read;
            byte[] buff = new byte[1024];
            while ((read = in.read(buff)) > 0)
            {
                out.write(buff, 0, read);
            }
            out.flush();
            byte[] audioBytes = out.toByteArray();
            return audioBytes;


        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new byte[0];
    }

    static void finish() {
        line.stop();
        line.close();
        System.out.println("Finished");
    }

    public static void main2(String[] args) {


        // creates a new thread that waits for a specified
        // of time before stopping
        Thread stopper = new Thread(() -> {
            try {
                Thread.sleep(RECORD_TIME);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            finish();
        });

        stopper.start();

        // start recording
        byte[] audioBytes = start();
        ACRCloudRecognizer re = new ACRCloudRecognizer(getConfig());
        String result = re.recognizeByFileBuffer(audioBytes, audioBytes.length, 0);
        System.out.println(result);
    }

}
