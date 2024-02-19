package com.bt.ms.im.controller;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.bt.ms.im.config.AppConstants;
import com.bt.ms.im.entity.BtWifiEligibilityResponse;
import com.bt.ms.im.entity.GetRequest;
import com.bt.ms.im.entity.ResponseBean;
import com.bt.ms.im.service.GetClientProfileServiceImpl;
import com.bt.ms.im.util.LogUtil;
import com.bt.ms.im.util.RequestValidator;

//@WebMvcTest(BtWifiController.class)
public class BtWifiControllerTest {

//  @Autowired
//  private MockMvc mockMvc;
//
//  @MockBean
//  private RequestValidator requestValidator;
//  
//  @MockBean
//  private GetClientProfileServiceImpl getclientprofileservice;
//
//  @MockBean
//  private AppConstants appConstants;
//
//  @MockBean  
//  private LogUtil logUtils;
//
//  @Test
//  public void testGetCustomerOtp() throws Exception {
//
//    String apigwTrackingHeader = "96bb97fa-b941-46bb-8c4e-86c616c28a13";
//    
//    String xProfileGuid = "0ab297cc-b2b6-1033-9f36-9a1c1857c201";
//    
//    String xConsumerDigitalIdRef = "sampleXConsumerDigitalIdRef";
//
//    GetRequest getRequest = new GetRequest();
//    
//    BtWifiEligibilityResponse mockResponse = new BtWifiEligibilityResponse("1a4cc470-4c89-103b-99a0-a5b85ba73e01","SOME_VALUE");
//    
//    ResponseBean<BtWifiEligibilityResponse> mockResponseBean = ResponseBean.of(mockResponse);
//    
//    when(getclientprofileservice.getclientprofile(getRequest)).thenReturn(mockResponseBean);
//    
// //   doNothing().when(requestValidator).validateGetRequest(getRequest);
//    
//    mockMvc.perform(MockMvcRequestBuilders.get("/bt-consumer/v2/wifi-eligibility")
//      .header("APIGW-Tracking-Header", apigwTrackingHeader)
//      .header("X-Profile-Guid", xProfileGuid)
//      .header("X-Consumer-DigitalId-Ref", xConsumerDigitalIdRef)
//      .contentType(MediaType.APPLICATION_JSON))
//      .andExpect(MockMvcResultMatchers.status().isOk())
//      .andReturn();
//  }

}




