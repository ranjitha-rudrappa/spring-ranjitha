package com.bt.ms.im.service;
 
import java.util.List;
 
import com.bt.ms.im.entity.Client;
import com.bt.ms.im.entity.ClientServiceInstanceV1;
 
public class GetClientProfileV1Res {
    private Data data;
    private String status;
    private boolean failed;
    private boolean success;
    private boolean partialFail;
 
    // Constructors, getters, and setters
 
    public Data getData() {
        return data;
    }
 
    public void setData(Data data) {
        this.data = data;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
    public boolean isFailed() {
        return failed;
    }
 
    public void setFailed(boolean failed) {
        this.failed = failed;
    }
 
    public boolean isSuccess() {
        return success;
    }
 
    public void setSuccess(boolean success) {
        this.success = success;
    }
 
    public boolean isPartialFail() {
        return partialFail;
    }
 
    public void setPartialFail(boolean partialFail) {
        this.partialFail = partialFail;
    }
 
    // Inner class representing the "data" field
    public static class Data {
        private List<Client> clients;
        private List<ClientServiceInstanceV1> clientServiceInstances;
        private ClientServiceInstanceV1 clientServiceInstance;
 
        // Constructors, getters, and setters
 
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
 
	

        
    }

	
}

