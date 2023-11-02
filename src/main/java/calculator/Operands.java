package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operands {
    private final static String DEFAULT_DELIMITER_TEXT = ",|:";
    private final static String REGEX_FOR_FIND_CUSTOM_DELIMITER = "//(.)\n(.*)";
    private final static Pattern PATTERN_FOR_FIND_CUSTOM_DELIMITER = Pattern.compile(REGEX_FOR_FIND_CUSTOM_DELIMITER);

    private List<Integer> operands;

    public Operands(String inputText) {
        this.operands = new ArrayList<>();
        if (isTextNullOrEmpty(inputText)) return;

        Delimiter delimiter = new Delimiter(DEFAULT_DELIMITER_TEXT);
        Matcher m = PATTERN_FOR_FIND_CUSTOM_DELIMITER.matcher(inputText);
        if (m.find()) {
            delimiter = new Delimiter(m.group(1));
            inputText = m.group(2);
        }
        String[] tokens = delimiter.split(inputText);
        for (String token : tokens) {
            this.operands.add(parsedInt(token));
        }
    }

    public List<Integer> operands() {
        return this.operands;
    }

    public int sum() {
        int result = 0;
        for (int operand : operands) {
            result += operand;
        }
        return result;
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
