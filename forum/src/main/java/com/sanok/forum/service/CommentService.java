package com.sanok.forum.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanok.forum.model.Admin;
import com.sanok.forum.model.Comments;
import com.sanok.forum.model.Theme;

@Service("commentService")
@Transactional
public class CommentService {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Comments> getAllComments(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session
				.createQuery("FROM Theme as t LEFT JOIN FETCH t.comments WHERE t.idTheme = "
						+ id);
		Theme theme = (Theme) q.uniqueResult();
		return new ArrayList<Comments>(theme.getComments());
	}

	public List<Comments> getAllComments() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM  Comments");
		return q.list();
	}

	public Comments getComments(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Comments comments = (Comments) session.get(Comments.class, id);
		return comments;
	}
	
	
	public void addComments(Integer idTheme, Comments comments) {
		Session session = sessionFactory.getCurrentSession();
		session.save(comments);
		Theme existingTheme = (Theme) session.get(Theme.class, idTheme);

		// Assign updated values to this theme
		existingTheme.getComments().add(comments);

		// Save updates
		session.save(existingTheme);
	}
	
	public void deleteComments(Integer idComments) {
		Session session = sessionFactory.getCurrentSession();

	
		Query query = session.createSQLQuery("DELETE FROM theme_comments "
				+ "WHERE comments_idComments=" + idComments);

		query.executeUpdate();

		// Retrieve existing comments
		Comments comments = (Comments) session.get(Comments.class, idComments);

		// Delete
		session.delete(comments);
	}
	
	public void editComment(Comments comments) {
		Session session = sessionFactory.getCurrentSession();

		// Retrieve existing comments via id
		Comments existingComment = (Comments) session.get(Comments.class,
				comments.getIdComments());

		// Assign updated values to this comments card
		existingComment.setCommentText(comments.getCommentText());
		
		// Save updates
		session.save(existingComment);
	}
	
	
	
	
	
}
