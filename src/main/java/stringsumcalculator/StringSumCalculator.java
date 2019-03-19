package stringsumcalculator;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {
    private final static String DEFAULT_DELIMITER = "[,:]";

    int calculate(String input) {
        if (isEmpty(input)) return 0;

        String[] numbers = numberSplit(input);
        int sum = 0;
        for (String num : numbers) {
            isNumeric(num);
            isNegative(num);
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    private String[] numberSplit(String input) {
        String delimiter = DEFAULT_DELIMITER;
        String[] splitNumber = input.split(delimiter);
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            delimiter = m.group(1);
            splitNumber = m.group(2).split(delimiter);
        }
        return splitNumber;
    }

    private boolean isEmpty(String input) {
        return input == null || StringUtils.isEmpty(input);
    }

    private void isNegative(String input) {
        if (input.startsWith("-")) {
            throw new RuntimeException();
        }
    }

    private void isNumeric(String input) {
        if (!StringUtils.isNumeric(input)) {
            throw new RuntimeException();
        }
    }
}
