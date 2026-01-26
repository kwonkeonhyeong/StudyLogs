package hello.collection.set.javaset;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UniqueNamesTest1 {
    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10};

        HashSet<Object> objects = new HashSet<>();
        for (Integer i : inputArr) {
            objects.add(i);
        }

        for (Object object : objects) {
            System.out.println(object);
        }
    }
}
