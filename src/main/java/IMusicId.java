import utils.IdentificationException;

public interface IMusicId {

    void listen();
    String identify();
    void print(String result) throws IdentificationException;


}
