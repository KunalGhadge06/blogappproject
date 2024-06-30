package com.blogApp.blogserver.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogApp.blogserver.dao.CommentRepository;
import com.blogApp.blogserver.dao.PostRepository;
import com.blogApp.blogserver.entity.Comment;
import com.blogApp.blogserver.entity.Post;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CommentServiceClass implements CommentService{

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	public Comment createComment(Long postId,String postedBy,String content)
	{
		Optional<Post> optionalpost= postRepository.findById(postId);
		if(optionalpost.isPresent() ){
			Comment comment = new Comment();
			
		     comment.setPost(optionalpost.get());
		     comment.setContent(content);
		     comment.setPostedBy(postedBy);
		     comment.setDate(new Date());
		     
		     return commentRepository.save(comment);
		}
		throw new EntityNotFoundException("Post Not Found");
		
	}
	
	public List<Comment> getCommentByPostId(Long postId)
	{
		return commentRepository.findCommentByPostId(postId);
	}
	 public void deleteByPostedBy(String postedBy) {
	        commentRepository.deleteByPostedBy(postedBy);
	    }
}
