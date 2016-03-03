package com.core.dao.impl;


import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.core.dao.BaseDao;


/**
 * DAOImpl父类
 * @version 1.0,2013-9-1
 * @author Wymann
 * @param <T> 实体模型
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T>{							
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	
	protected JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}
	
	public void save(T t){
		
	}
	public void update(T t){
		
	}
	
	public void delete(T t) {
		
	}
}
