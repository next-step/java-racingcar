package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String COMMENT_PREFIX = "//";
    private static final Pattern COMMENT_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }
        String[] tokens = extractTokens(text);
        return add(tokens);
    }

    // 입력이 null이거나 빈 문자열인지 확인
    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    // 텍스트에서 토큰을 추출 (커스텀 구분자 지원)
    private static String[] extractTokens(String text) {
        if (text.startsWith(COMMENT_PREFIX)) {
            return extractCustomDelimiterTokens(text);
        }
        return text.split(",|:");
    }

    // 커스텀 구분자 형식에서 토큰을 추출
    private static String[] extractCustomDelimiterTokens(String text) {
        Matcher m = COMMENT_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(Pattern.quote(customDelimiter));
        }
        throw new RuntimeException("커스텀 구분자 형식이 올바르지 않습니다.");
    }

    // 토큰들의 합을 계산
    private static int add(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            sum += parseAndValidateNumber(token);
        }
        return sum;
    }

    // 문자열을 정수로 변환하고 유효성 검사 (음수, 숫자가 아닌 값 체크)
    private static int parseAndValidateNumber(String token) {
        int number;
        try {
            number = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값이 포함되어 있습니다: " + token);
        }
        if (number < 0) {
            throw new RuntimeException("음수는 허용되지 않습니다: " + number);
        }
        return number;
    }
}