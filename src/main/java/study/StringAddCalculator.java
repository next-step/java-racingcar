package study;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String REGEX_PATTERN_COMPILE = "//(.)\n(.*)";
    public static final String REGEX_SPLIT = "[,|:]";
    public static final int ZERO = 0;


    public static int splitAndSum(String text){

        // splitAndSum_null_또는_빈문자
        if(text == null || text.isEmpty()){
            return ZERO;
        }

        Matcher m = Pattern.compile(REGEX_PATTERN_COMPILE).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return getSum(m.group(2).split(customDelimiter));
        }

        return getSum(text.split(REGEX_SPLIT));
    }

    private static int getSum(String[] tokens) {

        return Arrays.stream(tokens)
                .mapToInt(number -> positiveNum(number))
                .sum();
    }

    private static int positiveNum(String str) {
        try {
            return negativeCheck(Integer.parseInt(str));
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }

    }

    private static int negativeCheck(int num) {
        if(num < 0){
            throw new IllegalArgumentException("음수 입니다");
        }
        return num;
    }

}
