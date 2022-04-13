package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private final static String DELIMITER_DEFUALT_REGEXP = ",|:";
    private final static String DELIMITER_CUSTOM_REGEXP  = "//(.)\n(.*)";

    /*
    public 함수는 한 개에 간결하게(가독성 좋게)

    private 함수는 많으면 많을수록 좋음(메소드 분리)
     */
    public static int splitAndSum(String text) {

        //로컬변수 int result = 0 을 선언하고 메소드 전체 블록 안에서 사용하는 것은 올바르지 않다.
        //Early Return 을 통해 else문을 없애라.

        if(isBlankText(text))return 0;

        Matcher m = Pattern.compile(DELIMITER_CUSTOM_REGEXP).matcher(text);
        if(m.find()){
            String customDelimiter = m.group(1);
            String[] values = m.group(2).split(customDelimiter);
            return sum(toIntArray(values));
        }

        String[] values = text.split(DELIMITER_DEFUALT_REGEXP);
        return sum(toIntArray(values));
    }

    private static boolean isBlankText(String text) {
        return text == null || text.isBlank();
    }

    private static int sumBeforeRefactoring(String[] values) {
        int sum = 0;
        for (String value : values) {
            //int number = toInt(value)   한 곳에서만 사용하는 지역변수는 제거할 것
            sum += toInt(value);
        }
        return sum;
    }

    //메소드 분리시 추상화 레벨 1이 됨.
    private static int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    private static int[] toIntArray(String[] values) {
        int[] ints = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            ints[i] = toInt(values[i]);
        }
        return ints;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if(number < 0){
            throw new RuntimeException("음수를 허용하지 않습니다.");
        }
        return number;
    }



}
