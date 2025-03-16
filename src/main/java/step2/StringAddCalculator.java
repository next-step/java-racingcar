package step2;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class StringAddCalculator {
    public static final String REGEX = ",|:";
    public static final int ZERO = 0;

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return ZERO;
        }

        return sum(toInts(split(text)));
    }

    public static int sum(List<Integer> numbers) {
        int result = ZERO;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }

    public static List<Integer> toInts(String[] values) {
        List<Integer> numbers = new ArrayList<>();

        for (String value : values) {
            numbers.add(parseInt(value));
        }

        return numbers;
    }

    public static String[] split(String text) {
        return text.split(REGEX);
    }
}
