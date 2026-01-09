package hello.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        while (true) {
            int value = Integer.parseInt(scanner.nextLine());

            if (value == 0) {
                break;
            }

            list.add(value);
        }

        Integer sum = list.stream().reduce(0, Integer::sum);

        System.out.println("입력한 정수의 합계: " + sum);
        System.out.println("입력한 정수의 평균: " + (double) sum/list.size());
    }
}
