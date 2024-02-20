package com.bt.ms.im.service;
import com.bt.ms.im.entity.GetRequest;
import com.bt.ms.im.entity.ResponseBean;
import com.bt.ms.im.entity.ServiceIdentity;
import com.bt.ms.im.entity.ServiceRole;
import com.bt.ms.im.entity.BtWifiEligibilityResponse;
import com.bt.ms.im.entity.Characteristic;
import com.bt.ms.im.entity.Client;
import com.bt.ms.im.entity.ClientCredential;
import com.bt.ms.im.entity.ClientIdentity;
import com.bt.ms.im.entity.ClientProfileV1;
import com.bt.ms.im.entity.ClientServiceInstanceV1;
import com.bt.ms.im.entity.ContactDetails;
import com.bt.ms.im.mapper.BtWifiEligibilityMapper;
import com.bt.ms.im.repository.DNPRepository;
import com.bt.ms.im.repository.DataRepository;
import com.bt.ms.im.config.AppConstants;
import com.bt.ms.im.service.GetClientProfileServiceImpl;
import com.bt.ms.im.service.GetClientProfileV1Res;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class GetClientProfileServiceTest {

    @Mock
    private AppConstants appConstants;

    @Mock
    private DNPRepository dnpRepository;

    @Mock
    private DataRepository dataRepository;

    @Mock
    private BtWifiEligibilityMapper responseMapper;

   @InjectMocks
    private GetClientProfileServiceImpl clientProfileService;
    
  

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testGetClientProfile() {
    	String apigwTrackingHeader = "96bb97fa-b941-46bb-8c4e-86c616c28a13";
		String xProfileGuid = "0ab297cc-b2b6-1033-9f36-9a1c1857c201";
		String xConsumerDigitalIdRef = "0ab7cc-b2b6-1033-9f36-9a1c1857c271";

		GetRequest getRequest = new GetRequest();
		getRequest.setTrackingHeader(apigwTrackingHeader);
		getRequest.setUuid(xProfileGuid);
		getRequest.setConsumeridref(xConsumerDigitalIdRef);
        

        GetClientProfileV1Res mockedData = createMockedClientProfileData();

        
        ResponseBean<GetClientProfileV1Res> mockDnpResponse = new ResponseBean<>(mockedData);

        BtWifiEligibilityResponse mockFinalResponse = new BtWifiEligibilityResponse("1a4cc470-4c89-103b-99a0-a5b85ba73e01", "SOME_VALUE");

       
        when(dnpRepository.
        		getClientProfile(getRequest))
        .thenReturn(mockDnpResponse);
        when(responseMapper.mapValues(any())).thenReturn(mockFinalResponse);

        ResponseBean<BtWifiEligibilityResponse> result = clientProfileService.getclientprofile(getRequest);

       
        assertEquals(mockFinalResponse, result.getData());
       
    }

    
    private GetClientProfileV1Res createMockedClientProfileData() {
        GetClientProfileV1Res mockedData = new GetClientProfileV1Res();

        // Set clients
        List<Client> clients = Arrays.asList(createMockedClient());
        mockedData.setClients(clients);

        // Set client service instances
        List<ClientServiceInstanceV1> clientServiceInstances = Arrays.asList(
                createMockedClientServiceInstance("BTWIFI:DEFAULT"),
                createMockedClientServiceInstance("CONTENTFILTERING:DEFAULT")
        );
        mockedData.setClientServiceInstances(clientServiceInstances);

        // Set client profile
        ClientProfileV1 clientProfileV1 = createMockedClientProfile();
        mockedData.setClientProfileV1(clientProfileV1);

        return mockedData;
    }

    private Client createMockedClient() {
        Client client = new Client();
        client.setClientIdentities(Arrays.asList(createMockedClientIdentities()));
        client.setKey("1a4ca54d-4c89-103b-ba34-cd6c9af53e01");
        client.setStatus("ACTIVE");

        // Set contact details
        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setTitle("Mr");
        contactDetails.setFirstName("TEST");
        contactDetails.setLastName("BTWIFI");
        contactDetails.setEmail("abhinav.chaudhary@bt.com");
        client.setContactDetails(contactDetails);

        // Set organization
        client.setOrganisation("BTRetailConsumer");

        // Set characteristics
        Characteristic characteristics = new Characteristic();
        characteristics.setName("SOME_CHARACTERISTIC");
        characteristics.setValue("SOME_VALUE");
        client.setCharacteristics(characteristics);

        return client;
    }

    private ClientIdentity createMockedClientIdentities() {
        ClientIdentity clientIdentities = new ClientIdentity();
        clientIdentities.setValue("btwifi_t10_active_cit@bt.com");
        clientIdentities.setDomain("BTCOM");
        clientIdentities.setStatus("ACTIVE");

        // Set client credential
        ClientCredential clientCredential = new ClientCredential();
        clientCredential.setType("SHA256_V1");
        clientCredential.setStatus("ACTIVE");
        clientCredential.setAuthenticationLevel(100);
        clientIdentities.setClientCredential(clientCredential);

        return clientIdentities;
    }

    private ClientServiceInstanceV1 createMockedClientServiceInstance(String serviceCode) {
        ClientServiceInstanceV1 clientServiceInstance = new ClientServiceInstanceV1();
        clientServiceInstance.setServiceCode(serviceCode);
        clientServiceInstance.setKey("1a4cc470-4c89-103b-99a0-a5b85ba73e01");
        clientServiceInstance.setStatus("ACTIVE");

        // Set characteristics
        Characteristic characteristics = new Characteristic();
        characteristics.setName("CFSID");
        characteristics.setValue("SOME_VALUE");
        clientServiceInstance.setCharacteristics(characteristics);

        // Set service roles
        ServiceRole serviceRoles = new ServiceRole();
        serviceRoles.setRoleCode("ADMIN");
        serviceRoles.setKey("EE0EB50C32143F60E0534752320AA2C2");
        serviceRoles.setStatus("ACTIVE");

        // Set client identity for service roles
        ClientIdentity clientIdentity = new ClientIdentity();
        clientIdentity.setValue("020297527676");
        clientIdentity.setDomain("VAS_BILLINGACCOUNT_ID");
        clientIdentity.setStatus("ACTIVE");
        serviceRoles.setClientIdentity(clientIdentity);

        clientServiceInstance.setServiceRoles(serviceRoles);

        // Set service identity
        ServiceIdentity serviceIdentity = new ServiceIdentity();
        serviceIdentity.setValue("020297527676");
        serviceIdentity.setDomain("VAS_BILLINGACCOUNT_ID");
        clientServiceInstance.setServiceIdentity(serviceIdentity);

        return clientServiceInstance;
    }

    private ClientProfileV1 createMockedClientProfile() {
        ClientProfileV1 clientProfileV1 = new ClientProfileV1();
        // Set client profile properties based on the JSON data
        return clientProfileV1;
    }

}


