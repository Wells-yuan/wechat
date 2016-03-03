package com.wechat.stsz.model;

import java.util.Date;

public class Deduction {
	private int id;
	private String stuid;
	private String reason;
	private Date k_time;
	private float reson_core;
	private int koufen_type;
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getK_time() {
		return k_time;
	}
	public void setK_time(Date k_time) {
		this.k_time = k_time;
	}
	public float getReson_core() {
		return reson_core;
	}
	public void setReson_core(float reson_core) {
		this.reson_core = reson_core;
	}
	public int getKoufen_type() {
		return koufen_type;
	}
	public void setKoufen_type(int koufen_type) {
		this.koufen_type = koufen_type;
	}
	@Override
	public String toString() {
		return "Deduction [id=" + id + ", stuid=" + stuid + ", reason="
				+ reason + ", k_time=" + k_time + ", reson_core=" + reson_core
				+ ", koufen_type=" + koufen_type + "]";
	}
}
