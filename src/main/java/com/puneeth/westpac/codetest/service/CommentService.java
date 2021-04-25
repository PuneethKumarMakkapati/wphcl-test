package com.puneeth.westpac.codetest.service;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.puneeth.westpac.codetest.ApiResource;
import com.puneeth.westpac.codetest.model.Comment;

@Service
public class CommentService {
	
	public List<Comment> getCommentsByPostId(String postId) throws Exception {
		// API call
		Client restClient = ClientBuilder.newClient();
		String targetResource = ApiResource.COMMENTS_RESOURCE+postId;
		Response response = restClient.target(targetResource)
				.request(MediaType.APPLICATION_JSON)
				.get();
		Optional<String> jsonOpt = Optional.of(response.readEntity(String.class));
		String json = jsonOpt.orElseThrow(() -> new Exception("Exception occured in Comments API"));
		// convert json to object
		ObjectMapper mapper = new ObjectMapper();
		Optional<List<Comment>> commentsOpt = Optional.of(mapper.reader()
			      .forType(new TypeReference<List<Comment>>() {})
			      .readValue(json));
		
		List<Comment> comments = commentsOpt.orElseThrow(() -> new Exception("Exception occured while converting Comments json to object"));
		
		return comments;
	}

}
