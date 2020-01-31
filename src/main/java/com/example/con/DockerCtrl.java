package com.example.con;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myCtrl")
@Component
public class DockerCtrl {
	
	{
		System.out.println("helllllll");
	}
	
	@Value("${my.lessons.done}")
	private List<String> myList;
	
	@Value("${my.logo:India}")
	private String myLogo;
	
	@Value("${my.str}")
	private String myLogo1;
	
	@Value("#{${db.connection}}")
	private Map<String,String> myMap;
	
	@Autowired
	private DbSettings DbSettings;
	
	@Autowired
	private Environment env;
	
	@RequestMapping
	public String show() {
		return "hello:"+myLogo+"lesson done"+myList+"mapppppp"+myMap+"db"+DbSettings.getConnection()+"sssssssss"+myLogo1;
		
	}
	
	@RequestMapping("/myEnv")
	public String myEnvShow() {
		
		return env.toString();
	}

}
