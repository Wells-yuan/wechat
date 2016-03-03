package com.wechat.stsz.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class STSZActs {
	private int id;
	private String stuid;	//学号
	private int actid;	//活动类型
	private String actname;	//活动名称
	private String actlev;	//活动级别
	private Date actime;	//活动时间
	private String actwitness;	//活动证明人
	private String certifi;	//证书
	private Date stu_cer_time;	//证书时间
	private int score;	//得分
	private SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public int getActid() {
		return actid;
	}
	public void setActid(int actid) {
		this.actid = actid;
	}
	public String getActname() {
		return actname;
	}
	public void setActname(String actname) {
		this.actname = actname;
	}
	public String getActlev() {
		return actlev;
	}
	public void setActlev(String actlev) {
		this.actlev = actlev;
	}
	public Date getActime() {
		return actime;
	}
	public void setActime(Date actime) {
		this.actime = actime;
	}
	public String getActwitness() {
		return actwitness;
	}
	public void setActwitness(String actwitness) {
		this.actwitness = actwitness;
	}
	public String getCertifi() {
		return certifi;
	}
	public void setCertifi(String certifi) {
		this.certifi = certifi;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getStu_cer_time() {
		return stu_cer_time;
	}
	public void setStu_cer_time(Date stu_cer_time) {
		this.stu_cer_time = stu_cer_time;
	}
	@Override
	public String toString() {
		return "STSZActs [id=" + id + ", stuid=" + stuid + ", actid=" + actid
				+ ", actname=" + actname + ", actlev=" + actlev + ", actime="
				+ actime + ", actwitness=" + actwitness + ", certifi="
				+ certifi + ", stu_cer_time=" + stu_cer_time + ", score="
				+ score + "]";
	}
}
