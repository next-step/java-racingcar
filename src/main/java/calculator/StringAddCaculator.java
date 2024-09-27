package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCaculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private final static String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private final static Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public static int splitAndSum(String text) {
        int sum = 0;
        if(text == null || text.isEmpty()){
            return 0;
        }
        return getSum(toInts(split(text)));
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
            numbers[i] = Integer.parseInt(textArray[i]);
        }
        return numbers;
    }

    private static int getSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
