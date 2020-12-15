package step3.view;

import java.util.Scanner;

public class ViewUtils {
    private static final Scanner SCANNER = new Scanner(System.in);

    private ViewUtils() {}

    public static int nextInt() {
        return SCANNER.nextInt();
    }

    public static void printLine(String line) {
        System.out.println(line);
    }
}
