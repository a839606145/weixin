package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.Contant;
import com.example.demo.common.FileUtils;
import com.example.demo.common.HttpUtils;
import com.example.demo.common.WeixinURL;

public class MenuService {
	public String creaetMenu(){
		 Map<String, Object> params = new HashMap<String, Object>();
        params.put("access_token",Contant.token);
        String url=WeixinURL.menuCreate+HttpUtils.decodeMap(params);
        String menus=FileUtils.readFile("/menu.json","UTF-8");
        JSONObject json=JSONObject.parseObject(menus);
        String result=HttpUtils.postURL(url,"UTF-8",json.toString());
        return result;
	}
	public static void main(String args[]){
		System.out.println(new MenuService().creaetMenu());
	}
}
