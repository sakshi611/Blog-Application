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

	    @GetMapping("/posts/{id}")
	    public ResponseEntity<Post> getPostById(@PathVariable int id){
	        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
	    }

	    @PostMapping("/posts")
	    public ResponseEntity<String> createPost(@RequestBody Post post){
	        return new ResponseEntity<>(postService.createPost(post), HttpStatus.CREATED);
	    }
	    @PutMapping("/posts/{id}")
	    public ResponseEntity<Post> updatePostById(@RequestBody Post post, @PathVariable int id){
	        return new ResponseEntity<>(postService.updatePostById(post,id), HttpStatus.OK);
	    }
	    @DeleteMapping("/posts/{id}")
	    public ResponseEntity<String> deletePostById(@PathVariable int id){
	        return new ResponseEntity<String>(postService.deletePostById(id), HttpStatus.OK);
	    }

	    @GetMapping(value = "/posts/", params = {"pageNo", "pageSize"} )
	    public ResponseEntity<List<Post>> pageAndSort(@RequestParam int pageNo, @RequestParam int pageSize, @RequestParam(required = false) String sortBy){
	        return new ResponseEntity<List<Post>>(postService.pageAndSort(pageNo,pageSize,sortBy), HttpStatus.OK);
	    }
}
