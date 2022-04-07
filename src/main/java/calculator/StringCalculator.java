package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    private List<PositiveNumber> toPositiveNumbers(String [] values){
        return Arrays.stream(values)
            .map(value -> new PositiveNumber(value))
            .collect(Collectors.toList());
    }

    private int sum(List<PositiveNumber> numbers) {
        PositiveNumber result = new PositiveNumber(0);
        numbers.stream().forEach(number -> result.plus(number));
        return result.getValue();
    }

    private String[] split(String customDelimiter, String text) {
        return text.split(customDelimiter);
    }
}
