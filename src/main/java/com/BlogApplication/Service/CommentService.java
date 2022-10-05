package com.BlogApplication.Service;
import java.util.List;
import com.BlogApplication.Model.Comment;


public interface CommentService {

	 public List<Comment> getAllCommentOfPostById(int id);
	    public Comment getCommentByIdBelongToPost(int postId, int commentId);
	    public String addCommentToPost(int postId, Comment comment);
	    public Comment updateCommentByIdBelongToPost(int postId, int commentId, Comment comment);
	    public String deleteCommentByIdBelongToPost(int postId, int commentId);
}
