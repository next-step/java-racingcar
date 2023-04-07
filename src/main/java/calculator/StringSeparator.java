package calculator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {

    public static final String DEFAULT_PATTERN = ",|:";
    public static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final int TOKEN_INDEX = 1;
    public static final int DELIMITER_INDEX = 2;


    public List<String> separateStringByDelimiter(Number input) {
        String number = input.getNumber();
        Matcher m = CUSTOM_PATTERN.matcher(number);
        if (m.find()) {
            String customDelimiter = m.group(TOKEN_INDEX);
            String[] numbers = m.group(DELIMITER_INDEX).split(customDelimiter);
            return Arrays.asList(numbers);
        }
        return Arrays.asList(number.split(DEFAULT_PATTERN));
    }
}
