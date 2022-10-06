package com.BlogApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.BlogApplication.Model.Post;
import com.BlogApplication.Service.PostService;
import java.util.List;


@RequestMapping(value = "/blog")
@RestController
public class PostController {

	@Autowired
    private PostService postService;
	
	 @GetMapping("/posts")
	public ResponseEntity<List<Post>> getAllPost(){
        return new ResponseEntity<List<Post>>(postService.getAllPost(), HttpStatus.OK) ;
    }


}
