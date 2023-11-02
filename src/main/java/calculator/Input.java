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
            String customDelimiter = matcher.group(1);
            return toNumbers(matcher.group(2).split(customDelimiter));
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
