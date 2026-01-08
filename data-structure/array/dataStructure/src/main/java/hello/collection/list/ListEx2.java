package hello.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx2 {
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

        System.out.println("출력");

        int size = 0;
        for (Integer i : list) {
            if (size == list.size() - 1) {
                System.out.print(i);
            } else {
                System.out.print(i + ", ");
            }
            size++;
        }
    }
}
