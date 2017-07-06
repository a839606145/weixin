package com.example.demo.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtils {

	public static String readFile(String fileName,String charset){
		BufferedReader read=null;
		String result="";
		try{
			read=new BufferedReader(new InputStreamReader(FileUtils.class.getResourceAsStream(fileName),charset));
			String line="";
			while((line=read.readLine())!=null){
				result+=line;
			}
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(read!=null){
				try {
					read.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
