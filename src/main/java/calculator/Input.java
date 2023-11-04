package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Input {

    private static final String DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int NEGATIVE_NUMBER_STANDARD = 0;
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int CUSTOM_DELIMITER_TEXT = 2;

    private final String text;

    public Input(String text) {
        this.text = text;
    }

    public boolean isEmptyOrNull() {
        return this.text == null || this.text.isBlank();
    }

    public List<Integer> toNumbers() {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
            return toNumbers(matcher.group(CUSTOM_DELIMITER_TEXT).split(customDelimiter));
        }
        return toNumbers(text.split(DELIMITER));
    }

    private List<Integer> toNumbers(String[] tokens) {
        return Arrays.stream(tokens)
                .map(strNumber -> {
                    int number = toIntBy(strNumber);
                    validateNegativeBy(number);
                    return number;
                })
                .collect(Collectors.toList());
    }

    public int toIntBy(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            throw new NotNumberException();
        }
    }

    private void validateNegativeBy(int number) {
        if (number < NEGATIVE_NUMBER_STANDARD) {
            throw new NegativeNumberException();
        }
    }

}
