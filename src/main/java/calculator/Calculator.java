package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public int sum(String text) {
        int sum = sumByCustomDelimiter(text);
        if (sum != 0) {
            return sum;
        }
        return sum(text.split(DELIMITER));
    }

    private int sumByCustomDelimiter(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return sum(matcher.group(2).split(customDelimiter));
        }
        return 0;
    }

    private int sum(String[] tokens) {
        return Arrays.stream(tokens)
            .mapToInt(strNumber -> {
                int number = Util.strToInt(strNumber);
                validateNegativeBy(number);
                return number;
            })
            .sum();
    }

    private void validateNegativeBy(int number) {
        if (number < 0) {
            throw new NegativeNumberException();
        }
    }

}
