package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);

    public int addString(String text) {
        if(isBlank(text)){
            return 0;
        }

        Matcher m = pattern.matcher(text);
        if(m.find()){
            String customDelimiter = m.group(1);
            String [] values = split(customDelimiter, m.group(2));
            return sum(values);
        }

        String[] values = split(DEFAULT_DELIMITER, text);
        return sum(values);
    }

    private boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private int sum (String [] values){
        return Arrays.stream(values)
            .map(PositiveNumber::new)
            .collect(Collectors.toList())
            .stream()
            .mapToInt(PositiveNumber::getValue)
            .sum();
    }

    private String[] split(String customDelimiter, String text) {
        return text.split(customDelimiter);
    }
}
