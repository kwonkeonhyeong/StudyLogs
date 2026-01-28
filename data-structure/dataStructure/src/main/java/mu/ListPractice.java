package mu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListPractice {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();

        List<String> list2 = new ArrayList();

        List<Integer> list3 = new ArrayList<>(Arrays.asList(1,2,3));

        System.out.println(list.add(1));
        System.out.println(list.get(0));
        System.out.println(list.size());

        list.set(0, 100);
        System.out.println(list.get(0));

        list.remove(0);
        System.out.println(list.size());

        list.remove(Integer.valueOf(2));

        list.contains(1);

        System.out.println(list.indexOf(1));

        boolean isEmpty = list.isEmpty();

        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(3);
        test.add(6);
        test.add(2);
        test.add(0);

        Collections.sort(test);
        for (Integer i : test) {
            System.out.print(i + " ");
        }

        System.out.println();

        Collections.sort(test, Collections.reverseOrder());

        for (Integer i : test) {
            System.out.println(i + " ");
        }

        int[] arrays = {1,2,3,4};

        List<Integer> collect = Arrays.stream(arrays).boxed().collect(Collectors.toList());

        int[] array = collect.stream().mapToInt(Integer::intValue).toArray();

        test.toArray(new Integer[10]);

    }
}
