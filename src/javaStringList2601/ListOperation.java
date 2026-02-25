package javaStringList2601;

import java.util.Comparator;
import java.util.List;

public class ListOperation {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Even numbers in the list:");
        list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

        System.out.println("Sum of all numbers in the list:");
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        System.out.println("Average of all numbers in the list:");
        var average = list.stream().mapToInt(Integer::intValue).average();
        System.out.println(average);


        System.out.println("Maximum and Minimum numbers in the list:");
        // var max = list.stream().mapToInt(Integer::intValue).max();
        var max = list.stream().sorted(Comparator.reverseOrder()).findFirst().get();

        var min = list.stream().sorted(Comparator.naturalOrder()).findFirst().get();
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        list.stream().mapToInt(Integer::intValue).sum();


    }
}
