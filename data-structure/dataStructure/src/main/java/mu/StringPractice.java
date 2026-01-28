package mu;

public class StringPractice {
    public static void main(String[] args) {
        String s = "hello world";

        char c = s.charAt(0);

        if (c == 'h') {
            System.out.println(true);
        }

        String sub = s.substring(0,6);
        System.out.println(sub);

        System.out.println(s);

        String sub2 = s.substring(6);
        System.out.println(sub2);

        String joined = String.join("#", sub, sub2);
        System.out.println(joined);

        boolean cot = s.contains("fsfd");
        System.out.println(cot);

        boolean gg = s.startsWith("hello");
        System.out.println(gg);

        boolean ss = s.endsWith("world");
        System.out.println(ss);

        int index = s.indexOf("e");
        System.out.println(index);

        int lastIndex = s.lastIndexOf("w");
        System.out.println(lastIndex);

        String upperCase = s.toUpperCase();
        System.out.println(upperCase);

        String lowerCase = s.toLowerCase();
        System.out.println(lowerCase);

        String trim = s.trim();
        System.out.println(trim);

        char[] chars = s.toCharArray();
        for (char cc : chars) {
            System.out.println(cc);
        }

        String strChars = new String(chars);
        String strChars2 = String.valueOf(chars);

        System.out.println(strChars);
        System.out.println(strChars2);

        String empty = "";
        String blank = " ";

        System.out.println(empty.isEmpty());
        System.out.println(blank.isBlank());
    }
}
