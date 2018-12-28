package com.ajg.employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HRMSUP
{
	private static Connection connection = null;
		
	public static void main(String[] args)
	{
		connection = ConnectionBuilder.getconnection();	
		/*
		HashMap<Integer, Employee> map = HRMSUP.getAllEmployees();	
		if(map == null)
		{
			System.out.println("Map returns null");
		}
		for(Integer i : map.keySet() )
		{
			Employee emps = map.get(i);
			emps.printemp();
		}
		*/
		
		HashMap<Integer, List<Employee>> printhashmap = HRMSUP.getAllEmployeesByDept();		
		if(printhashmap == null)
		{
			System.out.println("Map returns null");
		}
		for(Integer k : printhashmap.keySet())
		{
			System.out.println("");
			System.out.println("The dept id  "+k);
			System.out.println("===========================================");
			for(Employee l : printhashmap.get(k))
			{
				l.printemp();			
			}
			System.out.println("===========================================");
		}  
			
	}

/**
 * HashMap with empId as Key and corresponding employee object as value	
 * @return
 */
	public static HashMap<Integer, Employee> getAllEmployees()
	{
		HashMap<Integer, Employee> hashmap = new HashMap<>();
		
		Statement statement = null;
		ResultSet result = null;
		
		try {
				statement = connection.createStatement();
				result = statement.executeQuery("Select * from Employee");
				
				if(statement == null || result == null) 
				{
					System.out.println("Statement or ResultSet is Null");
				}
				else
				{
					while(result.next())
					{
						Employee empobj =  new Employee();
						empobj.setEmpId(result.getInt(1));
						empobj.setFirstName(result.getString(2));
						empobj.setLastName(result.getString(3));
						empobj.setAge(result.getInt(4));
						empobj.setDateOfBirth(result.getString(5));
						empobj.setGender(result.getString(6));
						empobj.setDeptId(result.getInt(7));
						empobj.setExperience(result.getInt(8));
						empobj.setSalary(result.getDouble(9));
						empobj.setJoiningDate(result.getDate(10));
						hashmap.put(result.getInt(1), empobj);
				
					}	
				}
			} catch (SQLException e)
			{
				System.out.println("Error in Query Execution");
			}			
		return hashmap;	
	}	
	
  /**
  * HashMap with deptID as Key and corresponding List of Employees as value
  */
	public static HashMap<Integer, List<Employee>> getAllEmployeesByDept()
	{
		HashMap<Integer, List<Employee>> hashmap = new HashMap<>();
		List<Integer> deptlist = new ArrayList<>();
		
		Statement statement = null;
		ResultSet result = null;
		try 
		{
			statement = connection.createStatement();
			result = statement.executeQuery("Select DeptId from Employee group by deptId");
			if(statement == null || result == null)
			{
				System.out.println("Statement or ResultSet is Null");
			}
			else
			{
			while(result.next())
				{
					deptlist.add(result.getInt("deptId"));
				}
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		for(Integer j : deptlist)
		{
			List<Employee> emplist = new ArrayList<>();
			try {
				result = statement.executeQuery("select * from Employee where deptId = "+j);
				if(statement == null || result == null)
				{
					System.out.println("ResultSet is Null");
				}
				else
				{
					while(result.next())			
					{
						Employee empobjdept = new Employee(); 			// Employee obj to store the employee details ;
						empobjdept.setEmpId(result.getInt(1));
						empobjdept.setFirstName(result.getString(2));
						empobjdept.setLastName(result.getString(3));
						empobjdept.setAge(result.getInt(4));
						empobjdept.setDateOfBirth(result.getString(5));
						empobjdept.setGender(result.getString(6));
						empobjdept.setDeptId(result.getInt(7));
						empobjdept.setExperience(result.getInt(8));
						empobjdept.setSalary(result.getDouble(9));
						empobjdept.setJoiningDate(result.getDate(10));
						
						emplist.add(empobjdept);
					}
				}
				} catch (SQLException e) 
				{
					System.out.println("SQL exception on fetching List of employee");
					e.printStackTrace();
				}
				hashmap.put(j, emplist);
		}
//System.out.println(hashmap);
		
		return  hashmap;	
	}	
}