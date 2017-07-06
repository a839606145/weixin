package com.example.demo.service;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.common.WeixinTemplate;
import com.example.demo.common.Xml2String;
@Service("messageService")
public class MessageService {
	public String sendMessage(Map<String, String> map) throws Exception{
		 System.out.println(map.get("Content"));
		WeixinTemplate tem=new WeixinTemplate();
		tem.setContent("hello");
		tem.setCreateTime(new Date().getTime());
		tem.setFromUserName(map.get("ToUserName").toString());
		tem.setToUserName(map.get("FromUserName").toString());
		tem.setMsgType("text");
		String result=Xml2String.textMessageToXml(tem);
		return result;
	}
	public String receiveMessage(Map<String, String> map){
		  System.out.println(map.get("Content"));
		  return null;
	}
}
