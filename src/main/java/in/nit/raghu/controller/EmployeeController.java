package in.nit.raghu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.raghu.entity.Employee;
import in.nit.raghu.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service; // HAS-A
	
	@GetMapping("/register")
	public String displayRegister() {
		return "EmployeeRegister";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee employee,Model model) {
		Integer id=service.saveEmployee(employee);
        String message = "Employee '"+id+"' Created";
        model.addAttribute("message",message);
        System.out.println(message);
		return "EmployeeRegister";
		
	}
	
	@GetMapping("/showlist")
	public String viewAllEmployee(Model model) {
		List<Employee> list=service.getAllEmployee();
		model.addAttribute("list",list);
		return "EmployeeData";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam Integer id,Model model) {
		service.deleteEmployee(id);
		String message = "Employee '"+id+"' Deleted";
		model.addAttribute("message", message);
		
		List<Employee> list=service.getAllEmployee();
		model.addAttribute("list",list);
		return "EmployeeData";
	}
	
	@GetMapping("/edit")
	public String showEmployeeEdit(@RequestParam Integer id,Model model) 
	{
		Employee employee = service.getOneEmployee(id);
		model.addAttribute("employee", employee);
		return "EmployeeEdit";
	}
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee) 
	{
		service.updateEmployee(employee);
		return "redirect:showlist";
	}
	
	
}
