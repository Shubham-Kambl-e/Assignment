package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.model.Employee;

public class EmployeeDAOImpl implements IEmployeeDAO {
   private static final String GET_EMPS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB=? ORDER BY JOB";
	
	/*
	 * private Connection makeConnection()throws Exception{
	 * Class.forName("oracle.jdbc.driver.OracleDriver"); Connection con =
	 * DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system",
	 * "tiger"); return con; }
	 */
   @Override
	public List<Employee> getAllEmployees(String desg) throws Exception {
		//get pooled jdbc con object
	   List<Employee>list=null;
		try(Connection con =getPooledConnection();
				PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_DESG);){
			//set values to query params
			ps.setString(1, desg);
			//send and execute the SQL Query
			try(ResultSet rs=ps.executeQuery()){
				//copy ResultSet object records to List Collection
				list=new ArrayList<Employee>();
				while(rs.next()) {
					//copy each record of RS onject to BO class object
					Employee emp=new Employee();
					emp.setEno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setJob(rs.getNString(3));
					emp.setSalary(rs.getDouble(4));
					
					//add model class object to ListBO
					list.add(emp);
				}//while
			} //try2
			}//try1
			catch (Exception e) {
				e.printStackTrace();
				throw e;//Exception rethrowing
			}
		return list;
	}//method
	
	//helper method in DAO class
	private Connection getPooledConnection() throws Exception{
		//create InitialContect object
		InitialContext ic = new InitialContext();
		//perform lookup operation
		DataSource ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		//get pooled jdbc connection object
		Connection con = ds.getConnection();
		return con;
	}//method

}//class
