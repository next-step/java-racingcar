import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberParser {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|:";
    private final String input;

    public NumberParser(String input) {
        this.input = input;
    }

    public String[] parseNumbers() {
        String[] numbers = getCustomDelimiterNumbers();
        if(numbers == null){
            numbers = parseDefaultDelimiterNumbers();
        }
        return numbers;
    }

    private String[] getCustomDelimiterNumbers() {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String inputNumberText = m.group(2);
            return inputNumberText.split(customDelimiter);
        }
        return null;
    }

    private String[] parseDefaultDelimiterNumbers() {
        return input.split(DEFAULT_DELIMITER);
    }
}
