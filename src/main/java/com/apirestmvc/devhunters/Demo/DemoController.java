package com.apirestmvc.devhunters.Demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/")
@RequiredArgsConstructor
public class DemoController {
	@PostMapping(path = "/demo")
	public String welcome () {
		return "Welcome to the DevHunters API";
	}
}
