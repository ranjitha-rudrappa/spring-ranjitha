package com.bt.ms.im.entity;

import java.util.List;

//import lombok.Getter;
//import lombok.Setter;


public class Client {
	private List<ClientIdentity> clientIdentities;
    private String key;
    private String status;
    private ContactDetails contactDetails;
    private String organisation;
    private Characteristic characteristics;
	public List<ClientIdentity> getClientIdentities() {
		return clientIdentities;
	}
	public void setClientIdentities(List<ClientIdentity> clientIdentities) {
		this.clientIdentities = clientIdentities;
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
	public ContactDetails getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public Characteristic getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(Characteristic characteristic) {
		this.characteristics = characteristic;
	}

    

}
