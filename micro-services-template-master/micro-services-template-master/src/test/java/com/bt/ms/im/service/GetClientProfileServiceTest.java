package com.bt.ms.im.service;

import com.bt.ms.im.config.AppConstants;
import com.bt.ms.im.entity.GetRequest;
import com.bt.ms.im.entity.ResponseBean;
import com.bt.ms.im.service.GetClientProfileV1Res;
import com.bt.ms.im.entity.BtWifiEligibilityResponse;
import com.bt.ms.im.mapper.BtWifiEligibilityMapper;
import com.bt.ms.im.repository.DNPRepository;
import com.bt.ms.im.repository.DataRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class GetClientProfileServiceTest {

    @Mock
    private DNPRepository dnpRepository;

    @Mock
    private DataRepository dataRepository;

    @Mock
    private BtWifiEligibilityMapper responseMapper;

    @InjectMocks
    private GetClientProfileServiceImpl getClientProfileService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetClientProfile() {
      
        GetRequest getRequest = new GetRequest();
        GetClientProfileV1Res dnpResponseData = new GetClientProfileV1Res();
        BtWifiEligibilityResponse finalResponse = new BtWifiEligibilityResponse();

        
        when(dnpRepository.getClientProfile(any(GetRequest.class))).thenReturn(ResponseBean.of(dnpResponseData));

        
        when(responseMapper.mapValues(dnpResponseData)).thenReturn(finalResponse);

      
        ResponseBean<BtWifiEligibilityResponse> result = getClientProfileService.getclientprofile(getRequest);

       
        assertEquals(finalResponse, result.getData());
    }
    
    @SuppressWarnings("unchecked")
	@Test
    void testGetClientProfileException() {
        GetRequest getRequest = new GetRequest();
        @SuppressWarnings("unused")
		GetClientProfileV1Res dnpResponseData = new GetClientProfileV1Res();
        
        // Mocking a failure response from the repository
        when(dnpRepository.getClientProfile(any(GetRequest.class)))
                .thenReturn(ResponseBean.errorRes("500", "Internal Server Error"));


        ResponseBean<BtWifiEligibilityResponse> result = getClientProfileService.getclientprofile(getRequest);

        assertEquals("500", result.getCode());
        assertEquals("Internal Server Error", result.getMessage());
       // assertEquals(null, result.getData());  
    }

}

