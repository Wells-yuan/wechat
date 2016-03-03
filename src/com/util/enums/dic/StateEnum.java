package com.util.enums.dic;

/**
 * 是否启用
 * @author Wymann
 * @Date 2014-5-10 下午09:14:53
 *
 */
public enum StateEnum {
	INVALID("0"),	//已存档
	VALID("1");	//未存档
	
	private String value;
	private StateEnum(String value){
		this.value=value;
	}
	@Override
	public String toString(){
		return this.value;
	}
}
