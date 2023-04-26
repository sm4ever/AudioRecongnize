package utils;

public class IdentificationException extends Throwable {
    public IdentificationException(String musicNotRecognized) {
        System.out.println(musicNotRecognized);
    }
}
