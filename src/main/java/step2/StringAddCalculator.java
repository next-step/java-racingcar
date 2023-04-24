package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    static final String customDelimiterPattern = "//(.)\n(.*)";
    static final String defaultDelimiter = ",|:";

    static public int splitAndSum(String text) {
        // null 또는 빈문자 처리
        if (isEmptyText(text)) {
            return 0;
        }
        // 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용
        Matcher matcher = Pattern.compile(customDelimiterPattern).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            text = matcher.group(2);
            return(sum(separateText(customDelimiter, text)));
        }
        // 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
        return sum(separateText(defaultDelimiter, text));
    }

    static private boolean isEmptyText(String text) {
        return text == null || text.isEmpty();
    }

    static private String[] separateText(String delimiter, String text) {
        return text.split(delimiter);
    }

    static private int sum(String[] tokens) {
        int result = 0;
        // 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number < 0)
                throw new RuntimeException();
            result += number;
        }
        return result;
    }
}
