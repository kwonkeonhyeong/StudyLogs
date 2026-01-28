package mu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeCasting {
    public static void main(String[] args) {
        int num = Integer.parseInt("123");

        long l = Long.parseLong("123");

        double d = Double.parseDouble("3.14");

        System.out.println(num);
        System.out.println(l);
        System.out.println(d);

        String s1 = String.valueOf(123L);
        String s2 = String.valueOf(1.1);
        String s3 = Integer.toString(123);
        String s4 = 1 + " ";

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        int[] iarr = {1,2,3,4,5};

        List<Integer> ilist = Arrays.stream(iarr).boxed().collect(Collectors.toList());

        ilist.stream().mapToInt(Integer::intValue).toArray();

        Arrays.stream(iarr).boxed().collect(Collectors.toList());

        int ascii = (int) 'A';
        char ch = (char) 65;
    }
}
