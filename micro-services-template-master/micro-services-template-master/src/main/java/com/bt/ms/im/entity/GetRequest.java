package com.bt.ms.im.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetRequest {
	
		private String trackingHeader;
		private String uuid;
		private String consumeridref;
		public String getTrackingHeader() {
			return trackingHeader;
		}
		public void setTrackingHeader(String trackingHeader) {
			this.trackingHeader = trackingHeader;
		}
		public String getUuid() {
			return uuid;
		}
		public void setUuid(String uuid) {
			this.uuid = uuid;
		}
		public String getConsumeridref() {
			return consumeridref;
		}
		public void setConsumeridref(String consumeridref) {
			this.consumeridref = consumeridref;
		}
		
		

}
