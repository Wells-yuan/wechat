package com.wechat.stsz.model;

public class Score {
	private String id;
	private String stuid;
	private String lasterm;
	private String thisterm;
	private String score;
	private String stuyear;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStuyear() {
		return stuyear;
	}
	public void setStuyear(String stuyear) {
		this.stuyear = stuyear;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getLasterm() {
		return lasterm;
	}
	public void setLasterm(String lasterm) {
		this.lasterm = lasterm;
	}
	public String getThisterm() {
		return thisterm;
	}
	public void setThisterm(String thisterm) {
		this.thisterm = thisterm;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Score [id=" + id + ", stuid=" + stuid + ", lasterm=" + lasterm
				+ ", thisterm=" + thisterm + ", score=" + score + ", stuyear="
				+ stuyear + "]";
	}
	
}
