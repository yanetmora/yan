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

import boot.model.DeptManager;
import boot.service.DeptManagerService;


@Controller
public class DeptManagerController {
	
	@Autowired
	private DeptManagerService deptManagerService;
	
	@GetMapping("/all-deptManagers")
	public String allDeptManagers(HttpServletRequest request){
		request.setAttribute("deptManagers", deptManagerService.findAll());
		request.setAttribute("mode", "MODE_DEPTMANAGERS");
		return "deptManager";
	}
	
	@GetMapping("/new-deptManager")
	public String newDeptManager(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_DEPTMANAGER");
		return "deptManager";
	}
	
	@PostMapping("/save-deptManager")
	public String saveDeptManager(@ModelAttribute DeptManager deptManager, BindingResult bindingResult, HttpServletRequest request){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = null;
		Date toDate = null;
		try {
			fromDate = format.parse(request.getParameter("fromDate"));
			toDate = format.parse(request.getParameter("toDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		deptManager.setFromDate(fromDate);
		deptManager.setToDate(toDate);
		
		deptManagerService.save(deptManager);
	
		request.setAttribute("deptManagers", deptManagerService.findAll());
		request.setAttribute("mode", "MODE_DEPTMANAGERS");
		return "deptManager";
	}
	
	@GetMapping("/update-deptManager")
	public String updateDeptManager(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("deptManager", deptManagerService.findDeptManager(id));
		request.setAttribute("mode", "MODE_UPDATE_DEPTMANAGER");
		return "deptManager";
	}
	
	@GetMapping("/delete-deptManager")
	public String deleteDeptManager(@RequestParam int id, HttpServletRequest request){
		deptManagerService.delete(id);
		request.setAttribute("deptManagers", deptManagerService.findAll());
		request.setAttribute("mode", "MODE_DEPTMANAGERS");
		return "deptManager";
	}
}

