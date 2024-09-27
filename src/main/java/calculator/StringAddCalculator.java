package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private final static String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private final static Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public static int splitAndSum(String text) {
        if(isBlank(text)){
            return 0;
        }
        return getSum(toInts(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if(matcher.find()){
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER);
    }

    private static int[] toInts(String[] textArray){
        int[] numbers = new int[textArray.length];
        for(int i = 0; i < textArray.length; i++){
            numbers[i] = toInt(textArray[i]);
        }
        return numbers;
    }

    private static int toInt(String text) {
        int number = Integer.parseInt(text);
        if(number < 0){
            throw new IllegalArgumentException("음수를 입력할 수 없습니다");
        }
        return number;
    }

    private static int getSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
