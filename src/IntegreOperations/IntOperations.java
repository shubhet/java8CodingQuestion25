package IntegreOperations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntOperations {

    public static void main(String[] args) {

        List<Integer> num = Arrays.asList(12, 23, 32, 43, 45, 56, 65);

        //increasing order
        num.stream().sorted().forEach(System.out::println);

        //reverse order
        num.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //sum of all elements
        int sum = num.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum);

        //average of all elements
        double average = num.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average: " + average);

        //second largest element
        Integer number = num.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("Largest element: " + number);


    }

}
