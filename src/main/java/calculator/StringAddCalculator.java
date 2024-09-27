package calculator;

import java.util.ArrayList;
import java.util.List;

public final class StringAddCalculator {

    public static int splitAndSum(final String input) {
        List<String> split = split(input);
        List<Integer> listToSum = convertStringsToIntegers(split);

        return sum(listToSum);
    }

    private static List<Integer> convertStringsToIntegers(final List<String> split) {
        List<Integer> result = new ArrayList<>();
        for (String number : split) {
            result.add(Integer.parseInt(number));
        }

        return result;
    }

    private static List<String> split(final String input) {
        List<String> result = new ArrayList<>();
        if (input == null || input.isEmpty()) {
            return result;
        }

        String delimiter = ",|:";
        String[] split = input.split(delimiter);

        for (String number : split) {
            if (!number.isEmpty()) {
                result.add(number);
            }
        }

        return result;
    }

    private static int sum(final List<Integer> list) {
        int sum = 0;
        for (int number : list) {
            sum += number;
        }

        return sum;
    }
}
