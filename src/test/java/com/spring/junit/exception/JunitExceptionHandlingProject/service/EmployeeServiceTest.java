package com.spring.junit.exception.JunitExceptionHandlingProject.service;


import com.spring.junit.exception.JunitExceptionHandlingProject.model.Employee;
import com.spring.junit.exception.JunitExceptionHandlingProject.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceTest {

    // dummy data
    @Mock
    private EmployeeRepository repository;

    // dummy service for injecting data
    @InjectMocks
    private EmployeeServiceImpl service;


    // before each test case, ready the mocked data
    @Before
    public void setup(){

        MockitoAnnotations.openMocks(this);
    }



    @Test
    public void getAllEmployees(){
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(1, "Alice", "asdf@email.com", "3wergw5erge"));
        employeeList.add(new Employee(2, "Bob", "asdf@email.com", "3wergw5erge"));
        employeeList.add(new Employee(3, "Vsdfsa", "asdf@email.com", "3wergw5erge"));


        when(repository.findAll()).thenReturn(employeeList);

        List<Employee> employeesResult = service.getEmployees();

        assertEquals(3, employeesResult.size());
    }


    @Test
    public void getEmployeeById(){

        Employee employee = new Employee(1, "Alice", "asdf@email.com", "3wergw5erge");

        when(repository.findById(1L)).thenReturn(Optional.of(employee));

        Employee employeeResult = service.getEmployeeById(1L);

        assertEquals(1, employeeResult.getId());
        assertEquals("Alice", employeeResult.getName());
        assertEquals("asdf@email.com", employeeResult.getEmail());
    }


    @Test
    public void saveEmployee(){

        Employee employee = new Employee(1, "Alice", "asdf@email.com", "3wergw5erge");

        when(repository.save(employee)).thenReturn(employee);

        Employee employeeResult = service.saveEmployee(employee);

        assertEquals(1, employeeResult.getId());
        assertEquals("Alice", employeeResult.getName());
        assertEquals("asdf@email.com", employeeResult.getEmail());
    }

    @Test
    public void deleteEmployeeById(){

        Employee employee = new Employee(1, "Alice", "asdf@email.com", "3wergw5erge");

        service.removeEmployee(employee.getId());

        verify(repository, times(1)).deleteById(employee.getId());

    }

    @Test
    public void deleteEmployeeById2(){
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(0, "Alice", "asdf@email.com", "3wergw5erge"));

        when(repository.findAll()).thenReturn(employeeList);


        service.removeEmployee(0L);
        employeeList.remove(0);

        assertEquals(0, service.getEmployees().size());



    }

}
