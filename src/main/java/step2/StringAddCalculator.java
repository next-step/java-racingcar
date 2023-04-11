package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    // 매직리터럴 선언
    private static final String DEFAULT_SEPARATOR_STRING = ",|:";                               // default 구분자
    private static final String CUSTOM_SEPARATOR_STRING = "//(.)\n(.*)";                        // 사용자 입력 구분자
    private static final Pattern PATTERN_COMPILE = Pattern.compile(CUSTOM_SEPARATOR_STRING);    // pattern 객체를 매번 생성하는 것을 막기위해

    public static int splitAndSum(String input) {
        //빈 문자열 or null일 경우 0값 return
        if(checkNullOrEmpty(input)) {
            return 0;
        }

        //숫자문자열 특정 문자로 분리
        String[] tokens = splitText(input);

        // 숫자문자열 특정 문자로 분리 후 합산
        return sumText(tokens);
    }

    // 빈 문자열 또는 null 값 확인
    private static boolean checkNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    // 문자열 숫자 반환
    private static int convertStringToInteger(String text) {
        try {
            int number = Integer.parseInt(text);

            // 변환한 값 음수인지 판독
            checkNegativeNumber(number);

            return number;
        } catch (RuntimeException e) {
            e.printStackTrace();    //예외정보 출력
            throw e;  //예외 던지기
        }

    }

    //숫자문자열 특정 문자로 분리
    private static String[] splitText(String text) {
        // 지정한 character로 문자열 나누기
        Matcher m = PATTERN_COMPILE.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        // default 문자열로 분리
        return text.split(DEFAULT_SEPARATOR_STRING);
    }

    // 숫자문자열 특정 문자로 분리 후 합산
    private static int sumText(String[] tokens) {
        int result = 0;

        // 문자열 배열마다 integer 타입으로 형변환 및 합산
        for(String text : tokens) {
            result += convertStringToInteger(text);
        }

        return result;
    }

    // 변환한 값 음수인지 판독
    private static void checkNegativeNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("정수가 아닙니다.");
        }
    }
}
