package com.bt.ms.im.entity;

public class ServiceRole {
	private String roleCode;
    private String key;
    private String status;
    private ClientIdentity clientIdentity;
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
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
	public ClientIdentity getClientIdentity() {
		return clientIdentity;
	}
	public void setClientIdentity(ClientIdentity clientIdentity) {
		this.clientIdentity = clientIdentity;
	}
    
    

}
