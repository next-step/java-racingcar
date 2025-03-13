package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsedInput {
    private static final String DEFAULT_DELIMITER = ",|:";
    private String delimiter = DEFAULT_DELIMITER;
    private String[] numbers;

    public ParsedInput(String input) {
        parseInput(input);
    }

    public String[] getNumbers() {
        return numbers;
    }

    private void parseInput(String input) {
        Pattern pattern = Pattern.compile("//(.)\\n(.*)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            delimiter = matcher.group(1);
            input = matcher.group(2);
        }

        numbers = input.split(delimiter);
    }
}
