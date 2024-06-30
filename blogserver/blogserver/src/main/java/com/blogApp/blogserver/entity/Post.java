package com.blogApp.blogserver.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(length = 5000)
	private String content;
	
	private String postedBy;
	
	private String img;
	
	private Date date;
	
	private int likeCount;
	
	private int viewCount;
	
	private List<String > tags;
	

	public Post() {
		super();
	}

	public Post(Long id, String name, String content, String postedBy, String img, Date date, int likeCount,
			int viewCount, List<String> tags) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.postedBy = postedBy;
		this.img = img;
		this.date = date;
		this.likeCount = likeCount;
		this.viewCount = viewCount;
		this.tags = tags;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", name=" + name + ", content=" + content + ", postedBy=" + postedBy + ", img=" + img
				+ ", date=" + date + ", likeCount=" + likeCount + ", viewCount=" + viewCount + ", tags=" + tags + "]";
	}
	
}
