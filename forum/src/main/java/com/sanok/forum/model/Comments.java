package com.sanok.forum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comments {

	@Id
	@Column(name = "idComments")
	@GeneratedValue
	private int idComments;
	
	@Column(name = "commentText")
	private String commentText;
	
	@Column(name = "authorCommentName")
	private String authorCommentName;
	
	

	public String getAuthorCommentName() {
		return authorCommentName;
	}

	public void setAuthorCommentName(String authorCommentName) {
		this.authorCommentName = authorCommentName;
	}

	public int getIdComments() {
		return idComments;
	}

	public void setIdComments(int idComments) {
		this.idComments = idComments;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}



	
	
}
