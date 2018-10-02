package org.lloydryandavid.concordion.concordionbookapp.restclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class ConcordionBookAppRestClient {

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers;

    public ConcordionBookAppRestClient(){
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public ResponseEntity<String> sendHttpGetMessage(String url){
        return restTemplate.getForEntity(url, String.class);
    }


    public ResponseEntity<String> sendHttpPostMessage(String url, Map<String, String> httpPostMessageMap){
        HttpEntity<HashMap<String, String>> postRequest = new HttpEntity(httpPostMessageMap, headers);
        ResponseEntity<String> responseEntity;
        try{
            responseEntity = restTemplate.postForEntity(url, postRequest, String.class);
        }
        catch (HttpClientErrorException httpClientErrorException){
            String responseBody = httpClientErrorException.getResponseBodyAsString();
            responseEntity = new ResponseEntity<String>(responseBody, httpClientErrorException.getStatusCode());
        }
        return responseEntity;
    }

    public Map<String, String> convertResponseAsMap(ResponseEntity<String> responseEntity) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = new HashMap();
        map = mapper.readValue(responseEntity.getBody(), new TypeReference<Map<String, String>>(){});
        map.put("status", Integer.toString(responseEntity.getStatusCodeValue()));
        return map;
    }

}
