package com.BlogApplication.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.BlogApplication.Model.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer>{

	
}
