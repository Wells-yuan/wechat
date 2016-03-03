package com.util.enums.dic;

/**
 * 模块分类
 * @author Wymann
 * @Date 2014-5-4 下午10:10:10
 *
 */
public enum ModuleTypeEnum {
	/**
	 * 思想道德
	 */
	SXDD("SXDD","SXDD"),//詹
	
	/**
	 * 科技创新
	 */
	KJCX("KJCX","KJCX"),//吴
	
	/**
	 * 社会实践
	 */
	SHSJ("SHSJ","SHSJ"),//盛
	
	/**
	 * 科学文化素质
	 */
	KXWH("KXWH", "KXWH"),//陈
	
	/**
	 * 身体健康
	 */
	STSZ("STSZ", "STSZ");  //袁
	
	private String value,name;
	private ModuleTypeEnum(String value,String name){
		this.value=value;
		this.name=name;
	}
	@Override
	public String toString(){
		return this.value;
	}
	public String getName(){
		return this.name;
	}
}
