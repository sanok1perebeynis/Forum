package com.sanok.forum.service;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanok.forum.model.Admin;
import com.sanok.forum.model.Comments;
import com.sanok.forum.model.Theme;

@Service("themeService")
@Transactional
public class ThemeService {
	@Autowired
	private SessionFactory sessionFactory;

	
	
	// Themes
	public List<Theme> getAllThemes() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM Theme");
		return q.list();
	}
	
	public void addTheme(Theme theme) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(theme);
	}

	public Theme getThemeId(int idTheme) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session
				.createQuery("FROM Theme as t LEFT JOIN FETCH t.comments WHERE t.idTheme = "
						+ idTheme);
		return (Theme) q.uniqueResult();
	}
	
	
	public void deleteTheme(Integer idTheme) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("FROM Theme as t LEFT JOIN FETCH t.comments WHERE t.idTheme = "
						+ idTheme);
		Theme theme = (Theme) query.uniqueResult();
		Set<Comments> comments = theme.getComments();
		session.delete(theme);
		for (Comments comment : comments) {
			session.delete(comment);
		}
	}
	
	
	public void editTheme(Theme theme) {
		Session session = sessionFactory.getCurrentSession();
		Theme existingTheme = (Theme) session.get(Theme.class,
				theme.getIdTheme());
		existingTheme.setThemeName(theme.getThemeName());
		session.save(existingTheme);
	}
	
	

	
	public boolean findByLogin(String adminName, String adminPassword) {	
		
		Session session = sessionFactory.getCurrentSession();

	
		Query q = session.createQuery("select a.adminName, a.adminPassword from Admin a");
	     List<Object[]> admins= (List<Object[]>)q.list();
	     for(Object[] admin: admins){
	     
	         String adminNames = (String)admin[0];
	         String adminPasswords = (String)admin[1];
		
		if(((adminName != null && adminNames.equals(adminName)))&& 
				((adminPassword != null && adminPassword.equals(adminPasswords)))){
			return true;
		} 
		
		return false;		
	}
		return true;
	
}
}
