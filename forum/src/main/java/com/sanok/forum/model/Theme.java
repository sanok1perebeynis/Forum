package com.sanok.forum.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "theme")
public class Theme {

	@Id
	@Column(name = "idTheme")
	@GeneratedValue
	private int idTheme;
	
	@Column(name = "themeName")
	private String themeName;
	
	@Column(name = "themeText")
	private String themeText;
	
	
	@Column(name = "authorName")
	private String authorName;
	
	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getThemeText() {
		return themeText;
	}

	public void setThemeText(String themeText) {
		this.themeText = themeText;
	}

	@OneToMany
	private Set<Comments> comments;

	public int getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public Set<Comments> getComments() {
		return comments;
	}

	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}
	
}
