package com.bt.ms.im.repository;

import com.bt.ms.im.entity.*;
import com.bt.ms.im.service.GetClientProfileV1Res;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
 

 
@Repository
public class DNPRepository {
    
//    @Value("${external.endpoint.url}") String externalEndpointUrl;
 
    public ResponseBean<GetClientProfileV1Res> getClientProfile(GetRequest request) {
        
        RestTemplate restTemplate = new RestTemplate();
    
        ResponseEntity<GetClientProfileV1Res> responseEntity = restTemplate.exchange(
        		"http://localhost:7896/data",
                HttpMethod.GET,
                null,
                GetClientProfileV1Res.class                
        );
        
      
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            GetClientProfileV1Res clientProfile = responseEntity.getBody();
         
 
            return ResponseBean.of(clientProfile);
        } else {
         
            return ResponseBean.of(null); 
        }
    }
}

