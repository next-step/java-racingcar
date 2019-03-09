package calculator;

import java.text.ParseException;
import java.util.Scanner;

public class StringCalculator {

    static String inputText() {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        return text;
    }

    static int calculate(String text) {

        //validation (null or empty)
        if (text == null || text.trim() == "") return Integer.MIN_VALUE;

        String[] values = text.split(" ");
        int count = values.length;

        int result = Integer.parseInt(values[0]);
        int idx = 1;

        while (idx < count) {
            String expression = values[idx++];
            int y = Integer.parseInt(values[idx++]);
            result = calculrate(result, y, expression);
        }

        return result;
    }

    private static int calculrate(int x, int y, String expression) {
        if ("+".equals(expression)) {
            return x + y;
        }

        if ("-".equals(expression)) {
            return x - y;
        }

        if ("*".equals(expression)) {
            return x * y;
        }

        if ("/".equals(expression)) {
            return x / y;
        }

        return Integer.MIN_VALUE;
    }

}
