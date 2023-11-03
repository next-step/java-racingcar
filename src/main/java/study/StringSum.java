package study;

import study.validator.StringSumValidator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSum {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final int DEFAULT_NUMBER = 0;

    public int sumStringByDelimiter(String data) {

        if (!StringSumValidator.validateBlank(data)) {
            return DEFAULT_NUMBER;
        }

        String[] numbers = splitData(data);
        return sumNumbers(numbers);
    }

    private String[] splitData(String data) {

        String delimiter = DEFAULT_DELIMITER;

        if (data.startsWith(CUSTOM_DELIMITER_START)) {
            delimiter = extractCustomDelimiter(data);
            data = data.substring(data.indexOf('\n') + 1);
        }

        return data.split(delimiter);
    }

    private String extractCustomDelimiter(String data) {

        Matcher m = Pattern.compile("//(.)\n").matcher(data);
        if (m.find()) {
            return Pattern.quote(m.group(1));
        }
        return DEFAULT_DELIMITER;
    }

    private int sumNumbers(String[] numbers) {

        return Arrays.stream(numbers)
                .mapToInt(StringSumValidator::validateNumber)
                .filter(StringSumValidator::validatePositive)
                .sum();
    }
}
