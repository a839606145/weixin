package com.example.demo.common;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class HttpUtils {

	public static String decodeMap(Map<String,Object> map){
		StringBuffer sb=new StringBuffer();
		if(map!=null && map.size()>0){
			Iterator<String> it=map.keySet().iterator();
			int number=1;
			while(it.hasNext()){
				String key=it.next();
				if(number!=1){
					sb.append("&"+key+"="+map.get(key));
				}else{
					sb.append("?"+key+"="+map.get(key));
				}
				number++;
			}
		}
		return sb.toString();
	}
	public static String postURL(String url,String charset){
		 HttpURLConnection connection=null;
		try {
			URL realUrl = new URL(url);
			connection = (HttpURLConnection) realUrl.openConnection();
			connection.setRequestMethod("POST");
			connection.connect();
			return IOUtils.getInputString(connection.getInputStream(), "UTF-8");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String postURL(String url,String charset,String content){
		 HttpURLConnection connection=null;
		try {
			URL realUrl = new URL(url);
			connection = (HttpURLConnection) realUrl.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式  
			connection.connect();  
            OutputStreamWriter out = new OutputStreamWriter(  
                    connection.getOutputStream(), "UTF-8"); // utf-8编码  
            out.append(content);  
            out.flush();  
            out.close();  
			return IOUtils.getInputString(connection.getInputStream(), "UTF-8");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String get(String urlLocation) {
        
        HttpURLConnection conn = null;
        try {
            URL url = new URL(urlLocation);
            conn = (HttpURLConnection)url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(false);
            conn.setUseCaches(false);
            conn.setRequestMethod("GET");
            conn.connect();
            
            return IOUtils.getInputString(conn.getInputStream(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }
    
}
