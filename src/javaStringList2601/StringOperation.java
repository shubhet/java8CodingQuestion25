package javaStringList2601;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringOperation {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("cherry");
        stringList.add("apple");

        //find occurrences of words
        Map<String, Long> collectResult = stringList.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println("Occurrences of words:");
        collectResult.entrySet().forEach(System.out::println);

        //print value in decreasing order
        System.out.println("Occurrences of words in decreasing order:");
        collectResult.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEach(System.out::println);

        //print first repeating char in string

        String input = "swisosi";
        Map<Character, Long> data = input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        var datafinal = data.entrySet().stream().filter(i -> i.getValue() > 1).findFirst().get();
        System.out.println("First repeating char in string:");
        System.out.println(datafinal.getKey());

        //print first non-repeating char in string
        var datafinalNonRepeating = data.entrySet().stream().filter(i -> i.getValue() == 1).findFirst().get();
        System.out.println("First non-repeating char in string:");
        System.out.println(datafinalNonRepeating.getKey());


        //reverse a string
        String s = "hello world";
        var datareverse = s.chars().mapToObj(c -> String.valueOf((char) c)).reduce("", (a, b) -> b + a);
        System.out.println("Reversed string:");
        System.out.println(datareverse);

        //occurrences of char in string

        String s1 = "java";
        IntStream chars = s1.toLowerCase().chars();
        Map<Character, Long> result = chars.mapToObj(c -> (char) c).collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        result.forEach((i, j) -> System.out.println(i + " : " + j));

    }

}
