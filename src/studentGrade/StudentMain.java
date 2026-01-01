package studentGrade;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentMain {

    public static void main(String[] args) {
       List<Student> students = new ArrayList<>();
       students.add(new Student(1, "Alice", 85));
       students.add(new Student(2, "Bob", 90));
       students.add(new Student(3, "Charlie", 78));
       students.add(new Student(4, "Diana", 92));
       students.add(new Student(5, "Ethan", 88));

      List<Student> result = students.stream().filter(i->i.getGrade() >60).collect(Collectors.toList());

      result.forEach(System.out::println);

      List<String> result1 = students.stream().filter(i->i.getGrade()>70).map(i->i.getStudentName()).collect(Collectors.toList());
      result1.forEach(System.out::println);

      System.out.println("Students sorted by grade in descending order:");
      students.stream().sorted(Comparator.comparingInt(Student::getGrade).reversed()).collect(Collectors.toList()).forEach(System.out::println);

      //top 3 grade students
        System.out.println("Top 3 students with highest grades:");
        students.stream().sorted(Comparator.comparing(Student::getGrade).reversed()).limit(3).forEach(System.out::println);

    }
}
