package calculator;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class TextCalculator {
    public static int calculate(String input) {
        return sum(convert(Text.input(input).elements()));
    }

    private static List<Integer> convert(List<String> elements) {
        return elements.stream()
                .map(TextCalculator::convertInt).collect(Collectors.toList());
    }

    private static int sum(List<Integer> nums) {
        return nums.stream()
                .reduce(0, Integer::sum);
    }

    private static int convertInt(String element) {
        int num = parseInt(element);
        if (num < 0) {
            throw new RuntimeException();
        }
        return num;
    }
}
