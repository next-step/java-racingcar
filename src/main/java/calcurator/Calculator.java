package calcurator;

import java.util.Arrays;

public class Calculator {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int division(int a, int b) {
        return a / b;
    }

    public static boolean isValidSign(String str) {
        String[] validSign = new String[]{"+", "-", "*", "/"};

        return (Arrays.asList(validSign).contains(str));

    }
}
