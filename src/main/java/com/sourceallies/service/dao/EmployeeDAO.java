package com.sourceallies.service.dao;

import java.util.List;
import java.util.Map;

import com.sourceallies.service.model.Employee;

/**
 * 
 * Employee DAO Interface
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
public interface EmployeeDAO {

	/**
	 * Add Employee
	 * 
	 * @param  Employee Employee
	 */
	public void addEmployee(Employee employee);
	
	/**
	 * Update Employee
	 * 
	 * @param  Employee Employee
	 */
	public void updateEmployee(Employee employee);
	
	/**
	 * Delete Employee
	 * 
	 * @param  Employee Employee
	 */
	public void deleteEmployee(Employee employee);
	
	/**
	 * Get Employee
	 * 
	 * @param  int Employee Id
	 */
	public Employee getEmployeeById(Long id);
	
	/**
	 * Get Employee List
	 * 
	 */
	public List<Employee> getEmployees();
	
	public List<Employee> getEmployees(int startIndex, int pageSize, String sortField, String sortOrder,Map<String, String> filters);

	public Integer getMaxEmployeesNumber();
}
