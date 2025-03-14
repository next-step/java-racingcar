package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    public static final  String DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static String[] split(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split(DELIMITER);
    }

    public static int sum(String[] input){
        return Arrays.stream(toInt(input))
                .sum();
    }

    public static int[] toInt(String [] input){
        return Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .filter(StringParser::isPositive)
                .toArray();
    }

    public static boolean isPositive(int number){
        if(number < 0) {
            throw new NegativeNumberException("invalid value");
        }
        return true;
    }
}
