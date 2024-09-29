package calculator;

import calculator.splitter.Splitter;

import java.util.ArrayList;
import java.util.List;

public final class StringAddCalculator {

    public static int splitAndSum(final String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        List<String> split = Splitter.split(input);
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

    private static int sum(final List<Integer> list) {
        int sum = 0;
        for (int number : list) {
            checkNaturalNumber(number);
            sum += number;
        }

        return sum;
    }

    private static void checkNaturalNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수를 계산할 수 없습니다.");
        }
    }
}
