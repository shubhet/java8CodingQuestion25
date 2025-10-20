package stream201025;

import java.util.Arrays;

public class StringMain {
    public static void main(String[] args) {
        String s = "Hello Java";
        String[] s1 = s.split("");
        String result = Arrays.stream(s1).reduce("",(a,c)->c+a);
        System.out.println(result);
    }
}
