package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public static void main(String[] args) {
        new Calculator().run();
    }

    private void run() {
        String inputString = "2 + 3 * 4 / 2";

        double result = calculate(inputString);
        System.out.println(result);
    }

    private double calculate(String inputString) {

        String[] split = inputString.split(" ");

        List<String> list = Arrays.stream(split)
                .filter(a -> !"".equals(a))
                .collect(Collectors.toList());

        long result = 0;
        long leftSection = 0;

        for (String s : list) {
            if (isNumeric(s)) {
                leftSection = Long.parseLong(s);
            }

            if (isOperator(s)) {

            }
        }

        return result;
    }

    private boolean isNumeric(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String s) {
        return Arrays.asList("+", "-", "*", "/").contains(s);
    }

}
