package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number {
    private static Pattern pattern = Pattern.compile("\\d+");
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public static Number from(String rawNumber) {
        validateNumber(rawNumber);
        int number = convertNumber(rawNumber);
        return new Number(number);
    }

    private static int convertNumber(String rawNumber) {
        if (isBlank(rawNumber)) {
            return 0;
        }
        return Integer.parseInt(rawNumber);
    }

    private static boolean isBlank(String rawNumber) {
        return rawNumber.isEmpty();
    }

    private static void validateNumber(String rawNumber) {
        if (!isNumber(rawNumber)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private static boolean isNumber(String rawNumber) {
        Matcher matcher = pattern.matcher(rawNumber);
        return matcher.matches();
    }

    public int getNumber() {
        return number;
    }
}
