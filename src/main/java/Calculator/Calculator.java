package Calculator;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Calculator {
    private final String customSplitterStarter = "//";
    private final String customSplitterEnder = "\\n";
    private final String[] defaultSplitters = {",", ";"};

    public int calculate(String inputs) {
        if (isNullOrBlank(inputs)) return 0;
        List<String> numbers = findNumbers(inputs);
        return calculateSum(convertToIntegers(numbers));
    }

    private List<String> findNumbers(String inputs) {
        Pair<List<String>, String> result = extractSplittersAndCalculatorValues(inputs);
        List<String> splitters = result.getLeft();
        String values = result.getRight();
        return Arrays.asList(values.split(String.join("|", splitters)));
    }

    private Boolean isNullOrBlank(String inputs) {
        return inputs == null || inputs.isBlank();
    }

    private Pair<List<String>, String> extractSplittersAndCalculatorValues(String inputs) {
        List<String> splitters = findSplitters(inputs);
        String calculatorValue = findValue(inputs);
        return Pair.of(splitters, calculatorValue);
    }

    private List<String> findSplitters(String inputs) {
        if (!inputs.startsWith(customSplitterStarter)) return Arrays.asList(defaultSplitters);
        String customSplitter = findCustomSplitter(inputs);
        List<String> splitters = new ArrayList<>(Arrays.asList(defaultSplitters));
        splitters.add(customSplitter);
        return splitters;
    }

    private String findCustomSplitter(String inputs) {
        int startIndex = inputs.indexOf(customSplitterStarter) + customSplitterStarter.length();
        int endIndex = inputs.indexOf(customSplitterEnder);
        return inputs.substring(startIndex, endIndex);
    }

    private String findValue(String inputs) {
        if (!inputs.startsWith(customSplitterStarter)) return inputs;
        int valueStartIndex = inputs.indexOf(customSplitterEnder) + customSplitterEnder.length();
        return inputs.substring(valueStartIndex);
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
