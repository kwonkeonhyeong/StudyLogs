package mu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortPractice {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5};
        Arrays.sort(arr);

        int[][] arrarr = {{3, 2, 1}, {7, 8, 5}, {7, 6, 9}};

        Arrays.sort(arrarr, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arrarr[i][j] + " ");
            }
            System.out.println();
        }

        Arrays.sort(arrarr, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arrarr[i][j] + " ");
            }
            System.out.println();
        }

        List<Integer> list = new ArrayList<>();

        Collections.sort(list);
        Collections.sort(list, Collections.reverseOrder());

        List<Car> olist = new ArrayList<>();
        olist.add(new Car(1));
        olist.add(new Car(2));

        olist.sort((c1, c2) -> c2.getA() - c1.getA());

        for (Car car : olist) {
            System.out.println(car.getA());
        }
    }

    private static class Car {
        private int a;

        Car(int a) {
            this.a = a;
        }

        public int getA() {
            return a;
        }
    }
};
