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

import boot.model.Salary;
import boot.service.SalaryService;



@Controller
public class SalaryController {
	
	@Autowired
	private SalaryService salaryService;
	
	@GetMapping("/all-salaries")
	public String allSalaries(HttpServletRequest request){
		request.setAttribute("salaries", salaryService.findAll());
		request.setAttribute("mode", "MODE_SALARIES");
		return "salary";
	}
	
	@GetMapping("/new-salary")
	public String newSalary(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_SALARY");
		return "salary";
	}
	
	@PostMapping("/save-salary")
	public String saveSalary(@ModelAttribute Salary salary, BindingResult bindingResult, HttpServletRequest request){

		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = null;
		Date toDate = null;
		try {
			fromDate = format.parse(request.getParameter("fromDate"));
			toDate = format.parse(request.getParameter("toDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		salary.setFromDate(fromDate);
		salary.setToDate(toDate);
		
		salaryService.save(salary);
	
		request.setAttribute("salaries", salaryService.findAll());
		request.setAttribute("mode", "MODE_SALARIES");
		return "salary";
	}
	
	@GetMapping("/update-salary")
	public String updateSalary(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("salary", salaryService.findSalary(id));
		request.setAttribute("mode", "MODE_UPDATE_SALARY");
		return "salary";
	}
	
	@GetMapping("/delete-salary")
	public String deleteSalary(@RequestParam int id, HttpServletRequest request){
		salaryService.delete(id);
		request.setAttribute("salaries", salaryService.findAll());
		request.setAttribute("mode", "MODE_SALARIES");
		return "salary";
	}
}
