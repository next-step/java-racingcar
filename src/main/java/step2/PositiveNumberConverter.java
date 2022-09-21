package step2;

import java.util.regex.Pattern;

public class PositiveNumberConverter {

    private static final String NUMBER_ONLY_REGEX = "\\d";
    private final Pattern numberPattern;

    public PositiveNumberConverter() {
        this.numberPattern = Pattern.compile(NUMBER_ONLY_REGEX);
    }

    public Integer toPositive(String source) {
        valid(source);
        return Integer.parseInt(source);
    }

    private void valid(String source) {
        if (!isNumeric(source)) {
            throw new RuntimeException("Positive Number Only");
        }
    }

    private boolean isNumeric(String source) {
        return numberPattern.matcher(source).matches();
    }
}
