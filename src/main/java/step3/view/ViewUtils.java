package step3.view;

import java.util.Scanner;

public class ViewUtils {
    private static final Scanner SCANNER = new Scanner(System.in);

    private ViewUtils() {}

    public static int nextInt() {
        return SCANNER.nextInt();
    }

    public static String nextLine() { return SCANNER.nextLine(); }

    public static void print(String line) { System.out.print(line);}

    public static void printLine(String line) {
        System.out.println(line);
    }
}
