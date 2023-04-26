import com.acrcloud.utils.ACRCloudRecognizer;
import com.google.gson.Gson;
import model.Response;
import utils.Constants;
import utils.IdentificationException;
import utils.MicrophoneUtil;

public class MusicIdentification implements IMusicId{
    @Override
    public void listen() {
        System.out.println("------------------LISTENING--------------------");
        MicrophoneUtil.record();
        System.out.println("-----------------------------------------------");
    }

    public String identify() {
        System.out.println("----------------IDENTIFYING--------------------");

        ACRCloudRecognizer re = new ACRCloudRecognizer(Constants.getConfig());
        System.out.println("-----------------------------------------------");
        return re.recognizeByFile(Constants.FILE,0);
    }

    @Override
    public void print(String result) throws IdentificationException {
        System.out.println("------------------PRINTING---------------------");

        Gson gson = new Gson();
        Response response = gson.fromJson(result, Response.class);


        if(response!=null && response.getStatus()!=null && response.getStatus().getCode().equals(0L)) {

            response.getMetadata().getMusic().forEach(music -> {
                System.out.println("Album : " + music.getAlbum().getName());
                System.out.println("Label : " + music.getLabel());
                System.out.println("Title : " + music.getTitle());
                System.out.print("Artists : ");
                music.getArtists().forEach(artist -> System.out.print(artist.getName()+ " "));
            });
        }else{
            throw new IdentificationException("Music not recognized");
        }
    }
}
