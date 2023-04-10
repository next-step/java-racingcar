package study;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {


    public static int splitAndSum(String exp) {

        if (isBlankOrNull(exp)) {
            return 0;
        }

        String[] stringNumbers = stringSplitWithRegex(exp);
        List<Integer> numbers = parseStringToNumber(stringNumbers);

        return getSum(numbers);
    }

    private static int getSum(List<Integer> numbers) {
        int sum = 0;

        for (Integer num : numbers) {
            sum += num;
        }
        return sum;
    }

    private static boolean isBlankOrNull(String exp) {
        if (exp == null || exp.isEmpty()) return true;
        return false;
    }

    private static List<Integer> parseStringToNumber(String[] stringNumbers) throws RuntimeException {
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

    private static String[] stringSplitWithRegex(String exp) {

        exp = exp.trim();

        if (Pattern.matches("//(.)\n(.*)", exp)) {
            return customDelimiter(exp);
        }
        return regularDelimiter(exp);
    }

    private static String[] customDelimiter(String exp) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(exp);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return null;
    }

    private static String[] regularDelimiter(String exp) {
        String[] stringNumbers = exp.split(",|:");
        return stringNumbers;
    }

}
