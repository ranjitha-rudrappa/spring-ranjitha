package com.bt.ms.im.service;

import com.bt.ms.im.entity.GetRequest;
import com.bt.ms.im.entity.GetResponse;
import com.bt.ms.im.entity.ResponseBean;

public interface GetClientProfileService {
	public ResponseBean<GetResponse> getclientprofile(GetRequest request);
}
