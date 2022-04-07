package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.equals("")) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\\n(.*)").matcher(input);
        if (m.matches()) {
            String[] values = m.group(2).split(m.group(1));
            return sum(toIntArray(values));
        }

        String[] values = input.split(",|:");
        return sum(toIntArray(values));
    }

    private static int[] toIntArray(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toInt(values[i]);
        }
        return numbers;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for(int number : numbers) {
            result += number;
        }
        return result;
    }
}
