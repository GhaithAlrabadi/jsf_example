package com.sourceallies.jsf;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sourceallies.service.EmployeeService;
import com.sourceallies.service.model.Employee;

@Component
public class LazyLoadedTableList extends LazyDataModel<Employee> {
	@Autowired
	EmployeeService employeeService;
	int maxRowSize;

	@PostConstruct
	void init() {
		maxRowSize = employeeService.getMaxEmployeesNumber();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Employee> load(int startIndex, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, String> filters) {
		this.setRowCount(maxRowSize);
		// this is for sorting
		String sortOrderVal = "ASC";
		if (sortOrder.equals(SortOrder.DESCENDING)) {
			sortOrderVal = "DESC";
		}
		return employeeService.getEmployees(startIndex, pageSize, sortField, sortOrderVal, filters);
	}

}
