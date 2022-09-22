package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String COMMA = ",";
    private static final String DOUBLE_DOT = ":";

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty())
            return 0;
        List<Integer> numbers = convertTextToIntList(text);
        return cacluateSum(numbers);
    }

    public static List<Integer> convertTextToIntList(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return toInts(tokens);
        }
        String[] numbers = text.split("[" + COMMA + DOUBLE_DOT + "]");
        return toInts(numbers);
    }

    private static List<Integer> toInts(String[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (String number : numbers) {
            validatePositveNumber(number);
            list.add(Integer.parseInt(number));
        }
        return list;
    }

    private static int cacluateSum(List<Integer> intList) {
        int sum = 0;
        for (int number : intList) {
            sum += number;
        }
        return sum;
    }

    private static void validatePositveNumber(String number) {
        try {
            int parseNum = Integer.parseInt(number);
            if (parseNum < 0) {
                throw new RuntimeException("음수는 들어올 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 형태가 아닌 값이 존재합니다.");
        }
    }
}
