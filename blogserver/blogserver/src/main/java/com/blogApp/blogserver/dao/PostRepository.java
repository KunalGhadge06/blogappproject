package com.blogApp.blogserver.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogApp.blogserver.entity.Post;

import jakarta.transaction.Transactional;

@Repository
public interface PostRepository extends  JpaRepository<Post,Long> {
	
  List<Post> findAllByNameContaining(String name);
  @Modifying
  @Transactional
  @Query("DELETE FROM Post p WHERE p.postedBy = :postedBy")
  void deleteByPostedBy(@Param("postedBy") String postedBy);
  
}
