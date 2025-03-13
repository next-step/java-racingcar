package calculator;

import java.util.Arrays;

public class StringParser {
    public static String DELIMITER = ",|:";
    public static String[] split(String input){
        return input.split(DELIMITER);
    }

    public static int sum(String[] input){
        return Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
