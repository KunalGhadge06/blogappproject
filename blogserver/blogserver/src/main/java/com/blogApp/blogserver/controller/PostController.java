package com.blogApp.blogserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogApp.blogserver.entity.Post;
import com.blogApp.blogserver.service.PostService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin("*")
public class PostController {

	@Autowired
	private PostService postservice;
	
	@PostMapping
	public ResponseEntity<?> createPost(@RequestBody Post post)
	{
		try{
			Post createdPost=postservice.savePost(post);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);	
		}catch(Exception e)
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		
		
	}
	 @DeleteMapping("/byPostedBy/{postedBy}")
	    public ResponseEntity<Void> deletePostByPostedBy(@PathVariable String postedBy) {
	        postservice.deleteByPostedBy(postedBy);
	        return ResponseEntity.noContent().build();
	    }
	@GetMapping
	public ResponseEntity<List<Post>> getAllPosts()
	{
		try {
			return ResponseEntity.status(HttpStatus.OK).body(postservice.getAllPost());
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<?> getPostById(@PathVariable Long postId)
	{
		try {
			Post post= postservice.getPostById(postId);
			return ResponseEntity.ok(post);
			
		}catch (EntityNotFoundException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	@PutMapping("/{postId}/like")
	public ResponseEntity<?> likePost(@PathVariable Long postId)
	{
		try {
		     postservice.likePost(postId);
		     return ResponseEntity.ok(new String[]{"Thank You..."});
		}catch(EntityNotFoundException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
	@GetMapping("/search/{name}")
	public ResponseEntity<?> searchByName(@PathVariable String name){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(postservice.searchByName(name));
		}catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
