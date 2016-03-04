package com.wechat.admin.entity;

import com.core.model.Button;

public class BaseButton implements Button {
	private String type;
	private String name;
	private BaseButton[] sub_button;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Button[] getSub_button() {
		return sub_button;
	}
	public void setSub_button(BaseButton[] sub_button) {
		this.sub_button = sub_button;
	}
}
