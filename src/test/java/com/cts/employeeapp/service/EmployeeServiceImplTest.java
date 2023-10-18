package com.cts.employeeapp.service;

import com.cts.employeeapp.model.Employee;
import com.cts.employeeapp.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

    // Write test cases for EmployeeServiceImpl
    // Use Mockito to Mock EmployeeRepository

    @Mock
    EmployeeRepository repository;

    @InjectMocks
    EmployeeServiceImpl service;

   @Test
    public void testSaveEmployee() {

       Employee employee = new Employee();
       employee.setEmpId(1);
       employee.setEmpName("John");
       employee.setEmpSalary(50000);

       Mockito.when(repository.save(employee)).thenReturn(employee);
       Employee savedEmployee = service.saveEmployee(employee);
       assertEquals(savedEmployee, employee);
       verify(repository, times(1)).save(employee);

   }


   @Test
    public void testFindEmployeeById() {
       Employee employee = new Employee();
       employee.setEmpId(1);
       employee.setEmpName("John");
       employee.setEmpSalary(50000);

       Mockito.when(repository.findById(1)).thenReturn(java.util.Optional.of(employee));
       Employee foundEmployee = service.getEmployeeById(1);
       assertEquals(foundEmployee, employee);
       verify(repository, times(1)).findById(1);
   }

   @Test
    public void testFindAllEmployees() {
       Employee employee = new Employee();
       employee.setEmpId(1);
       employee.setEmpName("John");
       employee.setEmpSalary(50000);

       Mockito.when(repository.findAll()).thenReturn(java.util.List.of(employee));
       java.util.List<Employee> foundEmployees = service.getAllEmployees();
       assertEquals(foundEmployees.size(), 1);
       verify(repository, times(1)).findAll();

   }

      @Test
    public void testDeleteEmployeeById() {
        Employee employee = new Employee();
        employee.setEmpId(1);
        employee.setEmpName("John");
        employee.setEmpSalary(50000);
        doNothing().when(repository).deleteById(1);
        Mockito.when(repository.existsById(1)).thenReturn(true);

        service.deleteEmployeeById(1);
        verify(repository, times(1)).deleteById(1);
        verify(repository, times(1)).existsById(1);

        }




}




