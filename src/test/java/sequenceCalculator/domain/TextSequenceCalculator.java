package sequenceCalculator.domain;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextSequenceCalculator {

    private static final String DIGIT_REGEX = "\\d+";
    private static final String SEPARATOR_REGEX = ",|:";
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";

    public int calculate(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        if (isDigit(text)) {
            return Integer.parseInt(text);
        }

        String[] splitText = splitBySeparator(text);
        return calculateArraySum(splitText);
    }
    private String[] splitBySeparator(String text){
        Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(text);

        if (m.find()) {
            String customSeparator = m.group(1);
            return m.group(2).split(customSeparator);
        }
        return text.split(SEPARATOR_REGEX);
    }

    private int calculateArraySum(String[] split) {
        return Arrays.stream(split)
            .mapToInt(this::validNumber)
            .reduce(Integer::sum)
            .orElseThrow(NullPointerException::new);
    }

    private boolean isDigit(String text){
        return text.matches(DIGIT_REGEX);
    }

    private int validNumber(String str){
        if(!isDigit(str)){
            throw new NumberFormatException();
        }
        int num = Integer.parseInt(str);
        if(num < 0){
            throw new IllegalArgumentException();
        }
        return num;
    }

}
