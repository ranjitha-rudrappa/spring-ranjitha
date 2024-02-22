package com.bt.ms.im.mapper;

import org.springframework.stereotype.Component;

import com.bt.ms.im.entity.BtWifiEligibilityResponse;
import com.bt.ms.im.entity.ClientServiceInstanceV1;
import com.bt.ms.im.exception.handler.standardexception.ForbiddenException;
import com.bt.ms.im.service.GetClientProfileV1Res;

@Component
public class BtWifiEligibilityMapper {

    public BtWifiEligibilityResponse mapValues(GetClientProfileV1Res response) {
        String uuid = null;
        String csfid = null;
        boolean uuidConditionMet = false; 

      
        for (ClientServiceInstanceV1 clientServiceInstance : response.getData().getClientServiceInstances()) {
            if (!uuidConditionMet && isUuidMappingConditionMet(clientServiceInstance)) {
                uuid = clientServiceInstance.getKey();
                uuidConditionMet = true;
            }
            if (isCfsidMappingConditionMet(clientServiceInstance)) {
                csfid = clientServiceInstance.getCharacteristics().getValue();
            }

           
            if (uuid != null && csfid != null) {
            	 break;
            }
           
        }
       
        return new BtWifiEligibilityResponse(uuid, csfid);
       
    }


    		
    private boolean isUuidMappingConditionMet(ClientServiceInstanceV1 clientServiceInstance) {
        boolean conditionMet = "ACTIVE".equals(clientServiceInstance.getStatus()) &&
                ("BTWIFI:DEFAULT".equals(clientServiceInstance.getServiceCode()) ||
                        "BTROPENZONE".equals(clientServiceInstance.getServiceCode()));
        System.out.println(conditionMet);
        if (!conditionMet) {
            throw new ForbiddenException("52", "Forbidden User");
        }

        return true;
    }


    private boolean isCfsidMappingConditionMet(ClientServiceInstanceV1 clientServiceInstance) {

    	return "CONTENTFILTERING:DEFAULT".equals(clientServiceInstance.getServiceCode()) &&
                clientServiceInstance.getCharacteristics() != null &&
                "CFSID".equals(clientServiceInstance.getCharacteristics().getName()) &&
                "ACTIVE".equals(clientServiceInstance.getStatus());
   }
}

