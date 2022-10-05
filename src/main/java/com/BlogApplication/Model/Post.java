package com.BlogApplication.Model;

import java.time.LocalDateTime;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Post {
		
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int post_id;

	    private String title;

	    private String description;

	    @CreationTimestamp
	    private LocalDateTime createdDateTime;

	    @UpdateTimestamp
	    private LocalDateTime updatedDateTime;

	    @OneToMany
	    private List<Comment> comments = new ArrayList<>();
}
