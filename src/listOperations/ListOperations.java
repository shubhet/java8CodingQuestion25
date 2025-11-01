package listOperations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ListOperations {

    public static void main(String [] args){

        List<Integer> list1 = List.of(12,23,45,67,54,89,90);
        List<Integer> list2 = List.of(34,56,78,95,67,54,89,3,45,67);

       //combination of two lists with distinct elements
       List<Integer> resutList = Stream.concat(list1.stream(),list2.stream()).sorted().distinct().collect(Collectors.toList());
        System.out.println(resutList);
    }



}
