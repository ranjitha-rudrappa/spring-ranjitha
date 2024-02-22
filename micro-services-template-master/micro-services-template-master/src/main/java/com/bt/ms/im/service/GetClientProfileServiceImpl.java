package com.bt.ms.im.service;

import com.bt.ms.im.config.AppConstants;
import com.bt.ms.im.entity.BtWifiEligibilityResponse;
import com.bt.ms.im.entity.GetRequest;
import com.bt.ms.im.entity.ResponseBean;
import com.bt.ms.im.mapper.BtWifiEligibilityMapper;
import com.bt.ms.im.repository.DNPRepository;
import com.bt.ms.im.repository.DataRepository;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    
    private static final Logger logger = LoggerFactory.getLogger(GetClientProfileServiceImpl.class);
  
    @SuppressWarnings("unchecked")
	public ResponseBean<BtWifiEligibilityResponse> getclientprofile(GetRequest request) {
        logger.info("Sending request to dnp");

        try {
            ResponseBean<GetClientProfileV1Res> dnpResponse = dnpRepository.getClientProfile(request);
            
            if (dnpResponse.isSuccess()) {
                BtWifiEligibilityResponse finalResponse = responseMapper.mapValues(dnpResponse.getData());
                return ResponseBean.of(finalResponse);
            } else {
                
                return ResponseBean.errorRes(dnpResponse.getCode(), dnpResponse.getMessage());
            }
        } catch (Exception e) {
           
            return ResponseBean.errorRes(appConstants.getErrorRes().getInternalErrorCode(), "Internal Server Error");
        }
    }
}

//
//@Service
//public class GetClientProfileServiceImpl {
//    
//    @Autowired
//    AppConstants appConstants;
//    
//    @Autowired
//    DNPRepository dnpRepository;
//    
//    @Autowired
//    DataRepository dataRepository;
//    
//    @Autowired
//    BtWifiEligibilityMapper responseMapper;
//    
//
//    private static final Logger logger = LoggerFactory.getLogger(GetClientProfileServiceImpl.class);
//  
//    
//    public ResponseBean<BtWifiEligibilityResponse> getclientprofile(GetRequest request) {
//        logger.info("Sending request to dnp");
//        ResponseBean<GetClientProfileV1Res> dnpResponse = dnpRepository.getClientProfile(request);
//       
//        BtWifiEligibilityResponse finalResponse = responseMapper.mapValues(dnpResponse.getData());
//        
//        return ResponseBean.of(finalResponse);
//    }
//}
