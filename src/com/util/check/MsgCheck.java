package com.util.check;

import java.util.Arrays;

import com.util.encrypt.SHA1;

public class MsgCheck {
	private static final String token = "wechat";
	public static  boolean checkSignature(String signature, String timestamp, String nonce){
		String[] arr = new String[]{token, timestamp, nonce};
		
		//排序
		Arrays.sort(arr);
		
		//生成字符串
		StringBuffer content = new StringBuffer();
		for(int i=0;i<arr.length;i++){
			content.append(arr[i]);
		}
		
		//sha1加密
		String temp = SHA1.SHA1Digest(content.toString());
		
		return temp.equals(signature);
	}
}
