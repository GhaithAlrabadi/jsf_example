package com.sourceallies.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sourceallies.service.dao.EmployeeDAO;
import com.sourceallies.service.model.Employee;

/**
 * 
 * Employee Service
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	/**
	 * Add Employee
	 * 
	 * @param Employee
	 *            employee
	 */
	public void addEmployee(Employee employee) {
		getEmployeeDAO().addEmployee(employee);
	}

	/**
	 * Delete Employee
	 * 
	 * @param Employee
	 *            employee
	 */
	public void deleteEmployee(Employee employee) {
		getEmployeeDAO().deleteEmployee(employee);
	}

	/**
	 * Update Employee
	 * 
	 * @param Employee
	 *            employee
	 */
	public void updateEmployee(Employee employee) {
		getEmployeeDAO().updateEmployee(employee);
	}

	/**
	 * Get Employee
	 * 
	 * @param int Employee Id
	 */
	public Employee getEmployeeById(Long id) {
		return getEmployeeDAO().getEmployeeById(id);
	}

	/**
	 * Get Employee List
	 * 
	 */
	public List<Employee> getEmployees() {
		return getEmployeeDAO().getEmployees();
	}

	/**
	 * Get Employee DAO
	 * 
	 * @return EmployeeDAO - Employee DAO
	 */
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	/**
	 * Set Employee DAO
	 * 
	 * @param EmployeeDAO
	 *            - Employee DAO
	 */
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public List<Employee> getEmployees(int startIndex, int pageSize, String sortField, String sortOrder,
			Map<String, String> filters) {		
		return employeeDAO.getEmployees(startIndex,pageSize,sortField,sortOrder,filters);
	}

	public Integer getMaxEmployeesNumber() {
		return employeeDAO.getMaxEmployeesNumber();
	}

}
