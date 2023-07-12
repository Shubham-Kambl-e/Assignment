package com.nt.controller;

import java.io.IOException;
import java.util.List;

import com.nt.model.Employee;
import com.nt.service.EmployeeMgmtServiceImpl;
import com.nt.service.IEmployeeMgmtService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/controller")
public class EmployeeOperationController extends HttpServlet {
    private IEmployeeMgmtService service;
		
   
    @Override
    public void init() throws ServletException {
    	service=new EmployeeMgmtServiceImpl();
    	
    }
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//read form data
		String desg=req.getParameter("desg");
		String action =req.getParameter("source");
		try {
		//invoke the service class method
		List<Employee> listEmps=service.fetchEmployeesByDesg(desg);
		//keep the result in request scope
		req.setAttribute("empData", listEmps);
		
		//forward the control to view jsp page based on the button the is used to submit the request
		String target=null;
		if(action.equalsIgnoreCase("HTML"))
			target="html_screen.jsp";
		else if(action.equalsIgnoreCase("EXCEL"))
			target="excel_screen.jsp";
		
		//forward the request to target page
		RequestDispatcher rd = req.getRequestDispatcher(target);
		rd.forward(req, res);
		
	}//try
	catch(Exception e) {
		RequestDispatcher rd=req.getRequestDispatcher("/error.jsp");
		rd.forward(req, res);
		e.printStackTrace();
		//forward the request
	}
		
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
}//class
