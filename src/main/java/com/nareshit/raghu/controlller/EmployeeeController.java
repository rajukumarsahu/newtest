package com.nareshit.raghu.controlller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.raghu.entity.EmployeeEntity;
import com.nareshit.raghu.service.IEmployeeService;
@Controller
@ComponentScan
//@RestController
@RequestMapping("/employee")
 
public class EmployeeeController {

	@Autowired
	private IEmployeeService service;
	@GetMapping("/register")
	private String ShowReg(Model model)
	
	{
		model.addAttribute("employee",new EmployeeEntity());
		return "ShowRegisterPage"; 
	}
	//show register page
	
	//2,save employee
	
	@PostMapping("/save")
	public String saveData( 
		@ModelAttribute EmployeeEntity employee,
		 
		 Model model
		)
		{
		Integer id =service.saveEmployee(employee);
        model.addAttribute("employee",id);
		 
		return "ShowRegisterPage";
	}
	//3.display all employee
	@GetMapping("/all")
	public String ShowData(Model model)
	{

		List<EmployeeEntity>list=service.getAllEmployee();
	model.addAttribute("list",list);
	return "Employee_Details";
	}
	//4 delete emp by id
	@GetMapping("/delete")
	public String delete(
			@RequestParam Integer id
			) {
		service.deleteEmployee(id);
		return "redirect:all";
	}
	//5 show edit page
	@GetMapping("/edit")
	public String showedit(
			@RequestParam Integer id,
			Model model
			)
	{
	EmployeeEntity e =service.getoneemployee(id);
          model.addAttribute("employee",e);
		return "ShowEdit";
	}
	//6 do update
	@PostMapping("/update")
	public String doupdate(
			@ModelAttribute EmployeeEntity employee,
			Model model
			) {
		 service.updateEmployee(employee);
		return "redirect:all";
	}
}
