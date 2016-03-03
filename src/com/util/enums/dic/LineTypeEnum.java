package com.util.enums.dic;

/**
 * 线路类型
 * @author Wymann
 * @Date 2014-9-3 下午02:50:53
 *
 */
public enum LineTypeEnum {
	BLANK("1","未分类"),			//未分类
	ELECTRIC("2","电气类"),		//电气类
	CIVIL("3","土建类");			//土建类
	
	private String value;
	private String name;
	private LineTypeEnum(String value,String name){
		this.value=value;
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	@Override
	public String toString(){
		return this.value;
	}
}
