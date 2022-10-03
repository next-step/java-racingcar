package calculator;


import static calculator.CalculatorIO.isBlank;
import static calculator.CalculatorIO.splitCustomSeparatorOrDefault;


public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toInts(splitCustomSeparatorOrDefault(text)));
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
    private static int[] toInt(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
           new PositiveNumber(values[i]);
        }
        return numbers;
    }
    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    private static int toPositive(String value) {
        PositiveNumber positiveNumber = new PositiveNumber(value);
        return positiveNumber.getNumber();
    }

}
