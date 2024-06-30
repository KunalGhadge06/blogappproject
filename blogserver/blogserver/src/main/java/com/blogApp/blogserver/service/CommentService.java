package com.blogApp.blogserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogApp.blogserver.dao.CommentRepository;
import com.blogApp.blogserver.entity.Comment;


public interface CommentService {

	Comment createComment(Long postId,String postedBy,String content);
	
	List<Comment> getCommentByPostId(Long postId);

	void deleteByPostedBy(String postedBy);
}
