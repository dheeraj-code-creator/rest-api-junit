package com.springboot.rest.service;

import com.springboot.rest.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    List<Employee> employeeList = Arrays.asList(
            new Employee("Bob", 21, 1000),
            new Employee("Tom", 31, 5000),
            new Employee("Lisa", 25, 3000),
            new Employee("Hary", 11, 4000)
    );

    public List<Employee> getEmployeeForSecondHighestSalary(List<Employee> employeeList){
        List<Employee> list = employeeList.stream().sorted((o1, o2) -> o2.getEmpSalary() - o1.getEmpSalary())
                .collect(Collectors.toList());
        return list.stream().skip(1).limit(1).collect(Collectors.toList());
    }

}
