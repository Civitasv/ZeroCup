package com.hzl.service.impl;

import java.lang.reflect.Field;
import java.util.List;

import com.hzl.dao.BaseDao;
import com.hzl.service.BaseService;



public class BaseServiceImpl<T,Q> implements BaseService<T,Q> {

	public BaseDao<T,Q> baseDao;
	
	public BaseDao<T, Q> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T, Q> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void save(T t) {
		baseDao.saveObj(t);
	}

	@Override
	public void update(T t) {
		baseDao.updateObj(t);
	}

	@Override
	public T getObjById(Integer id) {
		return baseDao.getObjById(id);
	}

	@Override
	public void deleteObjById(Integer id) {
		baseDao.deleteObjById(id);
	}


	@Override
	public List<T> list(){
		return baseDao.list();
	}

	@Override
	public List<T> queryObjByConditionNoPage(Q q, List<String> exclude) {
		return baseDao.queryObjByConditionNoPage(q, exclude);
	}
	
}
