package restwebservice;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class RestWebService {

    private static final int DEFAULT_PORT = 1080;
    private static final String DEFAULT_HOST = "localhost";
    private static final String GET_URI = "/greeting";
    private static final String DEFAULT_GET_RESPONSE = "Hello World!";
    WireMockServer wireMockServer = new WireMockServer(DEFAULT_PORT);

    public void startRestWebService(){
        wireMockServer.start();
        configureFor(DEFAULT_HOST, DEFAULT_PORT);
        wireMockServer.stubFor(WireMock.get(urlEqualTo(GET_URI)).willReturn(WireMock.aResponse().withBody(DEFAULT_GET_RESPONSE)));
    }

    public void stopRestWebService(){
        wireMockServer.stop();
    }


}
