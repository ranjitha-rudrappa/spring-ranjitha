package com.bt.ms.im.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Entity
public class GetResponse {
    
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uuid;
	private String cfsid;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getCfsid() {
		return cfsid;
	}
	public void setCsfid(String csfid) {
		this.cfsid = csfid;
	}
	public GetResponse() {
		super();
		
	}
	
}
