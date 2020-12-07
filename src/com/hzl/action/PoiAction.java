package com.hzl.action;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.hzl.model.Note;
import com.hzl.model.Poi;
import com.hzl.model.User;
import com.hzl.query.UserQuery;
import com.hzl.service.NoteService;
import com.hzl.service.PoiService;
import com.hzl.service.UserService;
import com.hzl.utils.JsonUtils;
import com.hzl.utils.UserGet;
import com.opensymphony.xwork2.ActionContext;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.SessionFactory;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PoiAction extends HttpBaseAction {
	@Resource
	SessionFactory sf;
	
	@Resource
	private PoiService poiService;
	@Resource
	private NoteService noteService;
	@Resource
	private UserService userService;
	private Note note;

	public Note getNote() {
		return note;
	}

	private Map<String, Object> session = ActionContext.getContext().getSession();

	public void setNote(Note note) {
		this.note = note;
	}

	private UserQuery query;
	private Integer poiId;

	public Integer getPoiId() {
		return poiId;
	}

	public void setPoiId(Integer poiId) {
		this.poiId = poiId;
	}

	public UserQuery getQuery() {
		return query;
	}

	public void setQuery(UserQuery query) {
		this.query = query;
	}

	/**
	 * 进入ArcMap.jsp页面
	 */
	public String enterArc() {
		return super.SUCCESS;
	}

	/**
	 * 进入相册
	 */
	public String enterImage() {
		return super.SUCCESS;
	}

	/**
	 * ajax加载所有poi以及其notes相关信息
	 * 
	 * @throws IOException
	 */
	public void ajax_showAllPois() throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<Poi> list = poiService.list();
		JSONArray array = JsonUtils.convert2JSONArray(list, new String[] {"notes"}); // 先排除notes的集合对象
		for (int i = 0; i < array.size(); i++) {
			JSONObject jb = array.getJSONObject(i); // 获得每一个poiJSon
			Set<Note> notes = list.get(i).getNotes();
			JSONArray array2 = JsonUtils.convert2JSONArray(notes, new String[] { "user", "poi" }); // 考虑安全问题以及循环问题排除user属性
																									// ,暂时不需要poi的相关信息
			// 组装Note对象,将user替换为name
			for (int j = 0; j < array2.size(); j++) {
				JSONObject jsonObject = array2.getJSONObject(j);
				jsonObject.put("user", ((Note) notes.toArray()[j]).getUser().getName());
			}
			jb.put("notes", array2);
			System.out.println(jb.toString());
		}
		response.getWriter().write(array.toString());
	}

	public void ajax_addNote() throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		User user = UserGet.getUser(session);
		int flag = 0;
		if(user==null) {
			flag=1;
		}else {
			noteService.saveNote(note.getContent(), poiId, user);
		}
		sf.getCurrentSession().clear(); // 解决session一级缓存问题
		List<Poi> list = poiService.list();
		JSONArray array = JsonUtils.convert2JSONArray(list, new String[] { "notes" }); // 先排除notes的集合对象
		for (int i = 0; i < array.size(); i++) {
			JSONObject jb = array.getJSONObject(i); // 获得每一个poiJSon
			Set<Note> notes = list.get(i).getNotes();
			JSONArray array2 = JsonUtils.convert2JSONArray(notes, new String[] { "user", "poi" }); // 考虑安全问题以及循环问题排除user属性
			// 组装Note对象,将user替换为name
			for (int j = 0; j < array2.size(); j++) {
				JSONObject jsonObject = array2.getJSONObject(j);
				jsonObject.put("user", ((Note) notes.toArray()[j]).getUser().getName());
			}
			jb.put("notes", array2);
		}
		array.add(flag);
		response.getWriter().write(array.toString());
	}
}
