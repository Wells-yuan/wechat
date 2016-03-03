package com.core.action;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.util.tools.ToolString;
import com.wechat.BaseConst;


/**
 * Controller父类
 *
 * @version 1.0,2013-8-28
 * @author Wymann
 */
public class BaseAction implements Serializable{

	private static final long serialVersionUID = -8729137965180254125L;
	
	/**
	 * 错误页面
	 */
	protected String ERROR="error/404";
	
	protected String CODE="admin/code/";
	/**
	 * 身体素质
	 */
	protected String STSZSTATISTICS = "jsp/statistics/STSZ/";
	
	/**
	 * 科学文化素质
	 */
	protected String KXWHSZACT = "jsp/statistics/KXWHSZ/";
	/**
	 * 科技创新
	 */
	protected String KJCXSTATISTICS = "jsp/statistics/KJCX/";
	/**
	 * 社会实践
	 */
	protected String SOCIALSTATEMENT = "jsp/statistics/SOCIAL/";
	

    /*********************获取Request*******************/
    /**
     * 请求上下文
     */
    private HttpServletRequest request;
    
    protected HttpServletRequest getRequest(){
        return this.request;
    }
    
    @Resource
    protected void setRequest(HttpServletRequest request){
    	this.request=request;
    }
    
    /**
     * 将spring mvc 默认的ISO-8859-1转为utf-8
     * @param str
     * @return
     * @throws Exception
     * @author Whymann 2013-12-25 下午05:27:19
     */
    protected String toUTF8(String str) throws Exception{
    	if(StringUtils.isNotEmpty(str)){
    		byte bt[]=str.trim().getBytes("ISO-8859-1");
    		return new String(bt,"UTF-8");
    	}
    	return null;
    }
    
    /**
     * 获得当前访问的url
     * @return
     * @author Whymann 2013-12-8 上午10:53:56
     */
    protected String getUrl(){
    	return getRequest().getRequestURI();
    }
    
    /**
     * 获得前一次访问路径
     * @return
     * @author Whymann 2013-12-13 下午03:51:18
     */
    protected String getReferer(){
		//保存之前跳转到的页面
		String refer= getRequest().getHeader("referer");
		//项目服务器路径
		String basePath=getRequest().getScheme()+"://"+getRequest().getServerName()+":"+getRequest().getServerPort()+getRequest().getContextPath();
		if(StringUtils.isEmpty(refer)){//为空，保存历史记录为前台首页
			refer="";
		}else{
			//截取掉项目路径，保留访问参数
			refer=refer.substring(basePath.length());
		}
		return refer;
    }
    
    /**
     * 获取客户端ip
     */
    protected String getClientIp(){
    	String ip = getRequest().getHeader("x-forwarded-for");  
    	if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
    		ip = getRequest().getHeader("Proxy-Client-IP");  
    	}  
    	if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
    		ip = getRequest().getHeader("WL-Proxy-Client-IP");  
    	}  
    	if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
    		ip = getRequest().getRemoteAddr();  
    	}  
    	//ip="61.136.151.238";
    	return ip;  
    }
    
    /**
     * 获取用户回话
     * @return
     */
//    protected UserSession getSession(){
//    	return (UserSession)this.getRequest().getSession().getAttribute(BaseConst.USERSESSION);
//    }

    
    /**
     * 获取登录用户
     * @return
     */
//    protected User getUser(){
//    	if(null!=getSession()){
//    		return getSession().getUser();
//    	}
//    	return null;
//    }
    
    /**
     * 返回错误信息
     * @param msg
     */
    protected void returnException(String msg){
    	getRequest().setAttribute("exception", msg);
    }
    
    /**
     * 设置历史路由
     * @param
     * @throws Exception 
     */
    public void setHistoryUrl(){
    	String url=getRequest().getRequestURL().toString();
    	Map<String,String[]> params=getRequest().getParameterMap();
    	String queryString="";
    	for (String key: params.keySet()) {
			String[] values=params.get(key);
			for (String v : values) {
				queryString+=key+"="+v+"&";
			}
		}
    	if(StringUtils.isNotEmpty(queryString) && queryString.length()>0){
    		// 去掉最后一个&符号  
    		queryString = queryString.substring(0, queryString.length() - 1);
    		if(url.indexOf("?")==-1){
    			url=url+"?"+queryString;
    		}else{
    			url=url+queryString;
    		}
    	}
    	HttpSession urlSession=getRequest().getSession();
    	urlSession.setAttribute(BaseConst.HISTORYURL, url);
    }
    
	/**
	 * 重写getPara，进行二次decode解码
	 */
	public String getPara(String name) {
		String value = getRequest().getParameter(name);
		if(null != value && !value.isEmpty()){
			try {
				value = URLDecoder.decode(value, ToolString.encoding);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return value;
	}
   
}
