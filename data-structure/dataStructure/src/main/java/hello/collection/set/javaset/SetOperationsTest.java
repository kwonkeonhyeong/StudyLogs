package hello.collection.set.javaset;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetOperationsTest {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(List.of(3,4,5,6,7));

        Set<Integer> union = new HashSet<>();
        union.addAll(set1);
        union.addAll(set2);

        System.out.println(union);

        Set<Integer> intersection = new HashSet<>();
        intersection.addAll(set1);
        intersection.retainAll(set2);

        System.out.println(intersection);

        Set<Integer> difference = new HashSet<>();
        difference.addAll(set1);
        difference.removeAll(set2);

        System.out.println(difference);
    }
}
