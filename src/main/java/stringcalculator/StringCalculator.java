package stringcalculator;

import java.text.NumberFormat;
import java.util.Arrays;

public class StringCalculator {

    public static final String SPACE = " ";

    public static Double calculate(String input) {
        verify(input);
        return calculate(input.split(SPACE));
    }

    private static void verify(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }


    private static Double calculate(String[] split) {
        Double result = Double.parseDouble(split[0]);
        for (int i = 1; i < split.length; i += 2) {
            Double firstNumber = result;
            Double secondNumber = Double.parseDouble(split[i + 1]);
            result = Operation.calculate(split[i], firstNumber, secondNumber);
        }
        return result;
    }
}
