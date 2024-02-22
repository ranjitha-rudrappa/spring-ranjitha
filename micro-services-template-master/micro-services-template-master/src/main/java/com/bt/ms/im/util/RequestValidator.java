package com.bt.ms.im.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.bt.ms.im.config.AppConstants;
import com.bt.ms.im.entity.GetRequest;
import com.bt.ms.im.error.BadRequestException1;
import com.bt.ms.im.exception.StandardError;
import com.bt.ms.im.exception.handler.standardexception.BadRequestException;

@Component
public class RequestValidator {
	
	@Autowired
	AppConstants appconstants;
	
	private static final Logger log = LoggerFactory.getLogger(RequestValidator.class);
	private static final String TACKINGREGEX = "^[0-9a-zA-Z]{8}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{4}-[0-9a-zA-Z]{12}$";
	private static final String UUIDREGEX = "^[a-zA-Z0-9-]{1,50}$";
	
	public ResponseEntity<BadRequestResponse> validateGetRequest(GetRequest request) {
	    String trackingid = request.getTrackingHeader();
	    String uuid = request.getUuid();
	    String consumerId=request.getConsumeridref();
	    
	    log.info("Validating the request");

	    if (trackingid == null) {
	    	    log.error("Tracking ID is null");
		        StandardError errormsg = StandardError.ERR400_25;
		        log.error(errormsg.getMessage());
		        throw new BadRequestException(errormsg);
	    }
	    	else {
	    }
	        String regexTracking = TACKINGREGEX;
	        Pattern patternTracking = Pattern.compile(regexTracking);
	        Matcher matcherTracking = patternTracking.matcher(trackingid);
	        boolean trackingValid = matcherTracking.matches();
	        log.info("Is Tracking ID valid? {}", trackingValid);
	       

	        if (!trackingValid) {
	        	
	        	 StandardError errormsg = StandardError.ERR400_26;
			        log.error(errormsg.getMessage());
			        throw new BadRequestException(errormsg);
	           
	        }
	        
	        
	        if(uuid==null && consumerId==null) {       	
	        	 StandardError errormsg = StandardError.ERR400_25;
			        log.error(errormsg.getMessage());
			        throw new BadRequestException(errormsg);
	        }

	    if (uuid != null) {
	        String regexUuid = UUIDREGEX;
	        Pattern patternUuid = Pattern.compile(regexUuid);
	        Matcher matcherUuid = patternUuid.matcher(uuid);
	        boolean uuidValid = matcherUuid.matches();
	        log.info("Is UUID valid? {}", uuidValid);

	        if (!uuidValid) {
	        	
	        	  StandardError errormsg = StandardError.ERR400_26;
			        log.error(errormsg.getMessage());
			        throw new BadRequestException(errormsg);
	        	
	        }
	    }
	    return ResponseEntity.ok().build();
	}}

