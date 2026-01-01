package stringOperations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8StringOperations {
    public static void main(String[] args) {

       // sumofDigit(123);
      //  countVowels("Hello World");
      //  countEachCharacter("hello world");
          countEachWordInString("hello world hello everyone");
        coundWordsInList(List.of("apple", "banana", "apple", "orange", "banana", "apple"));
      //  printDistinctCharacters("hello world");
    }

    static void sumofDigit(int n) {
        String s = String.valueOf(n);
        int sum = s.chars().map(Character::getNumericValue).sum();
        System.out.println("Sum of digits: " + sum);
        System.out.println("Sum of digits without stream: " + sum);
    }

    static void countVowels(String s) {
        long count = s.toLowerCase().chars().mapToObj(c -> (char) c).filter(c -> "aeiou".indexOf(c) != -1).distinct().count();
        System.out.println("Number of vowels: " + count);
    }

    static void countEachCharacter(String s) {
        s= s.replaceAll("\\s+", "");
        IntStream chars = s.trim().toLowerCase().chars();
        Map<Character, Long> countResult = chars.mapToObj(c -> (char) c).collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        countResult.forEach((i, j) -> System.out.println(i + "===" + j));
    }

    static void coundWordsInList(List<String> words){
      words.stream().collect(Collectors.groupingBy(i->i, Collectors.counting())).forEach((i,j)->System.out.println(i+"==="+j));

    }

    static void printDistinctCharacters(String s){
        s.chars().mapToObj(c->(char)c).distinct().forEach(System.out::println);
    }

    //count words from string

    static void countEachWordInString(String s1){
        String[] s = s1.split("\\s+");
        Arrays.stream(s).collect(Collectors.groupingBy(i->i, Collectors.counting())).forEach((i,j)->System.out.println(i+"==="+j));
    }






}
