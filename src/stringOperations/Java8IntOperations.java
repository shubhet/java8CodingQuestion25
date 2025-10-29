package stringOperations;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Java8IntOperations {

    public static void main(String[] args) {

        List<Integer> list = List.of(12, 23, 34, 45, 43, 21, 46, 78);

        //sum of all numbers
        int sum = list.stream().mapToInt(i -> (int) i).sum();
        System.out.println("Sum of all numbers: " + sum);

        //find max number
        int max = list.stream().sorted(Comparator.reverseOrder()).findFirst().get();
        System.out.println(max);

        //find min number
        int min = list.stream().sorted().findFirst().get();
        System.out.println(min);

        //find average
        OptionalDouble average = list.stream().mapToInt(Integer::intValue).average();
        if (average.isPresent())
            System.out.println("Average: " + average.getAsDouble());
        else {
            System.out.println("Average not found");
        }

        //count even and odd numbers
        long evenCount = list.stream().filter(i -> i % 2 == 0).count();
        long oddCount = list.stream().filter(i -> i % 2 != 0).count();
        System.out.println("Even numbers count: " + evenCount);
        System.out.println("Odd numbers count: " + oddCount);


        //find second-largest number
        int secondLargest = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("Second largest number: " + secondLargest);
    }
}
