package in.nit.raghu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.raghu.entity.Employee;
import in.nit.raghu.repo.EmployeeRepository;
import in.nit.raghu.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repo; ///HAS-A

	@Override
	public Integer saveEmployee(Employee employee) {
		employee=repo.save(employee);
		return employee.getId();
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list=repo.findAll();
		return list;
	}

	@Override
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		Optional<Employee> opt = repo.findById(id);
		if(opt.isPresent()) {
			Employee e = opt.get();
			return e;
		}
		// TODO : else throw exception Employee not found
		return null;
	}

	@Override
	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		repo.save(e);
	}
	
	
	
	

}
