package com.core.model;

/**
 * 错误信息
 * @author Wymann
 * @Date 2014-6-3 下午05:35:07
 *
 */
public class OutputMessage {

	private boolean state;	//状态
	private String message;	//说明
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
