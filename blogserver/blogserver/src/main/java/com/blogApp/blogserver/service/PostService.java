package com.blogApp.blogserver.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogApp.blogserver.entity.Post;


public interface PostService {

	Post savePost(Post post);
	
    List<Post> getAllPost();
	
	 Post getPostById(Long postId);
	 
	 void likePost(Long postId);
	  
    List<Post> searchByName(String name);

	void deleteByPostedBy(String postedBy);

	
}
