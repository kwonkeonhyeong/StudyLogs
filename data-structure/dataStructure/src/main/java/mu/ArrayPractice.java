package mu;

import java.util.Arrays;
import java.util.Collections;

public class ArrayPractice {
    public static void main(StringPractice[] args) {
        int[] arri = new int[3];


        int[] temp = new int[arri.length];

        for (int i =0; i < arri.length; i++) {
            arri[i] = i;
        }

        for (int i = 0; i < arri.length; i++) {
            temp[arri.length - i - 1] = arri[i];
        }

        for(int i = temp.length-1; i >= 0; i--) {
            System.out.print(temp[i]);
        };

        System.out.println();

        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i]);
        }

        Arrays.sort(temp);

        for (int i = 0; i < temp.length; i ++) {
            System.out.print(temp[i]);
        }

        System.out.println();

        int[] copy = Arrays.copyOf(temp, temp.length);
        for(int i = 0; i < copy.length; i++) {
            System.out.print(i);
        }

        System.out.println();

        int[] partCopy = Arrays.copyOfRange(temp, 0,1);
        for (int i = 0; i < partCopy.length; i++) {
            System.out.print(partCopy[i]);
        }

        String test = "1 2 3 4 5";

        String[] str = test.split(" ");

        Integer[] ci = new Integer[str.length];

        for (int i = 0; i < str.length; i++) {
            ci[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(ci, Collections.reverseOrder());

        for (int i = 0; i < ci.length; i++) {
            System.out.print(ci[i]);
        }

        System.out.println();

        int[][] arrays = new int[3][3];

        for (int i = 0; i < arrays.length; i ++) {
            for (int j = 0; j < arrays[i].length; j ++) {
                System.out.print(arrays[i][j] + " ");
            }
            System.out.println();
        }


        for (int i = 0; i < arrays.length; i ++) {
            Arrays.fill(arrays[i], 1);
        }

        for (int i = 0; i < arrays.length; i ++) {
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.print(arrays[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        int t = 1;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                arrays[i][j] = t++;
            }
        }

        System.out.println();

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.print(arrays[i][j] + " ");
            }
            System.out.println();
        }


        int n = 3;
        int m = 3;

        int[][] result2 = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result2[n-1-i][j] = arrays[i][j];
            }
        }

        for (int i = 0; i < n/2; i++) {
            int[] te = arrays[i];
            arrays[i] = arrays[n - 1 - i];
            arrays[n - 1 - i] = te;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < m; j++) {
                int tem = arrays[i][j];
                arrays[i][j] = arrays[j][i];
                arrays[j][i] = tem;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result2[i][j] + " ");
            }
            System.out.println();
        }

    }
}
