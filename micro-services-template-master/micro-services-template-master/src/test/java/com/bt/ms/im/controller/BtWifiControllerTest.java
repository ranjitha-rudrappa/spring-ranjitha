package com.bt.ms.im.controller;

import com.bt.ms.im.entity.BtWifiEligibilityResponse;
import com.bt.ms.im.entity.GetRequest;
import com.bt.ms.im.entity.ResponseBean;
import com.bt.ms.im.service.GetClientProfileServiceImpl;
import com.bt.ms.im.util.RequestValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BtWifiControllerTest {

	@Mock
	private RequestValidator requestValidator;

	@Mock
	private GetClientProfileServiceImpl getclientprofileservice;

	@InjectMocks
	private BtWifiController btWifiController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetCustomerOtp() {
		
		String apigwTrackingHeader = "96bb97fa-b941-46bb-8c4e-86c616c28a13";
		String xProfileGuid = "0ab297cc-b2b6-1033-9f36-9a1c1857c201";
		String xConsumerDigitalIdRef = "0ab7cc-b2b6-1033-9f36-9a1c1857c271";

		GetRequest getRequest = new GetRequest();
		getRequest.setTrackingHeader(apigwTrackingHeader);
		getRequest.setUuid(xProfileGuid);
		getRequest.setConsumeridref(xConsumerDigitalIdRef);

		BtWifiEligibilityResponse mockedResponseData = new BtWifiEligibilityResponse(
				"1a4cc470-4c89-103b-99a0-a5b85ba73e01", "SOME_VALUE");
		ResponseBean<BtWifiEligibilityResponse> mockResponse = new ResponseBean<>(mockedResponseData);

		when(getclientprofileservice.getclientprofile(Mockito.any(GetRequest.class))).thenReturn(mockResponse);

		ResponseEntity<BtWifiEligibilityResponse> responseEntity = btWifiController.getCustomerOtp(apigwTrackingHeader,
				xProfileGuid, xConsumerDigitalIdRef);



		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(mockedResponseData, responseEntity.getBody());
	}
}
