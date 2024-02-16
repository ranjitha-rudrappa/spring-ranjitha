package com.bt.ms.im.controller;

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
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping( produces = { "application/json" })
	public ResponseEntity<GetResponse> getCustomerOtp(
			@RequestHeader(value = "APIGW-Tracking-Header", required = true) String apigwTrackingHeader,
			@RequestHeader(value = "X-Profile-Guid ", required = false) String uuid,
			@RequestHeader(value = "-Consumer-DigitalId-Ref", required = false) String consumerId) {

		GetRequest getrequest = new GetRequest();
		
		getrequest.setTrackingHeader(apigwTrackingHeader);
		getrequest.setUuid(uuid);
		getrequest.setConsumeridref(consumerId);

		requestValidator.validateGetRequest(getrequest);

		ResponseBean<GetResponse> response = getclientprofileservice.getclientprofile(getrequest);

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


	private HttpStatus setErrorCode(ResponseBean<GetResponse> response) {
		return null;
	}


}
