package com.bt.ms.im.service;

import com.bt.ms.im.config.AppConstants;
import com.bt.ms.im.entity.BtWifiEligibilityResponse;
import com.bt.ms.im.entity.GetRequest;
import com.bt.ms.im.entity.GetResponse;
import com.bt.ms.im.entity.ResponseBean;
import com.bt.ms.im.mapper.BtWifiEligibilityMapper;
import com.bt.ms.im.repository.DNPRepository;
import com.bt.ms.im.repository.DataRepository;

import jakarta.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


//@Service
//public class GetClientProfileServiceImpl {
//	
//	@Autowired
//	AppConstants appConstants;
//	
//	@Autowired
//	DNPRepository dnpRepository;
//	
//	@Autowired
//    BtWifiEligibilityMapper responseMapper;
////	
//	@SuppressWarnings("unchecked")
//	public ResponseBean<ResponseBean<GetClientProfileV1Res>> getclientprofile(GetRequest request){
//		 System.out.println("Sending request to dnp");
//		ResponseBean<GetClientProfileV1Res> dnpResponse = dnpRepository.getClientProfile(request);
//		
//		
////		if(dnpResponse.isFailed()) {
////			//return ResponseBean.errorRes(GetClientProfileV1Res.class, appConstants.getErrorRes().getClientErrorCode(),
////				//	appConstants.getErrorRes().getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);			
////		}
////		ResponseBean<BtWifiEligibilityResponse> finalResponse = 
////				responseMapper.getWifiEligibilityResponseMap(dnpResponse.getData());	
////		if(finalResponse.isFailed()) {
////			//return ResponseBean.errorRes(BtWifiEligibilityResponse.class,
//////					appConstants.getErrorRes().getForbiddenUserCode(),
//////					appConstants.getErrorRes().getForbiddenUserMessage(),HttpStatus.FORBIDDEN);
////					
////		}
//	return ResponseBean.of(dnpResponse);
//
//	}
//
//}

@Service
public class GetClientProfileServiceImpl {
    
    @Autowired
    AppConstants appConstants;
    
    @Autowired
    DNPRepository dnpRepository;
    
    @Autowired
    DataRepository dataRepository;
    
    @Autowired
    BtWifiEligibilityMapper responseMapper;
    
//    public void saveData() {
//        
//        String uuid = "0ab7cc-b2b6-1033-9f36-9a1c1857c272";
//        String csfid = "0ab297cc-b2b6-1033-9f36-9a1c1857c202";
//
//        // Create a new instance of GetResponse
//        GetResponse entity = new GetResponse();
//
//        // Set the predefined values for uuid and csfid
//        entity.setUuid(uuid);
//        entity.setCsfid(csfid);
//
//        // Save the entity to the repository
//        dataRepository.save(entity);
//    }
    
    private static final Logger logger = LoggerFactory.getLogger(GetClientProfileServiceImpl.class);
  
    
    public ResponseBean<BtWifiEligibilityResponse> getclientprofile(GetRequest request) {
        logger.info("Sending request to dnp");
        ResponseBean<GetClientProfileV1Res> dnpResponse = dnpRepository.getClientProfile(request);
       
        BtWifiEligibilityResponse finalResponse = responseMapper.mapValues(dnpResponse.getData());
        
        return ResponseBean.of(finalResponse);
    }
}
