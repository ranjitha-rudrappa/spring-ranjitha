package com.bt.ms.im.repository;

import com.bt.ms.im.entity.*;
import com.bt.ms.im.exception.handler.standardexception.ResourceNotFoundException;
import com.bt.ms.im.service.GetClientProfileV1Res;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DNPRepository {   

    @Autowired
    private DataRepository  dataRepository ;
    

    public ResponseBean<GetClientProfileV1Res> getClientProfile(GetRequest request) {
    	 if (request.getUuid() != null || dataRepository.existsByUuid(request.getUuid())) {
          
             GetClientProfileV1Res clientProfile = generateSampleClientProfile();
           return ResponseBean.of(clientProfile);
        }

      
        if (request.getConsumeridref() != null ||  dataRepository.existsByCfsid(request.getConsumeridref())) {
           
            GetClientProfileV1Res clientProfile = generateSampleClientProfile();
            return ResponseBean.of(clientProfile);
        }
     else{
        
         throw new ResourceNotFoundException("404", "Not Found");
    }
     }
        
//    	 if (request.getUuid() != null || request.getConsumeridref() != null ) {
//    	boolean b = dataRepository.existsByUuid(request.getUuid());
//    	System.out.println("it is in " +b);
//       GetClientProfileV1Res clientProfile = generateSampleClientProfile();
//
//        return ResponseBean.of(clientProfile);}
//    	 else {
//    	 throw new ResourceNotFoundException("404", "Not Found");}
//    }




    private GetClientProfileV1Res generateSampleClientProfile() {
        GetClientProfileV1Res clientProfile = new GetClientProfileV1Res();

    
        List<Client> clients = new ArrayList<>();
        clients.add(generateSampleClient());
        clientProfile.setClients(clients);

       
        List<ClientServiceInstanceV1> clientServiceInstances = new ArrayList<>();
        clientServiceInstances.add(generateSampleClientServiceInstance());
        clientServiceInstances.add(generateSampleClientServiceInstancev1());
        clientProfile.setClientServiceInstances(clientServiceInstances);
        


        return clientProfile;
    }
    
 
    private Client generateSampleClient() {
        Client client = new Client();

        
        client.setKey("1a4ca54d-4c89-103b-ba34-cd6c9af53e01");
        client.setStatus("ACTIVE");

       
        ClientIdentity clientIdentity1 = new ClientIdentity();
        clientIdentity1.setValue("btwifi_t10_active_cit@bt.com");
        clientIdentity1.setDomain("BTCOM");
        clientIdentity1.setStatus("ACTIVE");

        ClientCredential clientCredential1 = new ClientCredential();
        clientCredential1.setType("SHA256_V1");
        clientCredential1.setStatus("ACTIVE");
        clientCredential1.setAuthenticationLevel(100);

        clientIdentity1.setClientCredential(clientCredential1);

    

        client.setClientIdentities(List.of(clientIdentity1));

     
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

       
        client.setCharacteristics(characteristic);



        return client;
    }

    private ClientServiceInstanceV1 generateSampleClientServiceInstance() {
        ClientServiceInstanceV1 clientServiceInstance = new ClientServiceInstanceV1();

        
        clientServiceInstance.setServiceCode("BTWIFI:DEFAULT");
        clientServiceInstance.setKey("1a4cc470-4c89-103b-99a0-a5b85ba73e01");
        clientServiceInstance.setStatus("ACTIVE");



        
        Characteristic characteristic = new Characteristic();
        characteristic.setName("CFSID");
        characteristic.setValue("SOME_VALUE");
        clientServiceInstance.setCharacteristics(characteristic);

        
        ServiceRole serviceRole = new ServiceRole();
        serviceRole.setRoleCode("ADMIN");
        serviceRole.setKey("EE0EB50C32143F60E0534752320AA2C2");
        serviceRole.setStatus("ACTIVE");

        
        ClientIdentity clientIdentityForServiceRole = new ClientIdentity();
        clientIdentityForServiceRole.setValue("020297527676");
        clientIdentityForServiceRole.setDomain("VAS_BILLINGACCOUNT_ID");
        clientIdentityForServiceRole.setStatus("ACTIVE");

        serviceRole.setClientIdentity(clientIdentityForServiceRole);

       
        clientServiceInstance.setServiceRoles(serviceRole);

       
        ServiceIdentity serviceIdentity = new ServiceIdentity();
        serviceIdentity.setValue("020297527676");
        serviceIdentity.setDomain("VAS_BILLINGACCOUNT_ID");

        
        clientServiceInstance.setServiceIdentity(serviceIdentity);

        return clientServiceInstance;
    }
    private ClientServiceInstanceV1 generateSampleClientServiceInstancev1() {
        ClientServiceInstanceV1 clientServiceInstance = new ClientServiceInstanceV1();

       
        clientServiceInstance.setServiceCode("CONTENTFILTERING:DEFAULT");
        clientServiceInstance.setKey("1a4cc470-4c89-103b-99a0-a5b85ba73e01");
        clientServiceInstance.setStatus("ACTIVE");

    
        Characteristic characteristic = new Characteristic();
        characteristic.setName("CFSID");
        characteristic.setValue("SOME_VALUE");
        clientServiceInstance.setCharacteristics(characteristic);

       
        ServiceRole serviceRole = new ServiceRole();
        serviceRole.setRoleCode("ADMIN");
        serviceRole.setKey("EE0EB50C32143F60E0534752320AA2C2");
        serviceRole.setStatus("ACTIVE");

        
        ClientIdentity clientIdentityForServiceRole = new ClientIdentity();
        clientIdentityForServiceRole.setValue("020297527676");
        clientIdentityForServiceRole.setDomain("VAS_BILLINGACCOUNT_ID");
        clientIdentityForServiceRole.setStatus("ACTIVE");

        serviceRole.setClientIdentity(clientIdentityForServiceRole);

       
        clientServiceInstance.setServiceRoles(serviceRole);

      
        ServiceIdentity serviceIdentity = new ServiceIdentity();
        serviceIdentity.setValue("020297527676");
        serviceIdentity.setDomain("VAS_BILLINGACCOUNT_ID");

    
        clientServiceInstance.setServiceIdentity(serviceIdentity);

        return clientServiceInstance;
    }


}

