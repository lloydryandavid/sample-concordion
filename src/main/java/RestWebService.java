import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class RestWebService {

    private static final int DEFAULT_PORT = 1080;
    private static final String DEFAULT_HOST = "localhost";
    WireMockServer wireMockServer = new WireMockServer(DEFAULT_PORT);

    public void startRestWebService(){
        wireMockServer.start();
        configureFor(DEFAULT_HOST, DEFAULT_PORT);
        wireMockServer.stubFor(WireMock.get(urlEqualTo("/greeting")).willReturn(WireMock.aResponse().withBody("Hello World!")));
    }

    public void stopRestWebService(){
        wireMockServer.stop();
    }


}
