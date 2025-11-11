package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        InputParser inputParser = new InputParser(input);
        ParsedInput parsedInput = inputParser.parse();

        return sum(toInts(parsedInput.split()));
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static List<Integer> toInts(List<String> contents) {
        List<Integer> numbers = new ArrayList<>();

        for (String content : contents) {
            numbers.add(toInt(content));
        }
        return numbers;
    }

    private static int toInt(String input) {
        int number = Integer.parseInt(input);

        if (number < 0) {
            throw new RuntimeException("음수가 포함되었습니다.");
        }
        return number;
    }

    private static int sum(List<Integer> numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
