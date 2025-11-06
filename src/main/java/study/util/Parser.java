package study.util;

import java.util.Arrays;

public class Parser {

    public static int[] toPositiveIntArr(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Parser::parseStringToInt)
                .toArray();
    }

    private static int parseStringToInt(String value) {
        int number = Integer.parseInt(value);
        Validate.validatePositive(number);
        return number;
    }

}
