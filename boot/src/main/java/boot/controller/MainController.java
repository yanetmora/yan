package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
 
	
	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("salary")
	public String salary(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME_SALARIES");
		return "salary";
	}
	
	@GetMapping("homolSet")
	public String homolSet(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME_HOMOLSET");
		return "homolSet";
	}
	
	@GetMapping("deptManager")
	public String deptManager(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME_DEPTMANAGER");
		return "deptManager";
	}
	
	@GetMapping("title")
	public String title(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME_TITLE");
		return "title";
	}
	
	
	
 }
