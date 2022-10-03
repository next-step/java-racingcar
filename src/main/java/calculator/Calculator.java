package calculator;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    // final 추가 및 스네이크 케이스 변경, 접근제어자 추가
    static private String DELIMITER = ",|:";
    static final int DEFAULT_RETURN_VALUE = 0;

    // Q.유틸리티 클래스 인스턴스화? 한 것이 이렇게 사용하는게 맞을까요?
    static private Pattern pattern;
    static private Matcher matcher;
    public static int sum(String value) {
        // 빈 문자열 또는 null 값 chek
        if(isBlankOrisNull(value))
            return DEFAULT_RETURN_VALUE;    // 상수로 분리완료

        // 숫자 하나의 문자열만 들어왔을 경우, 해당 숫자를 반환
        if(isDigit(value))
            return Integer.parseInt(value);

        // isCustom에서 덧셈연산하던 것을 제거 후 메소드명 변경, 커스텀 문자열 제외한 String만 반환하여 value 업데이트
        // Q. isCustom에서 DELIMITER에 변화를 주는데 괜찮은 구조가 맞을까요?
        if(value.substring(0,2).equals("//"))
            value = getCustomString(value);

        return calculate(value);
    }

    private static boolean isBlankOrisNull(String value) {
        return value == "" || value == null;
    }

    private static boolean isDigit(String value) {
        boolean isDigit = true;
        for(int i = 0; i< value.length(); i++){
            if(!Character.isDigit(value.charAt(i)))
                isDigit = false;
        }
        return isDigit;
    }

    private static String getCustomString(String value) {
        matcher = pattern.compile("//(.)\n(.*)").matcher(value);
        int sum = 0;
        if (matcher.find()) {
            // 커스텀일 경우 기존 DELIMITER에 추가하는 방식으로 변경
            DELIMITER += "|"+matcher.group(1);
            return matcher.group(2);
        }
        return value;
    }

    // 계산은 아래 calcuate 메소드에서 일괄 진행
    private static int calculate(String value){
        int[] numbers = splitByDelimiter(value);
        int result = 0;
        for (int i=0; i < numbers.length; i++)
            result += numbers[i];
        return result;
    }

    public static int[] splitByDelimiter(String value) {
        String[] values = value.split(DELIMITER);
        int[] numbers = new int[values.length];
        for (int i=0; i < values.length; i++) {
            numbers[i] = toInt(values[i]);
        }
        return numbers;
    }

    private static int toInt(String values) {
        int num = Integer.parseInt(values);
        // 더 추상화된 예외클래스로 변경
        if(!Character.isDigit(values.charAt(0)) || num < 0 ) {
            throw new IllegalArgumentException("숫자 이외의 값 또는 음수는 입력될 수 없습니다.");
        }
        return num;
    }
}
