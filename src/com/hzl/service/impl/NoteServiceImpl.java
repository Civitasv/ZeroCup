package com.hzl.service.impl;

import com.hzl.dao.NoteDao;
import com.hzl.dao.PoiDao;
import com.hzl.dao.UserDao;
import com.hzl.model.Note;
import com.hzl.model.Poi;
import com.hzl.model.User;
import com.hzl.query.NoteQuery;
import com.hzl.service.NoteService;

import javax.annotation.Resource;


public class NoteServiceImpl extends BaseServiceImpl<Note, NoteQuery> implements NoteService {

	@Resource
	private UserDao userDao;
	
	@Resource
	private PoiDao poiDao;
	
	private NoteDao noteDao;

	public NoteDao getNoteDao() {
		return noteDao;
	}

	public void setNoteDao(NoteDao noteDao) {
		this.noteDao = noteDao;
		this.baseDao = noteDao;
	}

	@Override
	public void saveNote(String content, Integer poiId,User user) {
		Note note = new Note();
		note.setContent(content);
		Poi poi = poiDao.getObjById(poiId);
		note.setUser(user);
		note.setPoi(poi);
		noteDao.saveObj(note);
	}


}
