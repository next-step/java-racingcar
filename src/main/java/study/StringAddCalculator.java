package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private String[] numbers;

    private static final String regx = "//(.)\n(.*)";

    public StringAddCalculator(String numberString) {
        numbers = splitString(numberString);
    }

    private String[] splitString(String inputStr) {

        String[] split = null;

        if (inputStr == null || inputStr.isEmpty()) {
            return new String[0];
        }

        Matcher m = Pattern.compile(regx).matcher(inputStr);
        if (m.find()) {
            String customDelimiter = m.group(1);
            split = m.group(2).split(customDelimiter);
            return split;
        }
        return inputStr.split("[,:;\\n]+");
    }

    private int toInt(String number) {
        return Integer.parseInt(number);
    }

    public int add() {
        int result = 0;
        for (String number : numbers) {
            if (toInt(number) < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            result += toInt(number);
        }
        return result;
    }

    @Override
    public String toString() {
        return "StringAddCalculator{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }
}
