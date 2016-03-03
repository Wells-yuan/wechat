package com.util.enums.dic;

/**
 * 归档状态
 * @author Wymann
 * @Date 2014-5-5 下午10:16:44
 *
 */
public enum ArchiveStateEnum {
	YET("1"),	//已存档
	NO("2");	//未存档
	
	private String value;
	private ArchiveStateEnum(String value){
		this.value=value;
	}
	@Override
	public String toString(){
		return this.value;
	}
	
}
