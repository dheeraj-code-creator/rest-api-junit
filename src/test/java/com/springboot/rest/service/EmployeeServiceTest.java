package com.springboot.rest.service;

import com.springboot.rest.entity.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService= Mockito.mock(EmployeeService.class);

    // two ways to write test either use Stream.of() method for static values or use list.
    /*@Test
    public void getEmployeeForSecondHighestSalaryTest(){
        List<Employee> list = new ArrayList();
        Mockito.when(employeeService.getEmployeeForSecondHighestSalary(list))
                .thenReturn(Stream.of(new Employee("A", 21, 1000),
                                      new Employee("B", 31, 2000),
                                      new Employee("C", 41, 3000))
                .collect(Collectors.toList()));
        // check list is not null
        Assert.assertNotNull(employeeService.getEmployeeForSecondHighestSalary(list));
        // check list size
        Assert.assertEquals(3, employeeService.getEmployeeForSecondHighestSalary(list).size());
        // check second highest salary
        Assert.assertEquals(2000, employeeService.getEmployeeForSecondHighestSalary(list)
                                          .get(1).getEmpSalary());

    }*/

    @Test
    public void getEmployeeForSecondHighestSalaryTest(){
        List<Employee> list = Arrays.asList(new Employee("A", 21, 1000),
                                            new Employee("B", 31, 2000),
                                            new Employee("C", 41, 3000));
        Mockito.when(employeeService.getEmployeeForSecondHighestSalary(list))
                .thenReturn(list);
        // check list is not null
        Assert.assertNotNull(employeeService.getEmployeeForSecondHighestSalary(list));
        // check list size
        Assert.assertEquals(3, employeeService.getEmployeeForSecondHighestSalary(list).size());
        // check second highest salary
        Assert.assertEquals(2000, employeeService.getEmployeeForSecondHighestSalary(list)
                .get(1).getEmpSalary());

    }

}
