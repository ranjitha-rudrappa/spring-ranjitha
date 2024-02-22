package com.bt.ms.im.repository;

import com.bt.ms.im.entity.GetRequest;
import com.bt.ms.im.service.GetClientProfileV1Res;
import com.bt.ms.im.repository.DNPRepository;
import com.bt.ms.im.entity.ResponseBean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RepoTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private DNPRepository dnpRepository;
    
    @BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
 
    @Test
    void testGetClientProfileFromExternalService() throws URISyntaxException {
       
        GetClientProfileV1Res expectedResponse = new GetClientProfileV1Res();
        ResponseEntity<GetClientProfileV1Res> mockResponseEntity = new ResponseEntity<>(expectedResponse, HttpStatus.OK);

   //     String externalEndpointUrl = "http://localhost:7896/data";

        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), isNull(), eq(GetClientProfileV1Res.class)))
                .thenReturn(mockResponseEntity);

        GetRequest mockReq = new GetRequest();
        ResponseBean<GetClientProfileV1Res>actualResponse = dnpRepository.getClientProfile(mockReq);

       
     // assertEquals(HttpStatus.OK, actualResponse.getStatus(), "Response status should be OK");
        assertEquals(mockResponseEntity, actualResponse.getData(), "Response data should match");
        
    }
}






 