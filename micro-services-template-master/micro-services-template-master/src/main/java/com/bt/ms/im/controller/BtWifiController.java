package com.bt.ms.im.controller;

import org.eclipse.jetty.util.log.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bt.ms.im.config.AppConstants;
import com.bt.ms.im.entity.BaseResponse;
import com.bt.ms.im.entity.BtWifiEligibilityResponse;
import com.bt.ms.im.entity.GetRequest;
import com.bt.ms.im.entity.GetResponse;
import com.bt.ms.im.entity.ResponseBean;
import com.bt.ms.im.service.GetClientProfileServiceImpl;
import com.bt.ms.im.util.RequestValidator;

@RestController
@RequestMapping("/bt-consumer/v2/wifi-eligibility")
@EnableAutoConfiguration
public class BtWifiController {
	
	@Autowired
	RequestValidator requestValidator;

	@Autowired
	GetClientProfileServiceImpl getclientprofileservice;

	@Autowired
	AppConstants appConstants;
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BtWifiController.class);
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping( produces = { "application/json" })
	public ResponseEntity<BtWifiEligibilityResponse> getCustomerOtp(
			@RequestHeader(value = "APIGW-Tracking-Header", required = true) String apigwTrackingHeader,
			@RequestHeader(value = "X-Profile-Guid", required = false) String xProfileGuid,
			@RequestHeader(value = "X-Consumer-DigitalId-Ref", required = false) String xConsumerDigitalIdRef) {

		GetRequest getrequest = new GetRequest();
		logger.info("This is an informational message.");
		getrequest.setTrackingHeader(apigwTrackingHeader);
		getrequest.setUuid(xProfileGuid);
		getrequest.setConsumeridref(xConsumerDigitalIdRef);
        System.out.println("Request validation");
		requestValidator.validateGetRequest(getrequest);
		 System.out.println("Sending to service layer");
		ResponseBean<BtWifiEligibilityResponse> response = getclientprofileservice.getclientprofile(getrequest);

		if (response.isSuccess()) {
			return new ResponseEntity<>(response.getData(), HttpStatus.OK);
		}

		else {
			BaseResponse errorres = new BaseResponse();
			errorres.setCode(response.getCode());
			errorres.setMessage(response.getMessage());
			errorres.setRootException(response.getRootExceptions());
			HttpStatus status = setErrorCode(response);

			return new ResponseEntity(errorres, status);
		}
	}


	private HttpStatus setErrorCode(ResponseBean<BtWifiEligibilityResponse> response) {
		return null;
	}


}
