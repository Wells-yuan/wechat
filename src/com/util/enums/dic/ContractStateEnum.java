package com.util.enums.dic;

/**
 * 合同状态
 * @author Wymann
 * @Date 2014-5-5 下午08:24:50
 *
 */
public enum ContractStateEnum {
	INSERT("0"),		//等待会签
	SIGN("1"),			//会签
	EXECUTE("2"),		//执行
	STOP("3"),			//终止
	FINISH("4"),		//完结
	TALLY("5");			//流水
	
	private String value;
	private ContractStateEnum(String value){
		this.value=value;
	}
	@Override
	public String toString(){
		return this.value;
	}
}
