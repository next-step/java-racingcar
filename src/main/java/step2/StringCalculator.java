package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final int CUSTOM_DELIMITER = 1;
    public static final int INPUT_STRING_VALUE = 2;
    public static final Pattern DEFAULT_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isNullAndBlank(text)) {
            return 0;
        }
        return sum(toInts(strSplit(text)));
    }

    private static String[] strSplit(String text) {
        Matcher matcher = DEFAULT_PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(INPUT_STRING_VALUE).split(matcher.group(CUSTOM_DELIMITER));
        }
        return text.split("[,:]");
    }

    private static boolean isNullAndBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static int sum(List<Integer> intValues) {
        int sum = 0;

        for (int intValue : intValues) {
            sum += intValue;
        }
        return sum;
    }

    private static List<Integer> toInts(String[] strValues) {
        List<Integer> numbers = new ArrayList<>();
        for (String value : strValues) {
            numbers.add(toPositiveNumber(value));
        }
        return numbers;
    }

    private static int toPositiveNumber(String strValue) {
        int num = Integer.parseInt(strValue);
        if (num < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return num;
    }

}
