package com.sourceallies.service.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.sourceallies.service.model.Employee;

/**
 * 
 * Employee DAO
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 * 
 */

public class EmployeeDAOImpl implements EmployeeDAO {

	private SessionFactory sessionFactory;

	/**
	 * Get Hibernate Session Factory
	 * 
	 * @return SessionFactory - Hibernate Session Factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Set Hibernate Session Factory
	 * 
	 * @param SessionFactory
	 *            - Hibernate Session Factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Add Employee
	 * 
	 * @param Employee
	 *            employee
	 */

	public void addEmployee(Employee employee) {
		getSessionFactory().getCurrentSession().save(employee);
	}

	/**
	 * Delete Employee
	 * 
	 * @param Employee
	 *            employee
	 */

	public void deleteEmployee(Employee employee) {
		getSessionFactory().getCurrentSession().delete(employee);
	}

	/**
	 * Update Employee
	 * 
	 * @param Employee
	 *            employee
	 */

	public void updateEmployee(Employee employee) {
		getSessionFactory().getCurrentSession().update(employee);
	}

	/**
	 * Get Employee
	 * 
	 * @param int Employee Id
	 * @return Employee
	 */

	public Employee getEmployeeById(Long id) {
		List list = getSessionFactory().getCurrentSession().createQuery("from Employee where id=?").setParameter(0, id)
				.list();
		return (Employee) list.get(0);
	}

	/**
	 * Get Employee List
	 * 
	 * @return List - Employee list
	 */

	public List<Employee> getEmployees() {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Employee.class);
		//TODO remove this for demo
		criteria.setMaxResults(30);
		return criteria.list();
	}

	public Integer getMaxEmployeesNumber() {
		int value = 0;
		try {
			value = ((Long) getSessionFactory().getCurrentSession().createQuery("select count(*) from Employee")
					.iterate().next()).intValue();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return value;

	}

	/**
	 * method that load a runtime list lazy loaded on request.
	 * 
	 * @param startIndex
	 * @param pageSize
	 * @param sortField
	 * @param sortOrder
	 * @param filters
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees(int startIndex, int pageSize, String sortField, String sortOrder,
			Map<String, String> filters) {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Employee.class);
		criteria.setFirstResult(startIndex);
		criteria.setMaxResults(pageSize);
		setFilters(filters, criteria);
		setOrder(sortField, sortOrder, criteria);
		return criteria.list();
	}

	private void setOrder(String sortField, String sortOrder, Criteria criteria) {
		if (sortOrder.equalsIgnoreCase("ASC") && sortField != null) {
			criteria.addOrder(Order.asc(sortField));
		} else if (sortOrder.equalsIgnoreCase("DESC") && sortField != null) {
			criteria.addOrder(Order.desc(sortField));
		}
	}

	private void setFilters(Map<String, String> filters, Criteria criteria) {
		for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
			String filterProperty = it.next();
			String filterValue = filters.get(filterProperty);
			criteria.add(Restrictions.like(filterProperty, filterValue + "%"));
		}
	}

}
