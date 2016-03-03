package com.util.message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wechat.BaseConst;
import com.wechat.message.entity.News;
import com.wechat.message.entity.NewsMessage;
import com.wechat.message.entity.TextMessage;

public class MessageUtil {
	
	public static TextMessage initText(String toUserName, String fromUserName, String content){
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(BaseConst.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		return text;
	}
	
	/**
	 * 初始化图文消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	
	public static NewsMessage initNewsMessage(String toUserName, String fromUserName){
		NewsMessage newsMsg = new NewsMessage();
		List<News> newsList = new ArrayList<News>();
		News news = new News();
		
		news.setTitle("刘亦菲~~\n想入非非");
		news.setDescription("菲菲的相册");
		news.setPicUrl("http://wechatest.ngrok.natapp.cn/wechat/common/images/feifei.png");
		news.setUrl("http://photo.weibo.com/3261134763/wbphotos/large/mid/3947958225951611/pid/c260f7abjw1f1ghsfq1e4j20ct0hsabg");
		
		News news2 = new News();
		news2.setTitle("Hololens--Microsoft \n Transform your world");
		news2.setPicUrl("http://wechatest.ngrok.natapp.cn/wechat/common/images/hololens.png");
		news2.setUrl("http://v.youku.com/v_show/id_XODc2OTE0MTA4.html?from=s1.8-1-1.2");
		
		
		newsList.add(news2);
		newsList.add(news);
		
		newsMsg.setFromUserName(toUserName);
		newsMsg.setToUserName(fromUserName);
		newsMsg.setMsgType(BaseConst.MESSAGE_NEWS);
		newsMsg.setCreateTime(new Date().getTime());
		newsMsg.setArticles(newsList);
		newsMsg.setArticleCount(newsList.size());
		
		return newsMsg;
	}
	
	/**
	 * 主菜单
	 * @author yuan9
	 *
	 */
	public static String menuText(){
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎您的关注，请按照菜单的提示进行操作：\n\n");
		sb.append("1、课程介绍\n");
		sb.append("2、课程管理\n");
		sb.append("3、试试看\n");
		sb.append("4、查看图文消息\n\n");
		sb.append("回复？调出此菜单");
		return sb.toString();
	}
	
	public static String firstMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("本课程介绍微信公众号开发，主要涉及公众号介绍、编辑模式介绍、开发模式介绍等");
		return sb.toString();
	}
	
	public static String secondMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("本课程由SpringMVC、mysql、tomcat搭建.");
		return sb.toString();
	}
}
