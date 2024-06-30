package com.blogApp.blogserver.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String content;
	
	private Date date;
	
	private String postedBy;
	
	@ManyToOne
	@JoinColumn(name="post_id",nullable = false)
	private Post post;
	

	public Comment() {
		super();
	}

	public Comment(Long id, String content, Date date, String postedBy, Post post) {
		super();
		this.id = id;
		this.content = content;
		this.date = date;
		this.postedBy = postedBy;
		this.post = post;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", date=" + date + ", postedBy=" + postedBy + ", post="
				+ post + "]";
	}
	
	
}
