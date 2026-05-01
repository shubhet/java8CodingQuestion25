package stream0105;

import studentGrade.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class StudentStreamBasic0105 {
    public static void main(String[] args) {
        List<studentGrade.Student> students = new ArrayList<>();
        students.add(new studentGrade.Student(1, "Alice", 85));
        students.add(new studentGrade.Student(2, "Bob", 90));
        students.add(new studentGrade.Student(3, "Charlie", 78));
        students.add(new studentGrade.Student(4, "Bob", 92));
        students.add(new studentGrade.Student(5, "Ethan", 88));
        students.add(new studentGrade.Student(6, "David", 82));
        students.add(new studentGrade.Student(7, "Frank", 95));


        // New code 01/05

        // Find all even numbers in a list
        System.out.println("Students with even grades:");
        students.stream()
                .filter(i -> i.getGrade() % 2 == 0)
                .sorted(Comparator.comparing(studentGrade.Student::getGrade).reversed())
                .forEach(i -> System.out.println(i.getStudentName() + " - " + i.getGrade()));

        // Convert a list of strings to uppercase
        System.out.println("Students with grades in uppercase:");
        String s = "java";
        s.chars()
                .mapToObj(c -> String.valueOf((char) c).toUpperCase())
                .forEach(System.out::print);

        // Find the first element greater than 10
        System.out.println("\nFirst student with grade greater than 10:");
        students.stream()
                .filter(i -> i.getGrade() > 10)
                .findFirst()
                .ifPresent(System.out::println);

        // Count how many strings have length > 5
        System.out.println("Number of students with name length greater than 5:");
        long count = students.stream()
                .filter(i -> i.getStudentName().length() > 5)
                .count();
        System.out.println(count);

        // Remove duplicates from a list
        HashSet<String> data = new HashSet<>();
        System.out.println("Duplicate student names:");
        students.stream()
                .filter(i -> !data.add(i.getStudentName()))
                .forEach(i -> System.out.println("Duplicate student name: " + i.getStudentName()));

        // Sort a list of integers in ascending/descending order
        System.out.println("Students sorted by grade in descending order:");
        students.stream()
                .map(studentGrade.Student::getGrade)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        // Find max and min in a list
        System.out.println("Student with highest grade:");
        students.stream()
                .max(Comparator.comparing(studentGrade.Student::getGrade))
                .ifPresent(System.out::println);
        System.out.println("Student with lowest grade:");
        students.stream()
                .min(Comparator.comparing(Student::getGrade))
                .ifPresent(System.out::println);

        // Join a list of strings with commas
        System.out.println("Student names joined with commas:");
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Ethan");
        names.stream()
                .collect(Collectors.joining(","))
                .chars()
                .mapToObj(c -> String.valueOf((char) c))
                .forEach(System.out::print);

        // Skip first 3 elements and process the rest
        System.out.println("Students after skipping first 3:");
        students.stream()
                .skip(3)
                .forEach(System.out::println);

        // Limit output to first 5 elements
        System.out.println("First 5 students:");
        students.stream()
                .limit(5)
                .forEach(System.out::println);
    }
}
