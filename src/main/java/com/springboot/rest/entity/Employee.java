package com.springboot.rest.entity;

public class Employee {

    private String empName;
    private int empAge;
    private int empSalary;

    public Employee(String empName, int empAge, int empSalary) {
        this.empName = empName;
        this.empAge = empAge;
        this.empSalary = empSalary;
    }

    public String getEmpName() {
        return empName;
    }

    public int getEmpAge() {
        return empAge;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empAge=" + empAge +
                ", empSalary=" + empSalary +
                '}';
    }
}
