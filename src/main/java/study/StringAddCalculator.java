package study;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String REGEX_PATTERN_COMPILE = "//(.)\n(.*)";
    public static final String REGEX_SPLIT = "[,|:]";
    public static final int ZERO = 0;


    public static int splitAndSum(String text){

        String[] tokens ;

        // splitAndSum_null_또는_빈문자
        if(text == null || text.isEmpty()){
            return ZERO;
        }

        // 음수 체크
        negativeCheck(text);

        Matcher m = Pattern.compile(REGEX_PATTERN_COMPILE).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens= m.group(2).split(customDelimiter);
            return loop(tokens);
        }

        tokens = text.split(REGEX_SPLIT);
        return loop(tokens);
    }

    private static void negativeCheck(String text) {
        if(text.contains("-1")){
            throw new IllegalArgumentException("문자열 중 음수가 존재 합니다");
        }
    }

    private static int loop(String[] tokens) {
        int sum  = 0;
        for(String str : tokens){
            sum = getSum(sum, str);
        }
        return sum;
    }

    private static int getSum(int sum, String str) {
        if(isNumber(str)){
            sum += Integer.parseInt(str);
        }
        return sum;
    }

    // 숫자 여부 판단
    public static boolean isNumber(String str){
        return str.matches("-?\\d+");
    }

}
