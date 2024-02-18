package com.bt.ms.im.entity;

public class ClientIdentity {
	 private String value;
	    private String domain;
	    private String status;
	    private ClientCredential clientCredential;
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getDomain() {
			return domain;
		}
		public void setDomain(String domain) {
			this.domain = domain;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public ClientCredential getClientCredential() {
			return clientCredential;
		}
		public void setClientCredential(ClientCredential clientCredential) {
			this.clientCredential = clientCredential;
		}
	    
	    


}
