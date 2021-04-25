package com.puneeth.westpac.codetest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.puneeth.westpac.codetest.model.Comment;
import com.puneeth.westpac.codetest.service.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping({"/comments"})
	public String getCommentsByPostId( @RequestParam(value="postId", required=true) String postId, Model model) throws Exception {
		List<Comment> comments = commentService.getCommentsByPostId(postId);
		model.addAttribute("comments", comments);
		return "comments";
		
	}

}
