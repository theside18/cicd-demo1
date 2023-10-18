package com.cts.employeeapp.api;

import com.cts.employeeapp.model.Employee;
import com.cts.employeeapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApi {

    @Autowired
    private EmployeeService service;

    // create a get method to fetch all employees
    // return a list of employees
    // status code 200
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }


    // create a post method to add a new employee
    // return the newly added employee
    // status code 201
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable int id){
        return service.getEmployeeById(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployeeById(@PathVariable int id){
        service.deleteEmployeeById(id);
    }


    @GetMapping("/salary/{min}/{max}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeesBySalaryRange(@PathVariable double min,@PathVariable double max){
        return service.getEmployeesBySalaryRange(min,max);
    }


    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeByEmpName(@PathVariable String name){
        return service.getEmployeeByName(name);
    }

    @GetMapping("/name/{name}/salary/{salary}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeByEmpNameAndEmpSalary(@PathVariable String name,@PathVariable double salary){
        return service.getEmployeeByEmpNameAndEmpSalary(name,salary);
    }



    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee(@RequestBody Employee employee){
        return service.updateEmployee(employee);
    }







}
