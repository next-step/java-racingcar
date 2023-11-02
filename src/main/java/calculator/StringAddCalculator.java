package calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private final String DEFAULT_DELIMITER_TEXT = ",|:";
    private final String REGEX_FOR_FIND_CUSTOM_DELIMITER = "//(.)\n(.*)";
    private final Pattern PATTERN_FOR_FIND_CUSTOM_DELIMITER = Pattern.compile(REGEX_FOR_FIND_CUSTOM_DELIMITER);

    public int splitAndSum(String text) {
        Operands operands = getOperandsFromText(text);
        return operands.sum();
    }

    private Operands getOperandsFromText(String text) {
        Operands operands = new Operands(new ArrayList<>());
        if (isTextNullOrEmpty(text)) {
            return operands;
        }
        Delimiter delimiter = new Delimiter(DEFAULT_DELIMITER_TEXT);
        Matcher m = PATTERN_FOR_FIND_CUSTOM_DELIMITER.matcher(text);
        if (m.find()) {
            delimiter = new Delimiter(m.group(1));
            text = m.group(2);
        }
        String[] tokens = text.split(delimiter.delimiter());
        for (String token : tokens) {
            operands.add(parsedInt(token));
        }
        return operands;
    }

    private boolean isTextNullOrEmpty(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }

    private int parsedInt(String text) {
        int result = Integer.parseInt(text);
        if (result < 0) {
            throw new ValidationException("음수는 사용할 수 없습니다.");
        }
        return result;
    }
}
