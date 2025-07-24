package com.example.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.*;

@Controller
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    PostRepository repository;

   @GetMapping("/posts")
   public String getUSername(Model model) {
	   
	   
	   PostDTO postdto=new PostDTO();
	   List<Post> posting=repository.findAll();
	   for(Post post:posting) {
		   if(post.getPosterImage()!=null) {
			   String base64=Base64.getEncoder().encodeToString(post.getPosterImage());
			   post.setBase64(base64);
			   postdto.setBase64(base64);
		   }
		   else {
			   postdto.setBase64("null ");
		   }
		   
		   
	   }
	   System.out.println(postdto.getBase64());
	    
	   List<PostDTO> posts=postService.saveUser();
	   model.addAttribute("post",posts);
	   return "posts";
	   
	   
   }
   
   
   
   @GetMapping
   public String goUpload() {
	   return "file";
	   
   }
   
   
   
   @GetMapping("/upload")
   public String gotoUpload() {
	   return "file";
   }
   
   
   
   
   @PostMapping("/submit")
   public String setfile(@RequestParam("file") MultipartFile file,
	@RequestParam("username") String username,@RequestParam("description") String description,   
		   
		   Model model,RedirectAttributes attributes) throws IOException {
	   Post post=postService.setFile(file, username, description);
	   
	   attributes.addFlashAttribute("success", "File Saved Successfull");
	   model.addAttribute("save","Saved Successfull");
	   return "redirect:/upload";
	   
	   
	   
	   
	   
   }

}

