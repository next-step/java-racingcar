package study.racing.common;

import java.util.Random;
import java.util.Scanner;

public class Common {

    private static final Random random = new Random();

    private static final int RANDOM_MAX_NUMBER = 10;

    private static final Scanner scanner = new Scanner(System.in);

    public static int toInt(String value) {
        return Integer.parseInt(value);
    }

    public static int createRandomNumber(){
        return random.nextInt(RANDOM_MAX_NUMBER);
    }

    public static int inputValueWithMessage(String message) {
        printMessage(message);
        return toInt(scanner.nextLine());
    }

    public static void printMessage(String text) {
        System.out.println(text);
    }

    public static void printNewLine() {
        System.out.print("\n");
    }
}