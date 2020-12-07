package com.hzl.service.impl;


import com.hzl.dao.PoiDao;
import com.hzl.model.Poi;
import com.hzl.query.PoiQuery;
import com.hzl.service.PoiService;

public class PoiServiceImpl extends BaseServiceImpl<Poi, PoiQuery> implements PoiService {

	private PoiDao poiDao;

	public PoiDao getPoiDao() {
		return poiDao;
	}

	public void setPoiDao(PoiDao poiDao) {
		this.poiDao = poiDao;
		this.baseDao = poiDao;
	}
}
