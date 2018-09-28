package baseclasses;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;


public class RestClient {

    public HttpResponse sendGetRequest(String getUri) throws Exception{
        HttpClient client = HttpClientBuilder.create().build();
        return client.execute(new HttpGet(getUri));
    }

    public String getResponseCodeAsString(HttpResponse httpResponse){
        return Integer.toString(httpResponse.getStatusLine().getStatusCode());
    }

}
