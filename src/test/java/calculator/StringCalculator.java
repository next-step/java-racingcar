package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String DEFAULT_DELIIMITER = "[,:]";
    public static final Pattern CUSTUM_DELIIMITER = Pattern.compile("//(.)\n(.*)");

    @Test
    @DisplayName("문자열을 자르고 더하는 계산기 기능")
    public static int splitAndSum(String text) {
        return parseAndSum(split(text));
    }
    @Test
    @DisplayName("구분자에 따라 문자열 자르는 기능")
    public static String[] split(String text) {
        if (StringUtils.isBlank(text)) {
            text = "0";
        }

        Matcher m = CUSTUM_DELIIMITER.matcher(text);

        if (m.find()) {
            return m.group(2).split(m.group(1));
        }
        return text.split(DEFAULT_DELIIMITER);
    }

    @Test
    @DisplayName("숫자를 양수로 변환하는 기능")
    public static int parseAndSum(String[] numbers) {
        int number = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (getPositiveNumber((numbers[i]))) {
                number += Integer.parseInt(numbers[i]);
            }
        }
        return number;
    }

    @Test
    @DisplayName("숫자가 양수가 아니면 RuntimeException 던지는 기능")
    public static boolean getPositiveNumber(String number) {
        if (Integer.parseInt(number) < 1) {
            throw new RuntimeException(number + "는 양수가 아닙니다.");
        }
        return true;
    }
}
