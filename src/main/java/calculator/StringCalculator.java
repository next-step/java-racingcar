package calculator;

import java.util.Objects;

public class StringCalculator {

    public static final int DEFAULT_VALUE = 0;
    public static final String SPLIT_REGEX = "[,:]";

    public int calculate(String text) {
        if (isEmpty(text)) {
            return DEFAULT_VALUE;
        }
        String[] splitTexts = getSplitTexts(text);
        return calculate(splitTexts);
    }

    private int calculate(String[] splitTexts) {
        int result = 0;
        for (String splitText : splitTexts) {
            int parsedValue = Integer.parseInt(splitText);
            result += parsedValue;
        }
        return result;
    }

    private String[] getSplitTexts(String text) {
        return text.split(SPLIT_REGEX);
    }

    private boolean isEmpty(String text) {
        if (Objects.isNull(text)) {
            return true;
        }
        return text.isEmpty();
    }
}
