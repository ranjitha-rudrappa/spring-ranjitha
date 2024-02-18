package com.bt.ms.im.entity;

import java.util.List;

public class ClientProfileV1 {
	
	    private List<Client> clients;
	    private List<ClientServiceInstanceV1> clientServiceInstances;
		public List<Client> getClients() {
			return clients;
		}
		public void setClients(List<Client> clients) {
			this.clients = clients;
		}
		public List<ClientServiceInstanceV1> getClientServiceInstancesV1() {
			return clientServiceInstances;
		}
		public void setClientServiceInstances(List<ClientServiceInstanceV1> clientServiceInstances) {
			this.clientServiceInstances = clientServiceInstances;
		}
	    
	    

}
