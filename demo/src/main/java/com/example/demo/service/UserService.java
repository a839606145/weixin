package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.common.Contant;
import com.example.demo.common.HttpUtils;
import com.example.demo.common.WeixinURL;

public class UserService {

	public String getUserList(){
		 Map<String, Object> params = new HashMap<String, Object>();
         params.put("access_token",Contant.token);
         String url=WeixinURL.userGet+HttpUtils.decodeMap(params);
         String result=HttpUtils.get(url);
         return result;
	}
	public static void main(String args[]){
		System.out.println(new UserService().getUserList());
	}
}
