package Calculator;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Calculator {
    private final String customSplitterStarter = "//";
    private final String customSplitterEnder = "\\n";
    private final String[] defaultSplitters = {",", ";"};

    public int calculate(String input) {
        if (isNullOrBlank(input)) return 0;
        List<String> numbers = findNumbers(input);
        return calculateSum(convertToIntegers(numbers));
    }

    private List<String> findNumbers(String input) {
        Pair<List<String>, String> result = extractSplittersAndCalculatorValues(input);
        List<String> splitters = result.getLeft();
        String values = result.getRight();
        return Arrays.asList(values.split(String.join("|", splitters)));
    }

    private Boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

    private Pair<List<String>, String> extractSplittersAndCalculatorValues(String input) {
        List<String> splitters = findSplitters(input);
        String calculatorValue = findValue(input);
        return Pair.of(splitters, calculatorValue);
    }

    private List<String> findSplitters(String input) {
        if (!input.startsWith(customSplitterStarter)) return Arrays.asList(defaultSplitters);
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

    private String findValue(String input) {
        if (!input.startsWith(customSplitterStarter)) return input;
        int valueStartIndex = input.indexOf(customSplitterEnder) + customSplitterEnder.length();
        return input.substring(valueStartIndex);
    }

    private List<Integer> convertToIntegers(List<String> values) {
        List<Integer> numbers = new ArrayList<>();

        for (String value : values) {
            int number = Integer.parseInt(value);
            checkNumberValid(number);
            numbers.add(number);
        }
        return numbers;
    }

    private static void checkNumberValid(int number) {
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
