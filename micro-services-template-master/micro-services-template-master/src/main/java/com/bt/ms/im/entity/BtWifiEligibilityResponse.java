package com.bt.ms.im.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BtWifiEligibilityResponse {
	


		private String uuid;
		private String csfid;
		public String getUuid() {
			return uuid;
		}
		public void setUuid(String uuid) {
			this.uuid = uuid;
		}
		public String getCsfid() {
			return csfid;
		}
		public void setCsfid(String csfid) {
			this.csfid = csfid;
		}
		
		

}
