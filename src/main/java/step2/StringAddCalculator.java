package step2;

import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        //빈 문자열 or null일 경우 0값 return
        if(checkNullOrEmpty(input)) {
            return 0;
        }

        // 숫자문자열 특정 문자로 분리 후 합산
        return sumText(input);

    }
    // 빈 문자열 또는 null 값 확인
    public static boolean checkNullOrEmpty(String text) {
        if(text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }

    // 문자열 숫자 반환
    public static int convertStringToInteger(String text) {
        try {
            int number = Integer.parseInt(text);
            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException("정수가 아닙니다.");
        }

    }

    //숫자문자열 특정 문자로 분리
    public static String[] splitText(String text) {
        // 지정한 character로 문자열 나누기
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        // default 문자열로 분리
        return text.split(",|:");
    }

    // 숫자문자열 특정 문자로 분리 후 합산
    public static int sumText(String input) {
        int result = 0;
        //숫자문자열 특정 문자로 분리
        String[] tokens = splitText(input);

        // 문자열 배열마다 integer 타입으로 형변환 및 합산
        for(String text : tokens) {
            if(convertStringToInteger(text) < 0) {
                throw new RuntimeException("음수가 포함되어 있습니다.");
            }
            result += convertStringToInteger(text);
        }

        return result;
    }
}
