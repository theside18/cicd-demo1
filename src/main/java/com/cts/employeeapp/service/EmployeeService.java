package com.cts.employeeapp.service;

import com.cts.employeeapp.model.Employee;

import java.util.List;

public interface EmployeeService {

    // Methods to be implemented by the Service Layer
    public Employee saveEmployee(Employee employee);

    // Get all employees

    public List<Employee> getAllEmployees();

    // Get employee by id

    public Employee getEmployeeById(int id);


    public void deleteEmployeeById(int id);


    public Employee updateEmployee(Employee employee);


    public Employee getEmployeeByName(String name);


    // Find employees withing a range of salary


    public List<Employee> getEmployeesBySalaryRange(double min,double max);


    public Employee getEmployeeByEmpNameAndEmpSalary(String empName,double empSalary);




}
