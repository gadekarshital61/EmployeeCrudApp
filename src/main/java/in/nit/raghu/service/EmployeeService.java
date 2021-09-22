package in.nit.raghu.service;

import java.util.List;

import in.nit.raghu.entity.Employee;

public interface EmployeeService {

	public Integer saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public void deleteEmployee(Integer id);
	
	public Employee getOneEmployee(Integer id);
	
	public void updateEmployee(Employee e);
	
}
