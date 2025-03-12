package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static String delimiter = "[,:]";

    public static int splitAndSum(String string) {
        if (isNullEmpty(string)) {
            return 0;
        }

        string = customString(string);
        List<String> splitStrings = Arrays.asList(string.split(delimiter));

        // 오류 처리
        for (String splitString : splitStrings) {
            isNegativeOrNotNumber(splitString);
        }

        return calculationResult(splitStrings);
    }

    // 빈 문자열 또는 null 값 입력 판단
    private static boolean isNullEmpty(String text) {
        return text == null || text.isEmpty();
    }

    // custom deliminator 쓰면 반환
    private static String customString(String string) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(string);
        if (m.find()) {
            delimiter = m.group(1);
            return m.group(2);
        }
        return string;
    }

    // 모두 더한 결과 반환
    private static int calculationResult(List<String> resultStringArray) {
        return resultStringArray.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    // 음수 or 숫자가 아닌 문자열 있으면 Error 발생
    private static void isNegativeOrNotNumber(String str) {
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (Exception e) {
            throw new RuntimeException("숫자 이외의 값이 입력되었습니다.");
        }
        if (num < 0) {
            throw new RuntimeException("음수 값이 입력되었습니다.");
        }
    }
}
