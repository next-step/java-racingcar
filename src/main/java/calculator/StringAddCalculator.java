package calculator;

import java.util.ArrayList;
import java.util.List;

public final class StringAddCalculator {

    public static int splitAndSum(final String input) {
        String[] split = split(input);
        List<Integer> listToSum = convertStringsToIntegers(split);

        return sum(listToSum);
    }

    private static List<Integer> convertStringsToIntegers(final String[] split) {
        List<Integer> result = new ArrayList<>();
        for (String number : split) {
            result.add(Integer.parseInt(number));
        }

        return result;
    }

    private static String[] split(final String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        String delimiter = ",|:";
        String[] split = input.split(delimiter);

        return split;
    }

    private static int sum(final List<Integer> list) {
        int sum = 0;
        for (int number : list) {
            sum += number;
        }

        return sum;
    }
}
