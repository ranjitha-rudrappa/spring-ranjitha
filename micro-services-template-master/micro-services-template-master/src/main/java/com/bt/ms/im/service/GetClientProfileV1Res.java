package com.bt.ms.im.service;

import java.util.List;

import com.bt.ms.im.entity.Client;
import com.bt.ms.im.entity.ClientProfileV1;
import com.bt.ms.im.entity.ClientServiceInstanceV1;


public class GetClientProfileV1Res {

    private List<Client> clients;
    private List<ClientServiceInstanceV1> clientServiceInstances;
    private ClientProfileV1 clientProfileV1; // Add the ClientProfileV1 object

    // Constructors, getters, and setters

    public GetClientProfileV1Res() {
		// TODO Auto-generated constructor stub
    	
	}
    public GetClientProfileV1Res(String mockdata) {
		// TODO Auto-generated constructor stub
    	
	}

	public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<ClientServiceInstanceV1> getClientServiceInstances() {
        return clientServiceInstances;
    }

    public void setClientServiceInstances(List<ClientServiceInstanceV1> clientServiceInstances) {
        this.clientServiceInstances = clientServiceInstances;
    }

    public ClientProfileV1 getClientProfileV1() {
        return clientProfileV1;
    }

    public void setClientProfileV1(ClientProfileV1 clientProfileV1) {
        this.clientProfileV1 = clientProfileV1;
    }

    // Add any additional attributes, getters, and setters as needed
}


