package com.example.demo.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class AccessTokenResult {
	@JSONField(name="access_token")
	private String token;
	@JSONField(name="expires_in")
	private Long time;
	private Date date;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
