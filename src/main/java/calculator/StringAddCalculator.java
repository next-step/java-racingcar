package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int EMPTY_RETURN = 0;
    private static final int MONO_TEXT = 1;


    public int add(String inputText) throws IllegalArgumentException {
        if(isNull(inputText) || inputText.isEmpty()) {
            return EMPTY_RETURN;
        }
        
        if(inputText.length() == MONO_TEXT) {
            return Integer.parseInt(inputText);
        }

        if (inputText.contains("-")) {
            throw new IllegalArgumentException("음수는 안됩니다");
        }

        if (inputText.contains(",") | inputText.contains(":")) {
            return sum(parseString(inputText));
        }

        if (inputText.contains("//") & inputText.contains("\n")) {
            return sum(convertInts(parseMatcher(inputText)));
        }

        return 0;
    }

    private String[] parseMatcher(String inputText) {
        Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(inputText);
        matcher.find();
        String customDelimiter = matcher.group(1);
        return matcher.group(2).split(customDelimiter);
    }

    private boolean isNull(String inputText) {
        return inputText == null;
    }

    private List<Integer> parseString(String inputText) {
        return convertInts(inputText.split(",|:"));
    }

    private int sum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private List<Integer> convertInts(String[] values) {
        List<Integer> numbers = new ArrayList<>();
        for (int index = 0; index < values.length ; index++) {
            numbers.add(Integer.parseInt(values[index]));
        }
        return numbers;
    }
}
