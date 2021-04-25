package com.puneeth.westpac.codetest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.puneeth.westpac.codetest.model.Post;
import com.puneeth.westpac.codetest.service.PostService;

@Controller
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	public String getPosts(Model model) throws Exception {
		
		List<Post> posts = postService.getPosts();
		model.addAttribute("posts",posts);
		return "posts";
	}

}
