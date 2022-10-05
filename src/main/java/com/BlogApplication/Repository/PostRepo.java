package com.BlogApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BlogApplication.Model.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer>{

}
