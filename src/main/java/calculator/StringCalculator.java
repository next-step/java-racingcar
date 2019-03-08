package calculator;

import java.util.Scanner;

public class StringCalculator {

    static int getString() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        return calculate(value);
    }

    static int calculate(String text) {

        if (text == null || text.equals("")) {
            return -1;
        }

        String[] values = text.split(" ");

        int result = Integer.parseInt(values[0]);

        for (int i = 0; i < values.length; i++) {
            result = getCalcResult(values, result, i);
        }

        return result;
    }

    private static int getCalcResult(String[] values, int result, int i) {
        switch (values[i]) {
            case "+":
                result = Calculator.add(result, Integer.parseInt(values[i + 1]));
                break;
            case "-":
                result = Calculator.subtract(result, Integer.parseInt(values[i + 1]));
                break;
            case "*":
                result = Calculator.multiple(result, Integer.parseInt(values[i + 1]));
                break;
            case "/":
                result = Calculator.devide(result, Integer.parseInt(values[i + 1]));
                break;
        }
        return result;
    }

}
