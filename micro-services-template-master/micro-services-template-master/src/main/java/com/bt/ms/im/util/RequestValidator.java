package com.bt.ms.im.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bt.ms.im.config.AppConstants;
import com.bt.ms.im.entity.GetRequest;

@Component
public class RequestValidator {
	@Autowired
	AppConstants appConstants;
	
	private static final Logger log = LoggerFactory.getLogger(RequestValidator.class);
	private static final String TACKINGREGEX = "^[\\w.~-]{1,255}$";
	private static final String UUIDREGEX = "^[a-zA-Z0-9-]{1,50}$";
	
	public void validateGetRequest(GetRequest request) {
		String trackingid = request.getTrackingHeader();
		String Uuid = request.getUuid();
		String consumerIDref = request.getConsumeridref();
		
		
		
		if(trackingid == null)
		{
//			StandardError errormsg = StandardError.ERR400_25;
//			log.error(errormsg.getMessage());
//			throw new BadRequestException(errormsg);
		}
		else
		{
			String regex = TACKINGREGEX;
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(trackingid);
			boolean trackingid1 = matcher.matches();
			if(!trackingid1)
			{
//				BadRequestResponse badRequestResponse = new BadRequestResponse();
//	            badRequestResponse.setErrorCode(400);
//	            badRequestResponse.setErrorMessage("Invalid tracking ID");
//
//	            // Throw an exception with the BadRequestResponse
//	            throw new BadRequestException(badRequestResponse);
	        }
			}
			
		
		if(Uuid!=null)
		{
			String regex = UUIDREGEX;
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(Uuid);
			boolean Uuid1 = matcher.matches();
			if(!Uuid1)
			{
//				BadRequestResponse badRequestResponse = new BadRequestResponse();
//	            badRequestResponse.setErrorCode(400);
//	            badRequestResponse.setErrorMessage("Invalid UUID");
//
//	            // Throw an exception with the BadRequestResponse
//	            throw new BadRequestException(badRequestResponse);
		}
		}

	}
	}
