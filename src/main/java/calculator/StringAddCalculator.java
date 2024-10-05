package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text){
        if(isNullOrEmpty(text)){
            return 0;
        }

        return sumAll(toInts(splitString(text)));
    }

    private static boolean isNullOrEmpty(String text){
        return text == null || text.isEmpty();
    }

    private static String[] splitString(String text){
        Matcher matcher  = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER);
    }

    private static int sumAll(int[] numbers){
        int result = 0;
        for(int n : numbers){
            validateNonNegative(n);
            result += n;
        }

        return result;
    }

    private static int[] toInts(String[] texts){
        int[] numbers = new int[texts.length];
        for(int i = 0 ; i < texts.length ; i++){
            numbers[i] = Integer.valueOf(texts[i]);
        }

        return numbers;
    }

    private static void validateNonNegative(int num){
        if(num < 0) throw new RuntimeException("음수는 허용되지 않습니다.");
    }


}
