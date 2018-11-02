package calculator;

import java.util.Arrays;

public class StringCalculator {

    static int calculator(String text) {
        int result = 0;
        String isEmpty = " ";
        Arrays.stream(text.split(isEmpty)).forEach(StringCalculator::arithmeticOperation);
        return result;
    }

    private static void arithmeticOperation(String separator) {
        if ("+".equals(separator)) {

        }

        if ("-".equals(separator)) {

        }

        if ("*".equals(separator)) {

        }

        if ("/".equals(separator)) {

        }
    }

    private static int division(int first, int second) {
        return first / second;
    }

    private static int multiplication(int first, int second) {
        return first * second;
    }

    private static int minus(int first, int second) {
        return first - second;
    }

    private static int plus(int first, int second) {
        return first + second;
    }

}
