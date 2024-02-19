package com.bt.ms.im.repository;

import com.bt.ms.im.entity.*;
import com.bt.ms.im.service.GetClientProfileV1Res;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DNPRepository {   

    public ResponseBean<GetClientProfileV1Res> getClientProfile(GetRequest request) {
        
        GetClientProfileV1Res clientProfile = generateSampleClientProfile();

        return ResponseBean.of(clientProfile);
    }



    private GetClientProfileV1Res generateSampleClientProfile() {
        GetClientProfileV1Res clientProfile = new GetClientProfileV1Res();

        // Set values for ClientProfileV1
        List<Client> clients = new ArrayList<>();
        clients.add(generateSampleClient());
        clientProfile.setClients(clients);

        // Set values for ClientServiceInstanceV1
        List<ClientServiceInstanceV1> clientServiceInstances = new ArrayList<>();
        clientServiceInstances.add(generateSampleClientServiceInstance());
        clientServiceInstances.add(generateSampleClientServiceInstancev1());
        clientProfile.setClientServiceInstances(clientServiceInstances);
        

        // Additional values for other attributes...

        return clientProfile;
    }
    
 
    private Client generateSampleClient() {
        Client client = new Client();

        // Set values for Client
        client.setKey("1a4ca54d-4c89-103b-ba34-cd6c9af53e01");
        client.setStatus("ACTIVE");

        // Set values for ClientIdentity, ClientCredential, ContactDetails, Characteristic, etc.
        ClientIdentity clientIdentity1 = new ClientIdentity();
        clientIdentity1.setValue("btwifi_t10_active_cit@bt.com");
        clientIdentity1.setDomain("BTCOM");
        clientIdentity1.setStatus("ACTIVE");

        ClientCredential clientCredential1 = new ClientCredential();
        clientCredential1.setType("SHA256_V1");
        clientCredential1.setStatus("ACTIVE");
        clientCredential1.setAuthenticationLevel(100);

        clientIdentity1.setClientCredential(clientCredential1);

        // Set values for other characteristics...

        client.setClientIdentities(List.of(clientIdentity1));

        // Set values for ContactDetails...
        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setTitle("Mr");
        contactDetails.setFirstName("TEST");
        contactDetails.setLastName("BTWIFI");
        contactDetails.setEmail("abhinav.chaudhary@bt.com");

        client.setContactDetails(contactDetails);
        
        client.setOrganisation("BTRetailConsumer");
        
        Characteristic characteristic = new Characteristic();
        characteristic.setName("SOME_CHARACTERISTIC");
        characteristic.setValue("SOME_VALUE");

        // Add Characteristic to the Client
        client.setCharacteristics(characteristic);

        // Set values for other attributes...

        return client;
    }

    private ClientServiceInstanceV1 generateSampleClientServiceInstance() {
        ClientServiceInstanceV1 clientServiceInstance = new ClientServiceInstanceV1();

        // Set values for ClientServiceInstanceV1
        clientServiceInstance.setServiceCode("BTWIFI:DEFAULT");
        clientServiceInstance.setKey("1a4cc470-4c89-103b-99a0-a5b85ba73e01");
        clientServiceInstance.setStatus("ACTIVE");

        // Set values for other characteristics...

        // Add Characteristic to the ClientServiceInstanceV1
        Characteristic characteristic = new Characteristic();
        characteristic.setName("CFSID");
        characteristic.setValue("SOME_VALUE");
        clientServiceInstance.setCharacteristics(characteristic);

        // Set values for ServiceRole
        ServiceRole serviceRole = new ServiceRole();
        serviceRole.setRoleCode("ADMIN");
        serviceRole.setKey("EE0EB50C32143F60E0534752320AA2C2");
        serviceRole.setStatus("ACTIVE");

        // Set values for ClientIdentity within ServiceRole
        ClientIdentity clientIdentityForServiceRole = new ClientIdentity();
        clientIdentityForServiceRole.setValue("020297527676");
        clientIdentityForServiceRole.setDomain("VAS_BILLINGACCOUNT_ID");
        clientIdentityForServiceRole.setStatus("ACTIVE");

        serviceRole.setClientIdentity(clientIdentityForServiceRole);

        // Add ServiceRole to the ClientServiceInstanceV1
        clientServiceInstance.setServiceRoles(serviceRole);

        // Set values for ServiceIdentity
        ServiceIdentity serviceIdentity = new ServiceIdentity();
        serviceIdentity.setValue("020297527676");
        serviceIdentity.setDomain("VAS_BILLINGACCOUNT_ID");

        // Add ServiceIdentity to the ClientServiceInstanceV1
        clientServiceInstance.setServiceIdentity(serviceIdentity);

        return clientServiceInstance;
    }
    private ClientServiceInstanceV1 generateSampleClientServiceInstancev1() {
        ClientServiceInstanceV1 clientServiceInstance = new ClientServiceInstanceV1();

        // Set values for ClientServiceInstanceV1
        clientServiceInstance.setServiceCode("CONTENTFILTERING:DEFAULT");
        clientServiceInstance.setKey("1a4cc470-4c89-103b-99a0-a5b85ba73e01");
        clientServiceInstance.setStatus("ACTIVE");

        // Set values for other characteristics...

        // Add Characteristic to the ClientServiceInstanceV1
        Characteristic characteristic = new Characteristic();
        characteristic.setName("CFSID");
        characteristic.setValue("SOME_VALUE");
        clientServiceInstance.setCharacteristics(characteristic);

        // Set values for ServiceRole
        ServiceRole serviceRole = new ServiceRole();
        serviceRole.setRoleCode("ADMIN");
        serviceRole.setKey("EE0EB50C32143F60E0534752320AA2C2");
        serviceRole.setStatus("ACTIVE");

        // Set values for ClientIdentity within ServiceRole
        ClientIdentity clientIdentityForServiceRole = new ClientIdentity();
        clientIdentityForServiceRole.setValue("020297527676");
        clientIdentityForServiceRole.setDomain("VAS_BILLINGACCOUNT_ID");
        clientIdentityForServiceRole.setStatus("ACTIVE");

        serviceRole.setClientIdentity(clientIdentityForServiceRole);

        // Add ServiceRole to the ClientServiceInstanceV1
        clientServiceInstance.setServiceRoles(serviceRole);

        // Set values for ServiceIdentity
        ServiceIdentity serviceIdentity = new ServiceIdentity();
        serviceIdentity.setValue("020297527676");
        serviceIdentity.setDomain("VAS_BILLINGACCOUNT_ID");

        // Add ServiceIdentity to the ClientServiceInstanceV1
        clientServiceInstance.setServiceIdentity(serviceIdentity);

        return clientServiceInstance;
    }


}

