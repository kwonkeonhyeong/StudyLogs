package mu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IoPractice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        String string = br.readLine();

        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            System.out.println(str);
        }

        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str2 = new StringTokenizer(br2.readLine());

        while (str2.hasMoreTokens()) {
            String str = str2.nextToken();
            System.out.println(str);
        }


    }
}
