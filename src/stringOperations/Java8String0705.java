package stringOperations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8String0705 {
    public static void main(String[] args){
        String s="hello world hello everyone";
        System.out.println("Count of each word in string:");
        countEachWordInString(s);

        countNoOfWordsInString(s);

        reverseOfString(s);
    }

    private static void reverseOfString(String s) {
        String string = new StringBuilder(s).reverse().toString();
        System.out.println("Reverse of string: "+string);

        OptionalInt reduce = OptionalInt.of(s.chars().reduce(Integer.parseInt(""),(a, b) -> b + a));
        System.out.println("Reverse of string without using StringBuilder: "+(char)reduce.getAsInt());
    }

    private static void countNoOfWordsInString(String s) {
        int length = s.split("\\s+").length;
        System.out.println("Number of words in string: "+length);
    }

    private static void countEachWordInString(String s) {

        String[] split = s.split("\\s+");
        Arrays.stream(split).collect(Collectors.groupingBy(i->i, Collectors.counting())).forEach((i,j)->System.out.println(i+"==="+j));


    }


}
