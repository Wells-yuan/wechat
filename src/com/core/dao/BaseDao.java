package com.core.dao;



/**
 * DAO父类接口
 *
 * @version 1.0,2013-8-31
 * @author Wymann
 * @param <T> 实体模型
 */
public interface BaseDao<T> {
	
	public void save(T t);

	public void update(T t);

	public void delete(T t);

}
