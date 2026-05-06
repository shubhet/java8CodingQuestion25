package StreamQuestions0705;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDepartmentOpr {

    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "John", "IT", 50000);
        Employee emp2 = new Employee(2, "Jane", "HR", 60000);
        Employee emp3 = new Employee(3, "Doe", "IT", 55000);
        Employee emp4 = new Employee(4, "Smith", "Finance", 70000);
        Employee emp5 = new Employee(5, "Emily", "HR", 65000);


        List<Employee> employees = Arrays.asList(emp1, emp2, emp3, emp4, emp5);

        //department wise employee count
        System.out.println("Department wise employee count");
        Map<String, Long> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));


        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
        .forEach((k,v)->System.out.println(k+" "+v));



       //department wise employee in descending order
        System.out.println("Department wise employee in descending order");

        Stream<Map.Entry<String, Long>> sorted = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()));


           employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                   .entrySet().stream().sorted((e1,e2)->e2.getValue().compareTo(e1.getValue()))
                   .forEach(i->System.out.println(i.getKey()+"  "+i.getValue()));

        System.out.println("Employee count with department name in descending order");
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()))
                .entrySet().stream().sorted((e1,e2)->e2.getKey().compareTo(e1.getKey()))
                .forEach(i->System.out.println(i.getKey()+"  "+i.getValue()));


        System.out.println("Department wise average salary");
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .forEach((k,v)->System.out.println(k+"  "+v));

        System.out.println("Department wise employee with highest salary");
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
                .forEach((k,v)->System.out.println(k+"  "+v.get().getName()+" "+v.get().getSalary()));


        System.out.println("Department wise employee with lowest salary");
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.minBy(Comparator.comparing(Employee::getSalary))))
                .forEach((k,v)->System.out.println(k+"  "+v.get().getName()+" "+v.get().getSalary()));

        System.out.println("Department wise employee with highest salary in descending order");
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                ))
                .entrySet().stream().sorted((e1,e2)->Double.compare(e2.getValue().get().getSalary(), e1.getValue().get().getSalary()))
                .forEach(i -> System.out.println(i.getKey() + "  " + i.getValue().get().getSalary()));
    }
}
