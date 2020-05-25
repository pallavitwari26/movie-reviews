package com.moviereviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class HomeController {
	
	
	@GetMapping(value= {"/","index.html"})
	public String welcome()
	{
		return "Hello from the Movie Review Controller";
	}

}
