package com.sourceallies.service;

import java.util.List;
import java.util.Map;

import com.sourceallies.service.model.Employee;

/**
 * 
 * Employee Service Interface
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */
public interface EmployeeService {

	/**
	 * Add Employee
	 * 
	 * @param Employee
	 *            employee
	 */
	public void addEmployee(Employee employee);

	/**
	 * Update Employee
	 * 
	 * @param Employee
	 *            employee
	 */
	public void updateEmployee(Employee employee);

	/**
	 * Delete Employee
	 * 
	 * @param Employee
	 *            employee
	 */
	public void deleteEmployee(Employee employee);

	/**
	 * Get Employee
	 * 
	 * @param int Employee Id
	 */
	public Employee getEmployeeById(Long id);

	/**
	 * Get Employee List
	 * 
	 * @return List - Employee list
	 */
	public List<Employee> getEmployees();

	/**
	 * 
	 * @param startIndex
	 * @param pageSize
	 * @param sortField
	 * @param sortOrder
	 * @param filters
	 * @return
	 */
	public List<Employee> getEmployees(int startIndex, int pageSize, String sortField, String sortOrder,
			Map<String, String> filters);
	
	public Integer getMaxEmployeesNumber();

}
