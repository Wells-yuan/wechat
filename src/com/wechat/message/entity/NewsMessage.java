package com.wechat.message.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.core.model.BaseMessage;

@XmlRootElement(name="xml")
public class NewsMessage extends BaseMessage{
	private int ArticleCount;
	private List<News> Articles;
	
	@XmlElement(name = "ArticleCount")
	public int getArticleCount() {
		return ArticleCount;
	}
	
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	@XmlElementWrapper(name = "Articles")
	@XmlElement(name = "item")
	public List<News> getArticles() {
		return Articles;
	}
	public void setArticles(List<News> articles) {
		Articles = articles;
	}
}
