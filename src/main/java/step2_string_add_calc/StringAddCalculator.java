package step2_string_add_calc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String inputStr) {
        if (inputStr == null || inputStr.isEmpty())
            return 0;
        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher m = Pattern.compile("//(.)\n(.*)")
                .matcher(inputStr);
        if (m.find()) {
            return splitAndSum(m.group(1), m.group(2));
        }
        return splitAndSum("[,:]", inputStr);
    }

    private static int splitAndSum(String delimiter, String inputStr) {
        return Arrays.stream(inputStr.split(delimiter))
                .mapToInt(s -> {
                    int number = Integer.parseInt(s); // 문자열을 정수로 변환
                    if (number < 0) { // 변환된 정수가 음수인 경우
                        throw new RuntimeException("음수 입력은 불가능합니다.");
                    }
                    return number; // 변환된 양수 정수 반환
                })
                .sum();
    }
}