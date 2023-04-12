package study;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static String REGULAR_DELIMITER = ",|:";
    private static Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int sumWithStringNumbers(String exp) {

        if (isBlankOrNull(exp)) {
            return 0;
        }

        String[] stringNumbers = stringSplitWithRegex(exp);
        List<Integer> numbers = toInts(stringNumbers);

        return sum(numbers);
    }

    private static boolean isBlankOrNull(String exp) {
        if (exp == null || exp.isEmpty()) return true;
        return false;
    }

    private static String[] stringSplitWithRegex(String exp) {

        exp = exp.trim();

        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(exp);
        if (m.find()) {
            return customDelimiter(m.group(1), m.group(2));
        }
        return regularDelimiter(exp);
    }

    private static String[] customDelimiter(String customDelimiter, String exp) {
        return exp.split(customDelimiter);
    }

    private static String[] regularDelimiter(String exp) {
        String[] stringNumbers = exp.split(REGULAR_DELIMITER);
        return stringNumbers;
    }

    private static List<Integer> toInts(String[] stringNumbers) throws RuntimeException {
        List<Integer> numbers = new ArrayList<>();

        for (String s : stringNumbers) {
            try {
                int number = Integer.parseInt(s);
                if (number < 0) {
                    throw new RuntimeException("음수는 입력할 수 없다.");
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }
        return numbers;
    }

    private static int sum(List<Integer> numbers) {
        int sum = 0;

        for (Integer num : numbers) {
            sum += num;
        }
        return sum;
    }

}

