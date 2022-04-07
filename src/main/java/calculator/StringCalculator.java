package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public int addString(String text) {
        if(isBlank(text)){
            return 0;
        }

        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
        if(m.find()){
            String customDelimiter = m.group(1);
            String [] values = split(customDelimiter, m.group(2));
            return sum(toInts(values));
        }

        String[] values = split(DEFAULT_DELIMITER, text);
        return sum(toInts(values));
    }

    private boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private int[] toInts (String [] values){
        int[] numbers = new int[values.length];
        for(int i = 0; i < values.length; i++){
            numbers[i] = toInt(values[i]);
        }
        return numbers;
    }

    private int toInt(String value) {
        int number = Integer.parseInt(value);
        if(number < 0){
            throw new RuntimeException("음수는 불가 합니다.");
        }
        return number;
    }

    private int sum(int[] values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }
        return result;
    }

    private String[] split(String customDelimiter, String text) {
        return text.split(customDelimiter);
    }
}
