package org.lloydryandavid.concordion.concordionbookapp.restclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
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

    public ResponseEntity<String> sendHttpPostMessage(String url, Map<String, String> httpPostMessageMap){
        HttpEntity<HashMap<String, String>> postRequest = new HttpEntity(httpPostMessageMap, headers);
        ResponseEntity<String> responseEntity;
        try{
            responseEntity = restTemplate.postForEntity(url, postRequest, String.class);
        }
        catch (Exception e){
            responseEntity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    public Map<String, String> convertResponseAsMap(ResponseEntity<String> responseEntity){
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = new HashMap();
        try{
            map = mapper.readValue(responseEntity.getBody(), new TypeReference<Map<String, String>>(){});
            map.put("status", Integer.toString(responseEntity.getStatusCodeValue()));
        }
        catch (Exception e){
            map.put("status", Integer.toString(responseEntity.getStatusCodeValue()));
        }
        return map;
    }

}
