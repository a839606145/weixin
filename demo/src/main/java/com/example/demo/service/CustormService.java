package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.common.Contant;
import com.example.demo.common.HttpUtils;
import com.example.demo.common.WeixinURL;

public class CustormService {
	
	 public String sendMessage(){
		 Map<String, Object> params = new HashMap<String, Object>();
         params.put("appid", Contant.appid);
         params.put("secret", Contant.secret);
         String url=WeixinURL.getToken+HttpUtils.decodeMap(params);
         return url;
	 }
}
