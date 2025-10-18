package stream131025;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;


public class EmployeeGitStatusMain {

    public static void main(String[] args) {

        List<EmployeeGitStatus> empList = Arrays.asList(
                new EmployeeGitStatus("Alice", 21, 150, "IT"),
                new EmployeeGitStatus("Bob", 22, 90, "HR"),
                new EmployeeGitStatus("Charlie", 43, 200, "IT"),
                new EmployeeGitStatus("David", 44, 120, "Finance"),
                new EmployeeGitStatus("Eve", 35, 80, "HR")
        );
        //fetch emp of all dept whose commit more than 100
        System.out.println("Employees with more than 100 commits:");
        empList.stream().filter(i -> i.getCodeCommit() > 100).forEach(i -> System.out.println(i.getName() + " " + i.getDept()));

        //total commit by dept
        System.out.println("\nTotal commits by department:");
        Map<String,Double> mapEmpCommitByDept = empList.stream().collect(Collectors.groupingBy(i->i.getDept(),Collectors.summingDouble(i->i.getCodeCommit())));

        mapEmpCommitByDept.forEach((dept, commit) ->
            System.out.println(dept + ": " + commit + " commits")
        );


        // Fetch employee with highest commits in each department
        System.out.println("\nEmployees with highest commits by department:");

//        Map<String, EmployeeGitStatus> topCommitsByDept = empList.stream()
//                .collect(Collectors.groupingBy(
//                        EmployeeGitStatus::getDept,
//                        Collectors.collectingAndThen(
//                                Collectors.maxBy(Comparator.comparingDouble(EmployeeGitStatus::getCodeCommit)),
//                                optionalEmp -> optionalEmp.orElse(null)
//                        )
//                ));
//
//        topCommitsByDept.forEach((dept, emp) ->
//            System.out.println(emp.getName() + ": in " + emp.getDept() + " with " + emp.getCodeCommit() + " commits")
//        );

        Map<String, EmployeeGitStatus> map1= empList.stream().collect(Collectors.groupingBy(i->i.getDept(), Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingDouble(EmployeeGitStatus::getCodeCommit)),i->i.orElse(null))));


        map1.forEach((dept, emp)-> System.out.println( dept+"  "+emp.getCodeCommit()));



    }
}
