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
import com.puneeth.westpac.codetest.model.Post;


@Service
public class PostService {
	
	public List<Post> getPosts() throws Exception {
		// API request
		Client restClient = ClientBuilder.newClient();
		String targetResource = ApiResource.POSTS_RESOURCE;
		Response response = restClient.target(targetResource)
				.request(MediaType.APPLICATION_JSON)
				.get();
		Optional<String> jsonOpt = Optional.of(response.readEntity(String.class));
		String json = jsonOpt.orElseThrow(() -> new Exception("Exception occured in Posts API"));
		
		// convert json string to object
		ObjectMapper mapper = new ObjectMapper();
		Optional<List<Post>> postsOpt = Optional.of(mapper.reader()
			      .forType(new TypeReference<List<Post>>() {})
			      .readValue(json));

		List<Post> posts = postsOpt.orElseThrow(() -> new Exception("Exception occured while converting Posts json to object"));
		
		return posts;
		
	}

}
