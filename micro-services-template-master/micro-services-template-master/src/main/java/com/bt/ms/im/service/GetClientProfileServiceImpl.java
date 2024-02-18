package com.bt.ms.im.service;

import com.bt.ms.im.config.AppConstants;
import com.bt.ms.im.entity.BtWifiEligibilityResponse;
import com.bt.ms.im.entity.GetRequest;
import com.bt.ms.im.entity.GetResponse;
import com.bt.ms.im.entity.ResponseBean;
import com.bt.ms.im.mapper.BtWifiEligibilityMapper;
import com.bt.ms.im.repository.DNPRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class GetClientProfileServiceImpl {
	
	@Autowired
	AppConstants appConstants;
	
	@Autowired
	DNPRepository dnpRepository;
	
	@Autowired
	BtWifiEligibilityMapper responseMapper;
	
	
	@SuppressWarnings("unchecked")
	public ResponseBean<BtWifiEligibilityResponse> getclientprofile(GetRequest request){
		 System.out.println("Sending request to dnp");
//		ResponseBean<GetClientProfileV1Res> dnpResponse = dnpRepository.getClientProfile(request);
//		
//		if(dnpResponse.isFailed()) {
//			//return ResponseBean.errorRes(GetClientProfileV1Res.class, appConstants.getErrorRes().getClientErrorCode(),
//				//	appConstants.getErrorRes().getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);			
//		}
//		ResponseBean<BtWifiEligibilityResponse> finalResponse = 
//				responseMapper.getWifiEligibilityResponseMap(dnpResponse.getData());	
//		if(finalResponse.isFailed()) {
//			//return ResponseBean.errorRes(BtWifiEligibilityResponse.class,
////					appConstants.getErrorRes().getForbiddenUserCode(),
////					appConstants.getErrorRes().getForbiddenUserMessage(),HttpStatus.FORBIDDEN);
//					
//		}
//		return ResponseBean.of(finalResponse.getData());
		 ResponseBean<BtWifiEligibilityResponse> dnpResponse = dnpRepository.getClientProfile(request);
		 System.out.println(dnpResponse);
		 return dnpResponse;
	}

}
