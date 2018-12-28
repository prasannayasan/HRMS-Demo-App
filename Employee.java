/**
 * 
 */
package com.ajg.employee;

import java.sql.Date;

/**
 * @author yasan
 *
 */
public class Employee 
{
	int empId;
	String firstName;
	String lastName;
	int age;
	String gender;
	int deptId;
	int experience;
	double salary;
	String dateOfBirth;
	Date joiningDate;
	String createdBy;
	Date createdDate;
	String lastModifiedBy;
	Date lastModifiedDate;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getJoiningDate() {
		return (Date) this.joiningDate.clone();
	}
	public void setJoiningDate(Date date) {
		this.joiningDate = (Date) date.clone();
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}	
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	@Override
	public String toString() 
	{
		return "Employee [empId = " + empId + ", firstName = " + firstName + ", lastName = " + lastName + ", age = " + age + ", dateOfBirth = " + dateOfBirth + ", gender = " + gender + ", deptId = " + deptId + ", experience = " + experience
				+ ", salary = " + salary  + ", joiningDate = " + joiningDate + ", createdBy = " + createdBy + ", createdDate = " + createdDate + ", lastModifiedBy = " + lastModifiedBy + ", lastModifiedDate = " + lastModifiedDate + "]";
	}
	
	public void printemp()
	{
		System.out.println("EmployeeId " +empId+ "'s Details");
		System.out.println("****************************");
		System.out.println("");
		System.out.println(" FirstName   :  "+firstName);
		System.out.println(" LastName    :  "+lastName);
		System.out.println(" Age         :  "+age);
		System.out.println(" DateOfBirth :  "+dateOfBirth);
		System.out.println(" Gender      :  "+gender);
		System.out.println(" DeptId      :  "+deptId);
		System.out.println(" Experience  :  "+experience);
		System.out.println(" Salary      :  "+salary);
		System.out.println(" JoiningDate :  "+joiningDate);
		System.out.println("");
		System.out.println("****************************");
		System.out.println("");
	}
}
