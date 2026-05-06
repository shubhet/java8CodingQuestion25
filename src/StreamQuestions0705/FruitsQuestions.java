package StreamQuestions0705;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FruitsQuestions {

    public static void main(String[] args) {
       List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Apple","Banana","Apple","Date", "Elderberry");

      // no of fruits counting with name

        fruits.stream().collect(Collectors.groupingBy(i->i,Collectors.counting())).forEach((k,V)->System.out.println(k+" "+V));

    }
}
