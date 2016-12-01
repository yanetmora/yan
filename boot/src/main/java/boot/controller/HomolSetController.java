package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.HomolSet;
import boot.service.HomolSetService;


@Controller
public class HomolSetController {
	
	@Autowired
	private HomolSetService homolSetService;
	
	@GetMapping("/all-homolSets")
	public String allHomolSets(HttpServletRequest request){
		request.setAttribute("homolsets", homolSetService.findAll());
		request.setAttribute("mode", "MODE_HOMOLSETS");
		return "homolSet";
	}
	
	@GetMapping("/new-homolSet")
	public String newHomolSet(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_HOMOLSET");
		return "homolSet";
	}
	
	@PostMapping("/save-homolSet")
	public String saveHomolSet(@ModelAttribute HomolSet homolSet, BindingResult bindingResult, HttpServletRequest request){
		homolSetService.save(homolSet);
		request.setAttribute("homolSets", homolSetService.findAll());
		request.setAttribute("mode", "MODE_HOMOLSETS");
		return "homolSet";
	}
	
	@GetMapping("/update-homolSet")
	public String updateHomolSet(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("homolSet", homolSetService.findHomolSet(id));
		request.setAttribute("mode", "MODE_UPDATE_HOMOLSET");
		return "homolSet";
	}
	
	@GetMapping("/delete-homolSet")
	public String deleteHomolSet(@RequestParam int id, HttpServletRequest request){
		homolSetService.delete(id);
		request.setAttribute("homolSets", homolSetService.findAll());
		request.setAttribute("mode", "MODE_HOMOLSETS");
		return "homolSet";
	}
}
