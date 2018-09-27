package baseclasses;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class RestClient {

    private RestTemplate restTemplate = new RestTemplate();
    private static final String GET_URI = "http://localhost:1080/greeting";

    public ResponseEntity<String> sendGetRequest(String getUri){
        return restTemplate.getForEntity(getUri, String.class);
    }

}
