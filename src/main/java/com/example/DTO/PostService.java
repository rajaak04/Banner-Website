package com.example.DTO;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

	
	@Autowired
	PostRepository repository;
	
	@Autowired
	ModelMapper modelmapper;
	
	public List<PostDTO> saveUser() {
		
		List<Post> posts=repository.findAll();
		return posts.stream().map(posting -> modelmapper.map(posting, PostDTO.class)).collect(Collectors.toList());
		
		
		
		
	}
	public Post setFile(MultipartFile file,String username,String description) throws IOException {
		
		Post post=new Post();
		post.setUsername(username);
		post.setDescription(description);
		
		post.setPosterImage(file.getBytes());
		post.setContenttype(file.getContentType());
		String base64=Base64.getEncoder().encodeToString(file.getBytes());
		post.setFilename(file.getOriginalFilename());
		post.setBase64(base64);
		  
		repository.save(post);
		return post;
		
		
		
		
	}
	
	
}