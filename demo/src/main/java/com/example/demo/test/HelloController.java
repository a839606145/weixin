package com.example.demo.test;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.Xml2String;
import com.example.demo.service.CheckService;
import com.example.demo.service.MessageService;
@EnableAutoConfiguration 
@RestController 
@RequestMapping("/hello")
public class HelloController {
	@Autowired
	private CheckService checkService;
	@Autowired
	private MessageService messageService;

	@RequestMapping("/hello")
	public void hello(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map map=Xml2String.xmlToMap(request);
		String method=request.getMethod();
		String result=null;
		if(method.equals("GET")){
			result=checkService.loginCheck(map);
		}else{
			result=messageService.sendMessage(map);
		}
		System.out.println(result);
		if(result!=null){
			PrintWriter out=response.getWriter();
			out.write(result);
			out.close();
			out=null;
		}
	}

	
}
