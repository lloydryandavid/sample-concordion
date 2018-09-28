package baseclasses;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.concordion.api.AfterSpecification;
import org.concordion.api.BeforeSpecification;
import restwebservice.RestWebService;

public class BaseTestClass {

    private RestClient restClient = new RestClient();


    public HttpResponse sendGetRequest(String uri) throws Exception {
        return restClient.sendGetRequest(uri);
    }

    public String getHttpResponseCodeAsString(HttpResponse httpResponse){
        return restClient.getResponseCodeAsString(httpResponse);
    }

    public String getHttpBodyAsString(HttpResponse httpResponse) throws Exception{
        return EntityUtils.toString(httpResponse.getEntity());
    }

}
