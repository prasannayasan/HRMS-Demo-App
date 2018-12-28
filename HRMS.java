package com.ajg.employee;

import java.sql.*;

public class HRMS
{
private static Connection connection = null;
	
	public static void main(String[] args)
	{
		connection = ConnectionBuilder.getconnection();
		
		Employee emp = HRMS.getemployeebyid(10);    // calling the getEmployee method
		
		if(emp != null && emp.getEmpId() != 0)
		{
			System.out.println(emp.toString());
		}	
		
		
		Employee newEmployee = new Employee();
		newEmployee.setFirstName("Amirtha");
		newEmployee.setLastName("Kanan");
		newEmployee.setAge(45);
		newEmployee.setDeptId(103);
		newEmployee.setExperience(10);
		newEmployee.setGender("Female");
		newEmployee.setSalary(35800.56);	
		newEmployee.setDateOfBirth("1972-08-29");	
		 
		Boolean insertQueryResponse = HRMS.insertEmployee(newEmployee);      // calling the insertEmployee method
		System.out.println(insertQueryResponse);
		
		
		Employee employee = new Employee();
		employee.setEmpId(4);
		employee.setFirstName("Sharuk");
		employee.setLastName("Khan");
		employee.setAge(36);
		employee.setDateOfBirth("1983-09-17");
		employee.setGender("male");
		employee.setDeptId(103);
		employee.setExperience(9);
		employee.setSalary(19999);
		
		Boolean updateQueryResponse = HRMS.updateEmployee(employee);           // calling the updateEmployee method
		System.out.println(updateQueryResponse);
	}
/**
 * @param empId
 * select statement is passed on query.
 * Resultset gets all the details and stores them into emp object using setters.
 * @return emp  
 */
	public static Employee getemployeebyid(int empId)
	{
		Employee emp = new Employee();
		
			Statement statement = null;
			ResultSet result = null;
		try {
				statement = connection.createStatement();
			 	result = statement.executeQuery("select * from employee where empId ="+empId);      
				if(result == null) 
				{
					System.out.println("Null value is passed");
				}
				else if(result.next())
				{
					emp.setEmpId(result.getInt(1));
					emp.setFirstName(result.getString(2));
					emp.setLastName(result.getString(3));
					emp.setAge(result.getInt(4));
					emp.setDateOfBirth(result.getString(5));
					emp.setGender(result.getString(6));
					emp.setDeptId(result.getInt(7));
					emp.setExperience(result.getInt(8));
					emp.setSalary(result.getDouble(9));
					emp.setJoiningDate(result.getDate(10));	
			
				}
				else
				{
					System.out.println("Employee doesnot exist");
				}
				
			} catch (Exception e) 
			{
				System.out.println("Error Occured On Selection");
			
			}	
		finally 
			{
			try {
					statement.close();
					result.close();
				} catch (SQLException e)
				{
					System.out.println("Exception on closing Statement & resultSet");
				}
			}
			return emp;
	}
	
/**
 * 	
 * @param newemployee
 * insert query is passed on PrepareStatement.
 * newemployee object is used to get all the data from the void main.  
 * @return boolean
 */
	public static Boolean insertEmployee(Employee newemployee)
	{		
			PreparedStatement preparedstatement = null;
			if(newemployee.firstName != null && newemployee.lastName != null && newemployee.age != 0 && newemployee.deptId !=0 && newemployee.experience != 0 && newemployee.gender != null && newemployee.salary != 0 && newemployee.dateOfBirth != null)
			{
			try {
				preparedstatement = connection.prepareStatement("insert into employee(FirstName, LastName, Age, Gender, DeptId, Experience, Salary, DateOfBirth) values (?,?,?,?,?,?,?,?)");
				preparedstatement.setString(1, newemployee.getFirstName());
				preparedstatement.setString(2, newemployee.getLastName());
				preparedstatement.setInt(3, newemployee.getAge());
				preparedstatement.setString(4, newemployee.getGender());
				preparedstatement.setInt(5, newemployee.getDeptId());
				preparedstatement.setInt(6, newemployee.getExperience());
				preparedstatement.setDouble(7, newemployee.getSalary());
				preparedstatement.setString(8,  newemployee.getDateOfBirth());
				
				preparedstatement.execute();	
				System.out.println("1 row(s) affected");
				} 
				catch (Exception e) 
				{
					System.out.println("Error Occured On Insertion");
					e.printStackTrace();
				}
				finally 
				{
				try {
						preparedstatement.close();
					} catch (SQLException e) 
					{
						System.out.println("Exception on closing prepareStatement");
					}
				}
			}
			else
			{
				System.out.println("Null value inserted on new employee");
			}
		return true;
	}

/**
* @param employee
* update statement is passed on query.
* gets the data from the passed object and makes changes for the required column 
* @return boolean
*/
	public static boolean updateEmployee(Employee employee)
	{
		Statement statement = null;
		if(employee.getFirstName() != null && employee.lastName != null && employee.age != 0 && employee.deptId !=0 && employee.experience != 0 && employee.gender != null && employee.salary != 0 && employee.dateOfBirth != null) 
		{
			try {
				statement = connection.createStatement();
				statement.executeUpdate("update employee set Salary ="+employee.getSalary()+ "where empId = " +employee.getEmpId());
				System.out.println("1 row(s) affected");
				} catch (Exception e) 
				{
					System.out.println("Error Occured On Update");
				}
				finally 
				{
					try {
						statement.close();
					} catch (SQLException e) 
					{
						System.out.println("Exception on closing Statement");
					}
				}
		}
		else
		{
			System.out.println("Null values passed in the employee");
		}
		return true;
	}
}