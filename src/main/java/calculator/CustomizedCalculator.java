package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CustomizedCalculator implements Calculatable {
    @Override
    public void validateInput(String input) throws IllegalArgumentException {
        char customDelimiter = input.charAt(2);
        String parsedInput = input.substring(5);
        if (!parsedInput.matches("\\d*[,|:|" + customDelimiter + "\\d]*")) {
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION);
        }
    }

    @Override
    public List<Integer> parseInput(String input) {
        Matcher matcher = Pattern.compile("\\/\\/(.)\\\\n(.*)").matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);
            return Calculatable.stringArrayToList(tokens);
        }
        return List.of();
    }
}
