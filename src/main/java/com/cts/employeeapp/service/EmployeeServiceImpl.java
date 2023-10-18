package com.cts.employeeapp.service;

import com.cts.employeeapp.exception.DuplicateEmployeeException;
import com.cts.employeeapp.model.Employee;
import com.cts.employeeapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        // check if employee exists
        // throw DuplicateEmployeeException if employee exists

        if(repository.existsById(employee.getEmpId())) {
            throw new DuplicateEmployeeException("Employee with name " + employee.getEmpName() + " already exists");
        }
        return repository.save(employee);

    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
    @Override
    public Employee getEmployeeById(int id) {
        return repository.findById(id).orElse(null);

    }

    @Override
    public void deleteEmployeeById(int id) {
        // check if employee exists
        // throw EmployeeNotFoundException if employee does not exist
        if(!repository.existsById(id)) {
            throw new RuntimeException("Employee with id " + id + " does not exist");
        }

        repository.deleteById(id);


    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee getEmployeeByName(String name) {

        return repository.findByEmpName(name);
    }


    @Override
    public List<Employee> getEmployeesBySalaryRange(double min, double max) {
        return repository.findByEmpSalaryBetween(min,max);
    }

    @Override
    public Employee getEmployeeByEmpNameAndEmpSalary(String empName, double empSalary) {

        return repository.findByEmpNameAndEmpSalary(empName,empSalary);
    }


}
