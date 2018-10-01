package org.lloydryandavid.concordion.concordionbookapp.baseclass;


import org.concordion.api.AfterSpecification;
import org.concordion.api.BeforeSpecification;
import org.junit.BeforeClass;
import org.lloydryandavid.bookapp.BookApplication;
import org.lloydryandavid.concordion.concordionbookapp.database.ConcordionBookAppDbUtil;
import org.lloydryandavid.concordion.concordionbookapp.restclient.ConcordionBookAppRestClient;
import org.springframework.http.*;
import java.util.Map;


public abstract class ConcordionBookAppBaseTestClass {

    ConcordionBookAppDbUtil dbUtil = new ConcordionBookAppDbUtil();
    ConcordionBookAppRestClient concordionBookAppRestClient = new ConcordionBookAppRestClient();

    private static boolean alreadyStarted = false;

    @BeforeSpecification
    public void startBookAppRestWebService(){
        if(!alreadyStarted){
            BookApplication.main(new String[]{});
        }
        dbUtil.initializeDatabase();
    }

    @AfterSpecification
    public void stopBookAppRestWebService(){
        alreadyStarted = true;
    }

    public ResponseEntity<String> sendHttpPostMessage(String url, Map<String, String> httpPostMessageMap){
            return concordionBookAppRestClient.sendHttpPostMessage(url, httpPostMessageMap);
    }

    public Map<String, String> getResponseAsMap(ResponseEntity<String> responseEntity) throws Exception{
        return concordionBookAppRestClient.convertResponseAsMap(responseEntity);
    }

}
