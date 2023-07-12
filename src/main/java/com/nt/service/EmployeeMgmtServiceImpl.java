package com.nt.service;

import java.util.List;

import com.nt.dao.EmployeeDAOImpl;
import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
    private IEmployeeDAO empDAO;
    public EmployeeMgmtServiceImpl() {
    	empDAO=new EmployeeDAOImpl();
    }
	@Override
	public List<Employee> fetchEmployeesByDesg(String desg) throws Exception {
		// use DAO
		List<Employee>listEmps=empDAO.getAllEmployees(desg);
		//calcaulate gross and net salaries
		listEmps.forEach(emp->{
		emp.setGrossSalary(emp.getSalary()+(emp.getSalary()*.04f));
		emp.setNetSalary(emp.getGrossSalary()-(emp.getGrossSalary()*0.1f));
		});
		
		return listEmps;
	}//method

}//class
