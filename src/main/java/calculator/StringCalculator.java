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
            return sum(toPositiveNumbers(values));
        }

        String[] values = split(DEFAULT_DELIMITER, text);
        return sum(toPositiveNumbers(values));
    }

    private boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private PositiveNumber[] toPositiveNumbers(String [] values){
        PositiveNumber [] numbers = new PositiveNumber[values.length];
        for(int i = 0; i < values.length; i++){
            numbers[i] = new PositiveNumber(values[i]);
        }
        return numbers;
    }

    private int sum(PositiveNumber[] numbers) {
        int result = 0;
        for (PositiveNumber number : numbers) {
            result += number.getValue();
        }
        return result;
    }

    private String[] split(String customDelimiter, String text) {
        return text.split(customDelimiter);
    }
}
