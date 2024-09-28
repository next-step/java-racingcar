package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public final class Calculator {
    private final String customSplitterStarter = "//";
    private final String customSplitterEnder = "\\n";
    private final String[] defaultSplitters = {",", ";"};
    private final int defaultReturnValue = 0;
    private final String regexSpecialChars = ".^$*+?{}[]()|\\";

    public int calculate(String input) {
        if (isNullOrBlank(input)) {
            return defaultReturnValue;
        }
        List<Integer> numbers = parseNumbers(input);
        return calculateSum(numbers);
    }

    private boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

    private List<Integer> parseNumbers(String input) {
        return convertToIntegers(parseStringNumbers(input));
    }

    private List<String> parseStringNumbers(String input) {
        List<String> splitters = findSplitters(input);
        String numberString = findNumberString(input);
        String splitRegex = convertToRegex(splitters);
        return Arrays.asList(numberString.split(splitRegex));
    }

    private List<String> findSplitters(String input) {
        if (!input.startsWith(customSplitterStarter)) {
            return Arrays.asList(defaultSplitters);
        }
        String customSplitter = findCustomSplitter(input);
        List<String> splitters = new ArrayList<>(Arrays.asList(defaultSplitters));
        splitters.add(customSplitter);
        return splitters;
    }

    private String findCustomSplitter(String input) {
        int startIndex = input.indexOf(customSplitterStarter) + customSplitterStarter.length();
        int endIndex = input.indexOf(customSplitterEnder);
        return input.substring(startIndex, endIndex);
    }

    private String findNumberString(String input) {
        if (!input.startsWith(customSplitterStarter)) {
            return input;
        }
        int valueStartIndex = input.indexOf(customSplitterEnder) + customSplitterEnder.length();
        return input.substring(valueStartIndex);
    }

    private String convertToRegex(List<String> splitters) {
        List<String> splittersWithEscape = escapeSplitters(splitters);
        return String.join("|", splittersWithEscape);
    }

    private List<String> escapeSplitters(List<String> splitters) {
        List<String> splittersWithEscape = new ArrayList<>();

        for (String splitter : splitters) {
            String splitterWithEscape = escapeSplitter(splitter);
            splittersWithEscape.add(splitterWithEscape);
        }
        return splittersWithEscape;
    }

    private String escapeSplitter(String splitter) {
        if (splitter.chars().anyMatch(ch -> regexSpecialChars.indexOf(ch) >= 0)) {
            return Pattern.quote(splitter);
        }
        return splitter;
    }

    private List<Integer> convertToIntegers(List<String> stringNumbers) {
        List<Integer> numbers = new ArrayList<>();

        for (String stringNumber : stringNumbers) {
            int number = convertToInteger(stringNumber);
            numbers.add(number);
        }
        return numbers;
    }

    private int convertToInteger(String stringNumber) {
        try {
            int number = Integer.parseInt(stringNumber);
            checkInputNumberIsAllowed(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 포멧이 맞지 않습니다: " + stringNumber);
        }
    }

    private void checkInputNumberIsAllowed(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수 값이 삽입되었습니다.");
        }
    }

    private int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
