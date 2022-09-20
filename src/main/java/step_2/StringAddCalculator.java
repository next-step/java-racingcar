package step_2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private StringAddCalculator() {}

    public static int splitAndSum(String text) {
        if (StringUtils.isEmpty(text)) return 0;
        
        // 문자열을 숫자 문자열 배열로 변환
        String[] numberStrings = parseToNumberStringArray(text);

        // 숫자 문자열 검증
        validateNumberStrings(numberStrings);

        // 더하기
        return sum(numberStrings);
    }

    private static void validateNumberStrings(String[] tokens) {
        for (String token : tokens) {
            int number = Integer.parseInt(token);

            checkMinusNumber(number);
        }
    }

    private static void checkMinusNumber(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    private static String[] parseToNumberStringArray(String str) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (m.find()) {
            String delimiter = m.group(1);
            return m.group(2).split(delimiter);
        }

        return str.split("[,:]");
    }

    public static int sum(String[] strArr) {
        return Arrays.stream(strArr)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
