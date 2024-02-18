package com.bt.ms.im.entity;

import java.util.List;

public class ClientServiceInstanceV1 {
	 private String serviceCode;
	    private String key;
	    private String status;
	    private List<Characteristic> characteristics;
	    private List<ServiceRole> serviceRoles;
	    private ServiceIdentity serviceIdentity;
		public String getServiceCode() {
			return serviceCode;
		}
		public void setServiceCode(String serviceCode) {
			this.serviceCode = serviceCode;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public List<Characteristic> getCharacteristics() {
			return characteristics;
		}
		public void setCharacteristics(List<Characteristic> characteristics) {
			this.characteristics = characteristics;
		}
		public List<ServiceRole> getServiceRoles() {
			return serviceRoles;
		}
		public void setServiceRoles(List<ServiceRole> serviceRoles) {
			this.serviceRoles = serviceRoles;
		}
		public ServiceIdentity getServiceIdentity() {
			return serviceIdentity;
		}
		public void setServiceIdentity(ServiceIdentity serviceIdentity) {
			this.serviceIdentity = serviceIdentity;
		}
	    
	    

}
