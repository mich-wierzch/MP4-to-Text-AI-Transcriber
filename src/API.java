import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class API {
    String transcriptedAudio;
    String audio;
    private String api_Key;
    Transcript transcript;
    Gson gson = new Gson();


    public API(String audio, Transcript transcript, String api_Key) throws IOException, InterruptedException, URISyntaxException {
        this.audio = audio;
        this.transcript = transcript;
        this.api_Key = api_Key;
        performRequest();

    }

     private HttpRequest createPostRequest() throws URISyntaxException {
         return HttpRequest.newBuilder()
                 .uri(new URI("https://api.assemblyai.com/v2/transcript"))
                 .header("Authorization", api_Key)
                 .POST(HttpRequest.BodyPublishers.ofString(audio))
                 .build();
     }
    public void performRequest() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest postRequest = createPostRequest();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(postResponse.body());
        transcript = gson.fromJson(postResponse.body(), Transcript.class);
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript/" + transcript.getId()))
                .header("Authorization", api_Key)
                .build();
        while (true) {

            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            transcript = gson.fromJson(getResponse.body(), Transcript.class);
            System.out.println(transcript.getStatus());
            if (transcript.getStatus() == null){
                throw new RuntimeException("There was an error");
            }
            if ("completed".equals(transcript.getStatus()) || "error".equals(transcript.getStatus())){
                break;
            }
            Thread.sleep(1000);
        }
         transcriptedAudio = transcript.getText();

        }



    }




