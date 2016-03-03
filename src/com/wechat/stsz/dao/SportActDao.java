package com.wechat.stsz.dao;

import java.util.List;

import com.core.dao.BaseDao;
import com.wechat.stsz.model.STSZActs;

public interface SportActDao extends BaseDao<STSZActs> {
	
	public List<STSZActs> findByActid(String stuid, int actid);

}
