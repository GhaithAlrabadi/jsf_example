package com.sourceallies.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sourceallies.service.EmployeeService;
import com.sourceallies.service.model.Employee;

/**
 * 
 * @author Ghaith
 * 
 */
@Controller("employeeMB")
@ViewScoped
public class EmployeeAction implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String ADD_EDIT = "addEditEmployee";
	private static final String EMPLOYEE_LIST = "employeeList";

	@NotNull(message = "Size cant be null")
	@Max(message = "Cant be more than 10", value = 10)
	@Min(value = 2, message = "Cant be less than 2")
	Integer resultSize;

	// Spring Employee Service is injected...
	@Autowired
	EmployeeService employeeService;
	Employee employee;
	List<Employee> employeeList;
	Long employeeNumber;

	/******** Actions ***********************/

	public String goToEditEmployee(Employee employee) {
		this.employee = employee;
		if (employee.getReportsTo() == null) {
			employee.setReportsTo(new Employee());
		}
		return ADD_EDIT;
	}

	public String goToAddEmployee() {
		employee = new Employee();
		employee.setReportsTo(new Employee());
		return ADD_EDIT;
	}

	public void deleteEmployee(Employee employee) {
		employeeService.deleteEmployee(employee);
	}

	public String save() {
		if (employee.getReportsTo() != null && employee.getReportsTo().getEmployeeNumber() == -1) {
			employee.setReportsTo(null);
		}
		if (employee.getEmployeeNumber() != null) {
			employeeService.updateEmployee(employee);
		} else {
			employeeService.addEmployee(employee);
		}
		return EMPLOYEE_LIST;
	}

	/**
	 * Get Employee List
	 * 
	 * @return List - Employee List
	 */
	public List<Employee> getEmployeeList() {
		employeeList = new ArrayList<Employee>();
		employeeList.addAll(getEmployeeService().getEmployees());
		return employeeList;
	}

	private void preparEmployee(Long employeeNumber) {
		if (employeeNumber != null) {
			employee = employeeService.getEmployeeById(employeeNumber);
			if (employee.getReportsTo() == null) {
				employee.setReportsTo(new Employee());
			}
		}
	}

	/**
	 * Get Employee Service
	 * 
	 * @return EmployeeService - Employee Service
	 */
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	/**
	 * Set Employee Service
	 * 
	 * @param EmployeeService
	 *            - Employee Service
	 */
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 * Set Employee List
	 * 
	 * @param List
	 *            - Employee List
	 */
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getResultSize() {
		return resultSize;
	}

	public void setResultSize(Integer resultSize) {
		this.resultSize = resultSize;
	}

	public Long getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Long employeeNumber) {
		preparEmployee(employeeNumber);
		this.employeeNumber = employeeNumber;
	}

}