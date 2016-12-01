package boot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import boot.service.DeptManagerService;


@RestController
public class SampleRestController {
	
	@Autowired
	private DeptManagerService deptManagerService;
	
	@GetMapping("/hello") 
	public String hello(){
		return "Hola Mundo";
	}

}
