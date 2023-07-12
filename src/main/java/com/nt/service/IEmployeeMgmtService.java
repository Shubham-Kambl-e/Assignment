package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
   public  List<Employee> fetchEmployeesByDesg(String desg)throws Exception;
	
}

