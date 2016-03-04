package com.wechat.message.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.core.model.BaseMessage;

@XmlRootElement(name="xml")
public class MusicMessage extends BaseMessage {
	private Music Music;

	@XmlElement(name="Music")
	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		this.Music = music;
	}
}
