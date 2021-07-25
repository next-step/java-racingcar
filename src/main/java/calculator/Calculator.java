package calculator;

import java.util.Scanner;

public class Calculator {

    static final String STRING_BLANK = " ";

    static String input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    static boolean isBlank(String input) {
        if (input == null || input.equals(STRING_BLANK) || input.isEmpty()) {
            throw new IllegalArgumentException("IllegalArgumentException..");
        }
        return false;
    }

    static String[] splitBlank(String input) {
        return input.split(STRING_BLANK);
    }

    static int makeResult(String input) {
        if (isBlank(input))
            throw new IllegalArgumentException("IllegalArgumentException..");
        return calculateSplitString(splitBlank(input));
    }

    static int calculateSplitString(String[] str) {
        int result = toInt(str[0]);
        for (int i = 0; i < str.length - 2; i += 2) {
            result = calculate(result, str[i + 1].charAt(0), toInt(str[i + 2]));
        }
        return result;
    }

    static int calculate(int first, char operator, int second) {
        if (operator == '+')
            return addition(first, second);
        if (operator == '-')
            return subtraction(first, second);
        if (operator == '*')
            return multiplication(first, second);
        if (operator == '/')
            return division(first, second);

        throw new IllegalArgumentException("IllegalArgumentException..");
    }

    static int addition(int i, int j) {
        return i + j;
    }

    static int subtraction(int i, int j) {
        return i - j;
    }

    static int multiplication(int i, int j) {
        return i * j;
    }

    static int division(int i, int j) {
        return i / j;
    }

    static int toInt(String str) {
        return Integer.parseInt(str);
    }

}
