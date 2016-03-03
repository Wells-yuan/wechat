package com.wechat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BaseConst {
	//--------------------------------------------session常量-----------------------------------
	
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_NEWS = "news";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	
	public static final String USERSESSION="USERSESSION";
	
	
	public static final String HISTORYURL="historyUrl";		//历史路由
	
	/**
	 * 验证码到cookie
	 */
	public static final String authcode="authCode";
	
	/**
	 * 生成登陆认证cookie
	 */
	public static final String authmark="authmark";
	
	/**
	 * 用户名到cookie
	 */
	public static final String userName="userName";
	
	/**
	 * #IDEA加密秘钥
	 */
	public static final String securityKey = "ttJw6Oc4NEtwPf8CbmwLNQ==";//#IDEA加密秘钥
	
	/**
	 * #cookie最大时间 3600 * 24 * 15 = 12960000 秒 = 15 天
	 */
	public static final int maxAge=12960000;
	
	
	/**
	 * 公司简称
	 */
	public static final String SHORTNAME="三送公司";
	
	//-----------------AJAX请求返回参数---------------------------------------
	/**
	 * respone报错信息
	 */
	public static final int AJAX_999=999;
	
	/**
	 * 没有权限
	 */
	public static final int AJAX_998=998;
	

	
	/**
	 * 根据编码分解出年份
	 * @param contractCode
	 * @return
	 */
	public static String getYear(String contractCode){
		String[] str=contractCode.split("-");
		if(str.length>3){
			return str[2].toString();
		}
		return "";
	}
	
	public static void main(String[] args){
		String regEx="[a-zA-Z]*-[a-zA-Z]*-[0-9]*-";
		Pattern pat=Pattern.compile(regEx); 
		Matcher match=pat.matcher("SS-JJZB-2014-01");
		String s=match.replaceAll("");
		
	}
	
}
