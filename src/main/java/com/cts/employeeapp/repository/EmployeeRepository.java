package com.cts.employeeapp.repository;

import com.cts.employeeapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // find employee by empName
    Employee findByEmpName(String empName);


    Employee findByEmpNameAndEmpSalary(String empName,double empSalary);

    // find employees within a range of salary
    List<Employee> findByEmpSalaryBetween(double min, double max);


}
