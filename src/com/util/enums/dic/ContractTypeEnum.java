package com.util.enums.dic;

/**
 * 合同分类
 * @author Wymann
 * @Date 2014-5-6 下午04:11:10
 *
 */
public enum ContractTypeEnum {
	ZBHT("1"),		//总包合同
	JQFB("2"),		//基切分包
	RWS("3"),		//基切任务书
	NZHT("4"),		//内招分包
	LWHT("5"),		//劳务合同
	TSHT("6"),		//特殊合同
	QTHT("7"),		//其他合同
	QTLX("8"),		//其他类型合同
	FBHT("9");		//分包合同
	
	private String value;
	private ContractTypeEnum(String value){
		this.value=value;
	}
	@Override
	public String toString(){
		return this.value;
	}
}
