package com.example.demo.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.common.SignUtil;

@Service("checkService")
public class CheckService {
	public String loginCheck(Map<String, String> map) throws IOException {
		// 微信加密签名
        String signature = map.get("signature");
        // 时间戳
        String timestamp = map.get("timestamp");
        // 随机数
        String nonce = map.get("nonce");
        // 随机字符串
        String echostr = map.get("echostr");
        
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
           return echostr;
        }
        return null;
	}
}
