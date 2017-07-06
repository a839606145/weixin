package com.example.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.example.demo.common.Contant;
import com.example.demo.common.HttpUtils;
import com.example.demo.common.WeixinURL;
import com.example.demo.pojo.AccessTokenResult;
@Service("accessTokenService")
public class AccessTokenService {

	private AccessTokenResult token;
	
	public String getToken(){
		if(token==null || (token.getTime()+token.getDate().getTime()-300)<System.currentTimeMillis()){
			  Map<String, Object> params = new HashMap<String, Object>();
			  params.put("grant_type", "client_credential");
              params.put("appid", Contant.appid);
              params.put("secret", Contant.secret);
              String url=WeixinURL.getToken+HttpUtils.decodeMap(params);
              String result=HttpUtils.get(url);
              if(result.contains("errcode")){//错误
            	  System.out.println(result);
              }else{
            	  token= JSON.parseObject(result, AccessTokenResult.class);
            	  token.setDate(new Date());
              }
		}
		return token.getToken();
	}
	
	public static void main(String args[]){
		System.out.println(new AccessTokenService().getToken());
	}
}
