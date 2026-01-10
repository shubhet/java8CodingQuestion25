package javaStringList2601;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeOperation {

    public static void main(String[] args) {
        List<EmployeeDto> list = List.of(
                new EmployeeDto(1, "Alice", "HR", 60000),
                new EmployeeDto(2, "Bob", "IT", 75000),
                new EmployeeDto(3, "Charlie", "Finance", 80000),
                new EmployeeDto(4, "David", "IT", 72000),
                new EmployeeDto(5, "Eve", "HR", 65000),
                new EmployeeDto(6, "Frank", "Finance", 90000),
                new EmployeeDto(7, "Grace", "IT", 78000),
                new EmployeeDto(8, "Heidi", "HR", 62000),
                new EmployeeDto(9, "Ivan", "Finance", 85000),
                new EmployeeDto(10, "Judy", "IT", 77000),
                new EmployeeDto(11, "Julie", "HR", 60000

                ));

        //employee department wise grouping
        System.out.println("Employee department wise grouping:");
        Map<String, List<EmployeeDto>> employeeDepartmentWise = list.stream().collect(Collectors.groupingBy(EmployeeDto::getDepartment, Collectors.toList()));

        employeeDepartmentWise.forEach((i, j) -> System.out.println(i + " : " + j));


        //department wise average salary
        Map<String, Double> departmentWiseAverageSalary = list.stream().collect(Collectors.groupingBy(EmployeeDto::getDepartment, Collectors.averagingDouble(EmployeeDto::getSalary)));
        departmentWiseAverageSalary.forEach((i, j) -> System.out.println("Department: " + i + ", Average Salary: " + j));

        //Each department wise highest salary of employee

        Map<String, EmployeeDto> departmentWiseHighestSalary = list.stream().collect(Collectors.groupingBy(EmployeeDto::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(EmployeeDto::getSalary)), Optional::get)
        ));

        departmentWiseHighestSalary.forEach((i, j) ->
                System.out.println("Department: " + i + ", Employee with Highest Salary: " + j));


        //department wise top3 highest salary of employee
        Map<String, List<EmployeeDto>> departmentWiseTop3SalaryPerson = list.stream().collect(Collectors.groupingBy(EmployeeDto::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        data -> data.stream().sorted(Comparator.comparing(EmployeeDto::getSalary).reversed()).limit(3).collect(Collectors.toList()

                        ))));

        departmentWiseTop3SalaryPerson.forEach((i, j) ->
                System.out.println("Department: " + i + ", Top 3 Employees with Highest Salary: " + j)
        );


    }
}
