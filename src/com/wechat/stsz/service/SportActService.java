package com.wechat.stsz.service;

import java.util.List;

import com.wechat.stsz.model.STSZActs;

public interface SportActService {
	
	public List<STSZActs> findByActid(String stuid, int actid);
	
	public void saveAct(STSZActs stszAct);
	
	public void updateAct(STSZActs stszAct);
	
	public void deleteAct(STSZActs stszAct);
	
}
