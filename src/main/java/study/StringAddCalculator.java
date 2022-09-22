package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static String MATCH_PATTERN = "//(.)\n(.*)";
    private static String COMMA_OR_COLON = ",|:";

    // 음수 체크
    private static boolean isNagative(int number) {
        return number < 0;
    }

    // split
    private static String[] split(String text) {
        Matcher m = Pattern.compile(MATCH_PATTERN).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(COMMA_OR_COLON);
    }

    public static int splitAndSum(String number) {
        if (validate(number)) return 0;

        return sum(split(number));
    }

    // 빈 문자열 또는 null 체크
    private static boolean validate(String text) {
        return text == null || text.isEmpty();
    }

    // sum
    private static int sum(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(StringAddCalculator::getPositiveNumber).sum();
    }

    // 음수 발라내고 양수만 가져오기
    private static int getPositiveNumber(String number) {
        int result = Integer.parseInt(number);

        if (isNagative(result)) throw new IllegalArgumentException("음수는 입력할 수 없습니다. 양수를 입력해주세요.");

        return result;
    }
}
