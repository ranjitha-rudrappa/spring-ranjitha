package com.bt.ms.im.mapper;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bt.ms.im.entity.*;
//import com.bt.ms.im.entity.ResponseBean;
import com.bt.ms.im.exception.handler.standardexception.ForbiddenException;
import com.bt.ms.im.service.GetClientProfileV1Res;

@Component
public class BtWifiEligibilityMapper {

	public ResponseBean<BtWifiEligibilityResponse> getWifiEligibilityResponseMap(GetClientProfileV1Res response) {
	BtWifiEligibilityResponse result = new BtWifiEligibilityResponse();
List<ClientServiceInstanceV1> clientServiceInstances = response.getClientProfileV1().getClientServiceInstancesV1();

		        System.out.println("mapper");
		        boolean wifiDefaultMatched = false;
		        boolean contentFilteringMatched = false;

		        for (ClientServiceInstanceV1 instance : clientServiceInstances) {
		            if (isWifiDefaultInstance(instance)) {
		                wifiDefaultMatched = true;
		                result.setUuid(instance.getKey());
		            } else if (isContentFilteringInstance(instance)) {
		                contentFilteringMatched = true;
		                result.setCsfid(getCfsidValue(instance));
		            }
		        }

		        // Check if both conditions are not met
		        if (!wifiDefaultMatched) {
		            throw new ForbiddenException("No matching instance for BTWIFI:DEFAULT or BTROPENZONE with status ACTIVE", null);
		        }

		        if (!contentFilteringMatched) {
		            throw new ForbiddenException("No matching instance for CONTENTFILTERING:DEFAULT with characteristic name CFSID", null);
		        }

		        return new ResponseBean<>(result);
		    }

		    private boolean isWifiDefaultInstance(ClientServiceInstanceV1 instance) {
		        return "ACTIVE".equals(instance.getStatus()) &&
		                ("BTWIFI:DEFAULT".equals(instance.getServiceCode()) || "BTROPENZONE".equals(instance.getServiceCode()));
		    }

//		    private boolean isContentFilteringInstance(ClientServiceInstanceV1 instance) {
//		        return "CONTENTFILTERING:DEFAULT".equals(instance.getServiceCode()) &&
//		                "CFSID".equals(instance.getCharacteristics().getName());
//		    }
//
//		    private String getCfsidValue(ClientServiceInstanceV1 instance) {
//		        return instance.getCharacteristics().getValue();
//		    }
		    
		    private boolean isContentFilteringInstance(ClientServiceInstanceV1 instance) {
		        return "CONTENTFILTERING:DEFAULT".equals(instance.getServiceCode()) &&
		                hasCharacteristicWithName(instance.getCharacteristics(), "CFSID");
		    }

		    private String getCfsidValue(ClientServiceInstanceV1 instance) {
		        // Assuming you want to get the value of the first characteristic in the list
		        List<Characteristic> characteristics = instance.getCharacteristics();
		        if (!characteristics.isEmpty()) {
		            return characteristics.get(0).getValue();
		        } else {
		            return null;  // or handle the case where there are no characteristics
		        }
		    }

		    private boolean hasCharacteristicWithName(List<Characteristic> characteristics, String name) {
		        for (Characteristic characteristic : characteristics) {
		            if (name.equals(characteristic.getName())) {
		                return true;
		            }
		        }
		        return false;
		    }


}
