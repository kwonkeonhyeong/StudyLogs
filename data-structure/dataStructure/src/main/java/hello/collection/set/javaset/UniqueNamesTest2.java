package hello.collection.set.javaset;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class UniqueNamesTest2 {
    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10};

        LinkedHashSet<Integer> integers = new LinkedHashSet<>(List.of(inputArr));

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
