package com.bt.ms.im.mapper;


import com.bt.ms.im.entity.BtWifiEligibilityResponse;
import com.bt.ms.im.entity.Characteristic;
import com.bt.ms.im.entity.ClientServiceInstanceV1;
import com.bt.ms.im.exception.handler.standardexception.ForbiddenException;
import com.bt.ms.im.service.GetClientProfileV1Res;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class BtWifiMapperTest {

    @Mock
    private GetClientProfileV1Res response;

    @InjectMocks
    private BtWifiEligibilityMapper btWifiEligibilityMapper;
    
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}


	@Test
	void mapValues_Success() {
	    List<ClientServiceInstanceV1> clientServiceInstances = new ArrayList<>();
	    clientServiceInstances.add(createClientServiceInstance("BTWIFI:DEFAULT", "1a4cc470-4c89-103b-99a0-a5b85ba73e01", "ACTIVE", "CFSID", "SOME_VALUE"));
	    clientServiceInstances.add(createClientServiceInstance("CONTENTFILTERING:DEFAULT", "1a4cc470-4c89-103b-99a0-a5b85ba73e01", "ACTIVE", "CFSID", "SOME_VALUE")); 

	    
	    GetClientProfileV1Res.Data data = new GetClientProfileV1Res.Data();
	    data.setClientServiceInstances(clientServiceInstances);

	  
	    when(response.getData()).thenReturn(data);

	   
	    BtWifiEligibilityResponse result = btWifiEligibilityMapper.mapValues(response);

	   
	    assertEquals("1a4cc470-4c89-103b-99a0-a5b85ba73e01", result.getUuid());
	    assertEquals("SOME_VALUE", result.getCsfid());
	}


	@Test
	void mapValues_ForbiddenException() {
	    
	    ClientServiceInstanceV1 forbiddenInstance = createClientServiceInstance("BTWIFI:DEFAULT", "other-key", "INACTIVE", "CFSID", "SOME_VALUE");

	    List<ClientServiceInstanceV1> clientServiceInstances = new ArrayList<>();
	    clientServiceInstances.add(forbiddenInstance);

	    
	    GetClientProfileV1Res.Data data = new GetClientProfileV1Res.Data();
	    data.setClientServiceInstances(clientServiceInstances);

	  
	    when(response.getData()).thenReturn(data);

	    
	    assertThrows(ForbiddenException.class, () -> btWifiEligibilityMapper.mapValues(response));
	}



    private ClientServiceInstanceV1 createClientServiceInstance(String serviceCode, String key, String status, String characteristicName, String characteristicValue) {
        ClientServiceInstanceV1 clientServiceInstance = new ClientServiceInstanceV1();
        clientServiceInstance.setServiceCode(serviceCode);
        clientServiceInstance.setKey(key);
        clientServiceInstance.setStatus(status);

       
        Characteristic characteristics = new Characteristic();
        characteristics.setName(characteristicName);
        characteristics.setValue(characteristicValue);
        clientServiceInstance.setCharacteristics(characteristics);

        return clientServiceInstance;
    }

}
