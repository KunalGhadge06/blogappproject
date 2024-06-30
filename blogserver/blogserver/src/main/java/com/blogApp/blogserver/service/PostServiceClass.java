package com.blogApp.blogserver.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogApp.blogserver.dao.PostRepository;
import com.blogApp.blogserver.entity.Post;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;




@Service
public class PostServiceClass implements PostService{
	
	@Autowired
	private PostRepository postRepository;
	
	public Post savePost(Post post)
	{
		post.setLikeCount(0);
		post.setViewCount(0);
		post.setDate(new Date());
		
		return postRepository.save(post);
	}
	
	public List<Post> getAllPost()
	{
		return postRepository.findAll();
	}

	public Post getPostById(Long postId)
	{
		Optional<Post> optionalPost = postRepository.findById(postId);
		if(optionalPost.isPresent()) {
			Post post=optionalPost.get();
			post.setViewCount(post.getViewCount()+1);
			return postRepository.save(post);
		}
		else {
			throw new EntityNotFoundException("Post Not Found");
		}
	}
	
	public void likePost(Long postId)
	{
		Optional<Post> optionalPost = postRepository.findById(postId);
		if(optionalPost.isPresent()) {
			Post post=optionalPost.get();
		
			post.setLikeCount(post.getLikeCount()+1);
			postRepository.save(post);
		}
		else {
			throw new EntityNotFoundException("Post not Found with id"+postId);
		}
	}
	@Override
	public List<Post>searchByName(String name){
		return postRepository.findAllByNameContaining(name);
	}
	 
	 @Transactional
	    public void deleteByPostedBy(String postedBy) {
	        postRepository.deleteByPostedBy(postedBy);
	    }	    
}
