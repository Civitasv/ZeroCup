package com.hzl.service;

import com.hzl.model.Note;
import com.hzl.model.User;
import com.hzl.query.NoteQuery;

public interface NoteService extends BaseService<Note, NoteQuery>  {

	/**
	 * 
	 * @param content
	 * @param poiId
	 * @param user 获取session中的user
	 */
	public void saveNote(String content, Integer poiId, User user);
}
