package step2.study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator2 {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern PATTERN_COMPILE = Pattern.compile(CUSTOM_DELIMITER);

    // 문자열을 나누고 숫자로 변환 후 합산하는 메서드
    public static int splitAndSum(String input) {
        //빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
        if(checkNullOrEmpty(input)) {
            return 0;
        }

        // 구분자로 text 분리
        String[] tokens = splitText(input);

        // 구분한 문자열 배열 숫자로 변환 후 합산
        return sumString(tokens);
    }

    // 빈 문자열 또는 null값 판별
    private static boolean checkNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    // 구분자로 text 분리
    private static String[] splitText(String text) {
        Matcher matcher = PATTERN_COMPILE.matcher(text);

        // 사용자가 구분자를 지정해줄 경우
        if(matcher.find()) {
            String customDelimiter = matcher.group(1);

            return matcher.group(2).split(customDelimiter);
        }

        // default 구분자 사용
        return text.split(DEFAULT_DELIMITER);
    }

    // 변환한 숫자가 음수인지 판독
    private static int checkNegativeNumber(String text) {
        int number = convertStringToInt(text);

        if (number < 0) {
            throw new RuntimeException("정수가 아닌 음수가 포함되어있습니다.");
        }

        return number;
    }

    // 구분한 문자열 배열 숫자로 변환
    private static int convertStringToInt(String text) {
        return Integer.parseInt(text);
    }

    // 구분한 문자열 배열 숫자로 변환 후 합산
    private static int sumString(String[] tokens) {
        int result = 0;

        for(String text : tokens) {
            result  += checkNegativeNumber(text);
        }

        return result;
    }

}