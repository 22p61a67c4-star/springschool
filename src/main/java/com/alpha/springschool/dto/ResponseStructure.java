package com.alpha.springschool.dto;

public class ResponseStructure<T> {
	private int statusCode;
	private String Message;
	private T data;
	public ResponseStructure(int statusCode, String message, T data) {
		super();
		this.statusCode = statusCode;
		Message = message;
		this.data = data;
	}
	public ResponseStructure() {
		super();
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
