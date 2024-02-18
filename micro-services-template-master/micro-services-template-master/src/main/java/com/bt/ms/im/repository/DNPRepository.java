package com.bt.ms.im.repository;

import com.bt.ms.im.entity.*;
import com.bt.ms.im.service.GetClientProfileV1Res;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DNPRepository {

    private static final String COMPARISON_UUID = "0ab297cc-b2b6-1033-9f36-9a1c1857c201";
    
    public ResponseBean<BtWifiEligibilityResponse> getClientProfile(GetRequest request) {
        // Your logic to call the external service (Dnp) and get the response
        // Make sure to handle exceptions and errors appropriately
        // You may use HTTP client, JDBC, or any other appropriate method here
        // For simplicity, assuming a mock response
        BtWifiEligibilityResponse mockResponse = new BtWifiEligibilityResponse();
        mockResponse.setUuid("mockedUuid");
        mockResponse.setCsfid("mockedCsfid");

        ResponseBean<BtWifiEligibilityResponse> responseBean = new ResponseBean<>();
        responseBean.setData(mockResponse);

        return responseBean;
    }

//    public ResponseBean<GetClientProfileV1Res> getClientProfile(GetRequest request) {
//        System.out.println("Request in dnp");
//        String requestUuid = extractUuidFromRequest(request);
//        System.out.println(requestUuid);
//
//        GetClientProfileV1Res clientProfile;
//
//        // Check if the extracted UUID matches the comparison UUID
//        if (COMPARISON_UUID.equals(requestUuid)) {
//            // If it matches, generate the sample response
//            clientProfile = generateSampleClientProfile();
//        } else {
//            // If it doesn't match, return a default or empty response
//            clientProfile = new GetClientProfileV1Res();
//        }
//
//        return ResponseBean.of(clientProfile);
//    }
//
//    private String extractUuidFromRequest(GetRequest request) {
//        // Implement your logic to extract the UUID from the request object
//        // For demonstration purposes, assuming the UUID is a property of the request
//        return request.getUuid();
//    }
//
//    private GetClientProfileV1Res generateSampleClientProfile() {
//        GetClientProfileV1Res clientProfile = new GetClientProfileV1Res();
//
//        // Set values for ClientProfileV1
//        List<Client> clients = new ArrayList<>();
//        clients.add(generateSampleClient());
//        clientProfile.setClients(clients);
//
//        // Set values for ClientServiceInstanceV1
//        List<ClientServiceInstanceV1> clientServiceInstances = new ArrayList<>();
//        clientServiceInstances.add(generateSampleClientServiceInstance());
//        clientProfile.setClientServiceInstances(clientServiceInstances);
//
//        // Additional values for other attributes...
//
//        return clientProfile;
//    }
//
//    private Client generateSampleClient() {
//        Client client = new Client();
//
//        // Set values for Client
//        client.setKey("1a4ca54d-4c89-103b-ba34-cd6c9af53e01");
//        client.setStatus("ACTIVE");
//
//        // Set values for ClientIdentity, ClientCredential, ContactDetails, Characteristic, etc.
//        ClientIdentity clientIdentity1 = new ClientIdentity();
//        clientIdentity1.setValue("btwifi_t10_active_cit@bt.com");
//        clientIdentity1.setDomain("BTCOM");
//
//        ClientCredential clientCredential1 = new ClientCredential();
//        clientCredential1.setType("SHA256_V1");
//        clientCredential1.setStatus("ACTIVE");
//        clientCredential1.setAuthenticationLevel(100);
//
//        clientIdentity1.setClientCredential(clientCredential1);
//
//        // Set values for other characteristics...
//
//        client.setClientIdentities(List.of(clientIdentity1));
//
//        // Set values for ContactDetails...
//        ContactDetails contactDetails = new ContactDetails();
//        contactDetails.setTitle("Mr");
//        contactDetails.setFirstName("TEST");
//        contactDetails.setLastName("BTWIFI");
//        contactDetails.setEmail("abhinav.chaudhary@bt.com");
//
//        client.setContactDetails(contactDetails);
//
//        // Set values for other attributes...
//
//        return client;
//    }
//
//    private ClientServiceInstanceV1 generateSampleClientServiceInstance() {
//        ClientServiceInstanceV1 clientServiceInstance = new ClientServiceInstanceV1();
//
//        // Set values for ClientServiceInstanceV1
//        clientServiceInstance.setServiceCode("BTWIFI:DEFAULT");
//        clientServiceInstance.setKey("1a4cc470-4c89-103b-99a0-a5b85ba73e01");
//        clientServiceInstance.setStatus("ACTIVE");
//
//        // Set values for other characteristics...
//
//        return clientServiceInstance;
//    }
}

