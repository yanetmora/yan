package boot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Title;
import boot.service.TitleService;

@Controller
public class TitleController {
	
	@Autowired
	private TitleService titleService;
	
	@GetMapping("/all-titles")
	public String allTitles(HttpServletRequest request){
		request.setAttribute("titles", titleService.findAll());
		request.setAttribute("mode", "MODE_TITLES");
		return "title";
	}
	
	@GetMapping("/new-title")
	public String newTitle(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_TITLE");
		return "title";
	}
	
	@PostMapping("/save-title")
	public String saveTitle(@ModelAttribute Title title, BindingResult bindingResult, HttpServletRequest request){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = null;
		Date toDate = null;
		try {
			fromDate = format.parse(request.getParameter("fromDate"));
			toDate = format.parse(request.getParameter("toDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		title.setFromDate(fromDate);
		title.setToDate(toDate);
		
		titleService.save(title);
	
		request.setAttribute("titles", titleService.findAll());
		request.setAttribute("mode", "MODE_TITLES");
		return "title";
	}
	
	@GetMapping("/update-title")
	public String updateTitle(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("title", titleService.findTitle(id));
		request.setAttribute("mode", "MODE_UPDATE_TITLE");
		return "title";
	}
	
	@GetMapping("/delete-title")
	public String deleteTitle(@RequestParam int id, HttpServletRequest request){
		titleService.delete(id);
		request.setAttribute("titles", titleService.findAll());
		request.setAttribute("mode", "MODE_TITLES");
		return "title";
	}
}
