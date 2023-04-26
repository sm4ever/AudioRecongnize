import utils.IdentificationException;

public class App {

    public static void main(String[] args) throws IdentificationException {

        MusicIdentification musicIdentification = new MusicIdentification();

        musicIdentification.listen();
        String result = musicIdentification.identify();
        musicIdentification.print(result);

    }
}
