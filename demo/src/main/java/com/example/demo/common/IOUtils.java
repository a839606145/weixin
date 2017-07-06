package com.example.demo.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOUtils {

	public static void close(InputStream is){
		try {
			if(is!=null){
				is.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getInputString(InputStream is,String charset){
		BufferedReader in=null;
        String line;
        String result="";
        try {
        	 in = new BufferedReader(new InputStreamReader(
                     is,charset));//防止乱码
			while ((line = in.readLine()) != null) {
			    result += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
				try {
					if(in!=null){
						in.close();
					}
					close(is);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
       return result;
	}
}
