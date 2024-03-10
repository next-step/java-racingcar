package calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {

    private final static String CUSTOM_PATTERN = "//(.)\n(.*)";
    private final static String COMMON_PATTERN = ",|:";

    public static int process(final String value){
        if(isNullOrEmpty(value)) return 0;
        Matcher matcher = generateMatcher(value);
        String[] splitValues = getSplit(value, matcher);
        validate(splitValues);
        int[] numbers = toInts(splitValues);
        return sum(numbers);
    }

    private static boolean isNullOrEmpty(final String value) {
        if(value == null) return true;
        return "".equals(value);
    }

    private static Matcher generateMatcher(final String value) {
        return Pattern.compile(CUSTOM_PATTERN).matcher(value);
    }

    private static String[] getSplit(final String value, final Matcher matcher) {
        if(isCustom(matcher)) return split(matcher);
        return split(value);
    }

    private static boolean isCustom(final Matcher matcher) {
        return matcher.find();
    }

    private static String[] split(final Matcher matcher){
        String customDelimiter = matcher.group(1);
        return matcher.group(2).split(customDelimiter);
    }

    private static String[] split(final String value){
        return value.split(COMMON_PATTERN);
    }

    private static void validate(final String[] values){
        for(String value : values){
            isNumber(value);
            isNegative(value);
        }
    }

    private static void isNumber(String value){
        try {
            Integer.parseInt(value);
        }catch (NumberFormatException e){
            throw new RuntimeException();
        }
    }

    private static void isNegative(String value){
        int number = Integer.parseInt(value);
        if(number < 0) throw new RuntimeException();
    }

    private static int[] toInts(final String[] strings) {
        int[] numbers = new int[strings.length];
        for(int i =0; i < strings.length; i++){
            numbers[i] = Integer.parseInt(strings[i]);
        }
        return numbers;
    }

    private static int sum(final int[] numbers){
        int result = 0;
        for(int number : numbers){
            result += number;
        }
        return result;
    }
}
