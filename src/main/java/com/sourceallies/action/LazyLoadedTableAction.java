package com.sourceallies.action;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sourceallies.service.model.Employee;

/**
 * 
 * @author ghaith
 * 
 */
@Controller("lazyLoadedEmployeeMB")
@ViewScoped
public class LazyLoadedTableAction implements Serializable {
	

	@Autowired
	LazyDataModel<Employee> lazyLoadedTableList;
	Employee selectedEmployee;
	
	public LazyDataModel<Employee> getLazyLoadedTableList() {
		return lazyLoadedTableList;
	}
	
	public void setLazyLoadedTableList(LazyDataModel<Employee> lazyLoadedTableList) {
		this.lazyLoadedTableList = lazyLoadedTableList;
	}
	
	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}
	
	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}
	
	

}
