package com.nurds.fastfillco;

public class Response {

	private String responseCode;
	
	private String error;
	
	private ResponseObject resObject;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public ResponseObject getObject() {
		return resObject;
	}

	public void setObject(ResponseObject object) {
		this.resObject = object;
	}
	
	
}
