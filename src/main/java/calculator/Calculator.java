package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static final String DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public static int cal(String text) {
        if(isBlank(text)) return 0;
        return sum(toInts(split(text)));
    }

    private static String[] split(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if(matcher.find()) return matcher.group(2).split(matcher.group(1));
        return text.split(DELIMITERS);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers){
            if(number < 0) throw new RuntimeException("양수만 입력 가능 합니다.");
            sum += number;
        }
        return sum;
    }

    private static int[] toInts(String[] values){
        int len = values.length;
        int[] numbers = new int[len];
        for (int i=0; i< len; i++){
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }
}
