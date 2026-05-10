package charjava81105;

import java.util.List;
import java.util.stream.Collectors;

public class StreamEQuestions {
    public static void main(String[] args) {

        // Reverse of char array
        char[] s = {'h', 'e', 'l', 'l', 'o'};


        var data = reverseOfCharArray(s);
        System.out.print("{'");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            if (i < data.length - 1) {
                System.out.print("', '");
            }
        }
        System.out.println("'}");

        //print valid numbers from list
        List<String> list = List.of("123ed", "34","384y","988","23e");

        var Intdata = fetchValidNumbersFromList(list);
        System.out.println("Valid numbers from list: "+Intdata);
    }

    private static List<String> fetchValidNumbersFromList(List<String> list) {

        return list.stream().filter(i->i.chars().allMatch(Character::isDigit)).collect(Collectors.toList());

    }

    private static char[] reverseOfCharArray(char[] s) {

        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;


            start++;
            end--;
        }

        return s;
    }
}
