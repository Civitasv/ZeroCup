package com.hzl.dao.impl;


import com.hzl.dao.NoteDao;
import com.hzl.model.Note;
import com.hzl.query.NoteQuery;

public class NoteDaoImpl extends BaseDaoImpl<Note, NoteQuery> implements NoteDao {

	@Override
	public String getHql(NoteQuery q) {
		String hql =  "from Note n where 1 = 1";
		return hql;
	}

	@Override
	public String getHqlCount(NoteQuery q) {
		return null;
	}

	// 不需要HQL条件
	@Override
	public String createHqlCondition(String hql, NoteQuery q) {
		return null;
	}

	
}
