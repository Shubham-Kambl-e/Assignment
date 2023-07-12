package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDAO {
    public List<Employee> getAllEmployees(String desg)throws Exception;

}
