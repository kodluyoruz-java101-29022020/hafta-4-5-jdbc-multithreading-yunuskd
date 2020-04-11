package db.connection.mysql.connection.service;

import java.util.Set;

import db.connection.mysql.connection.dao.EmployeeDAO;
import db.connection.mysql.connection.model.Employee;
import db.connection.mysql.connection.model.EmployeeProfile;

public class EmployeeService {

	private EmployeeDAO employeeDAO;
	
	public EmployeeService(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	public Employee save(Employee employee) {
		
		 Long maxEmployeeId = this.employeeDAO.getMaxId();
		 employee.setId(maxEmployeeId);
		 return this.employeeDAO.save(employee);
	}
	
	public Employee findById(Long empNo) {
		
		return this.employeeDAO.findEmployeeById(empNo);
	}
	
	public Set<Employee> findAll() {
		
		return this.employeeDAO.getAll();
	}
	
	public EmployeeProfile loadEmployeeProfile(Long empNo) {
		
		EmployeeProfile employeeProfile = this.employeeDAO.loadEmployeeProfile(empNo);
		return employeeProfile;
	}
	
	public Employee update(Long empNo, String name, String lastName) {
		
		Employee employee = this.employeeDAO.findEmployeeById(empNo);
		
		if(employee == null) {
			return employee;
		}
		
		employee.setName(name);
		employee.setLastName(lastName);
		return this.employeeDAO.update(employee);
	}
	
	public boolean delete(Long empNo) {
		
		return this.employeeDAO.delete(empNo);
	}
	
}
