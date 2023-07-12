package com.nt.model;

import java.io.Serializable;

import lombok.Data;
@Data
public class Employee implements Serializable{
	private Integer eno;	
	private String ename;
	private String job;
	private Double salary;
	private Double grossSalary;
	private Double netSalary;
	
}
