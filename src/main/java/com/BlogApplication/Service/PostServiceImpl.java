package com.BlogApplication.Service;

import java.util.Iterator;
import java.util.List;
import com.BlogApplication.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Pageable;
import com.BlogApplication.Model.Post;
import com.BlogApplication.Repository.*;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.BlogApplication.Exceptions.BlogException;

@Service
public class PostServiceImpl implements PostService{
	
		@Autowired
	    private PostRepo postRepo;

	    @Autowired
	    private CommentRepo commentRepo;


	@Override
	public List<Post> getAllPost() {
		
		return postRepo.findAll();
	}

	@Override
	public Post getPostById(int id) {
		Optional<Post> optionalPost = postRepo.findById(id);
        if(optionalPost.isPresent()){
            return optionalPost.get();
        }
        throw  new BlogException("Post id is incorrect");
	}

	@Override
	public String createPost(Post post) {
		 postRepo.save(post);
	     return "New Post Added successfully..";
	}

	@Override
	public Post updatePostById(Post post, int id) {
		Optional<Post> optionalPost = postRepo.findById(id);
        if(optionalPost.isPresent()){
            optionalPost.get().setTitle(post.getTitle());
            optionalPost.get().setDescription(post.getDescription());
            return postRepo.save(optionalPost.get());
        }
        throw  new BlogException("Post id is incorrect");
	}

	@Override
	public String deletePostById(int id) {
		Optional<Post> optPost = postRepo.findById(id);
        if(optPost.isPresent()){
            Iterator itr = optPost.get().getComments().iterator();
            while(itr.hasNext()){
                Comment c = (Comment) itr.next();
                itr.remove();
                commentRepo.deleteById(c.getId());
            }
            postRepo.save(optPost.get());
            postRepo.deleteById(id);
            return "Post deleted successfully";
        }

        throw new BlogException("Post id is not correct");
	}

	@Override
	public List<Post> pageAndSort(int pageNo, int pageSize, String sortBy) {
		if(sortBy == null){
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            return postRepo.findAll(pageable).toList();
        }
        Pageable pageable = PageRequest.of(pageNo, pageSize, Direction.DESC, sortBy);
        return postRepo.findAll(pageable).toList();
	}

}
