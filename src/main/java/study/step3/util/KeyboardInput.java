package study.step3.util;

import java.util.Scanner;

public class KeyboardInput {

    private static Scanner scanner = new Scanner(System.in);

    private KeyboardInput() {

    }

    public static int readInputNum(String message) {
        System.out.println(message);
        return toInt(scanner.nextLine());
    }

    private static int toInt(String str) {
        return Integer.valueOf(str);
    }

    public static String readInputString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
