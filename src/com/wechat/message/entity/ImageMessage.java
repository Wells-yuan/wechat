package com.wechat.message.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.core.model.BaseMessage;

@XmlRootElement(name="xml")
public class ImageMessage extends BaseMessage {
	
	private List<String> MediaId;

	@XmlElementWrapper(name="Image")
	@XmlElement(name="MediaId")
	public List<String> getMediaId() {
		return MediaId;
	}

	public void setMediaId(List<String> mediaId) {
		MediaId = mediaId;
	}
}
