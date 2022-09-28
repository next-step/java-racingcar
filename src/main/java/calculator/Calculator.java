package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Calculator {
    protected static final String INVALID_INPUT_EXCEPTION = "문자열 계산기에 숫자 이외의 값 또는 음수가 전달 될 수 없습니다.";
    private static SimpleCalculator simpleCalculator = null;
    private static CustomizedCalculator customizedCalculator = null;

    public static int sum(String input) throws IllegalArgumentException {
        if (hasNoInput(input)) {
            return 0;
        }

        if (isCustomizedInput(input)) {
            return customizedCalculate(input);
        }

        return simpleCalculate(input);
    }

    private static int customizedCalculate(String input) {
        if (customizedCalculator == null) {
            customizedCalculator = new CustomizedCalculator();
        }
        return calculate(customizedCalculator, input);
    }

    private static int simpleCalculate(String input) {
        if (simpleCalculator == null) {
            simpleCalculator = new SimpleCalculator();
        }
        return calculate(simpleCalculator, input);
    }

    private static boolean hasNoInput(String input) {
        return input == null || input.isBlank();
    }

    private static boolean isCustomizedInput(String input) {
        return input.matches("//(.)+\\\\n+(.*)");
    }

    protected static List<Integer> stringArrayToList(String[] tokens) {
        return Arrays.stream(tokens).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static int calculate(Calculator calculator, String input) {
        calculator.validateInput(input);
        return calculator.parseInput(input).stream().mapToInt(e -> e).sum();
    }

    protected abstract void validateInput(String input) throws IllegalArgumentException;

    protected abstract List<Integer> parseInput(String input);
}
