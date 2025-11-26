package EmployeeDepartment;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeEntityMain {

    public static void main(String[] args) {
        List<EmployeeEntity> list = new ArrayList<>();
        list.add(new EmployeeEntity(1, "AAA", "HR", 50000));
        list.add(new EmployeeEntity(2, "BBB", "IT", 90000));
        list.add(new EmployeeEntity(3, "CCC", "Finance", 55000));
        list.add(new EmployeeEntity(4, "DDD", "HR", 80000));
        list.add(new EmployeeEntity(5, "EEE", "IT", 70000));
        list.add(new EmployeeEntity(6, "FFF", "Finance", 45000));

        //department  wise highest salary

        Map<String, Optional<EmployeeEntity>> map = list.stream().collect(Collectors.groupingBy(EmployeeEntity::getDepartment, Collectors.maxBy(Comparator.comparingDouble(EmployeeEntity::getSalary))));

        map.forEach((i, j) -> System.out.println(i + " " + j.get().getName() + " " + j.get().getSalary()));


        //employee data with reverse id

       list.stream().sorted(Comparator.comparingDouble(EmployeeEntity::getId).reversed()).collect(Collectors.toList()).forEach(System.out::println);


       //department wise top3 highest salary with Employee object

      Map<String, List<EmployeeEntity>> mapValue =  list.stream().collect(Collectors.groupingBy(EmployeeEntity::getDepartment,
                Collectors.collectingAndThen(Collectors.toList(),
                        empList-> empList.stream().sorted(Comparator.comparingDouble(EmployeeEntity::getSalary).reversed()).limit(3).collect(Collectors.toList()))));

      mapValue.forEach((i, j)-> System.out.println("Department"+i+" === "+j+"Employee"));


        //department wise top3 highest salary with Employee id only

        mapValue.forEach((i, j)->
                System.out.println("Department "+i+"==== "+j.stream().map(EmployeeEntity::getId).toList())
         );

    }
}