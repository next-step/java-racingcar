package calculator;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

public class Calculator {
    private static final String SPACE = " ";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");
    private static final Pattern BLANK_PATTERN = Pattern.compile("\\s*");
    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATE = ImmutableMap.of(
            "+", (number1, number2) -> number1 + number2,
            "-", (number1, number2) -> number1 - number2,
            "*", (number1, number2) -> number1 * number2,
            "/", (number1, number2) -> number1 / number2
    );

    public int calculate(String input) {
        checkArgumentValidation(input);

        String[] inputs = input.split(SPACE);
        return calculate(inputs[0], inputs[2], inputs[1]);
    }

    public int calculate(String input1, String input2, String operator) {
        if (!OPERATE.containsKey(operator)) {
            throw new IllegalArgumentException("유효하지 않은 사칙연산 기호입니다. +, -, *, / 중 한개를 입력하세요.");
        }

        int intInput1 = toInteger(input1);
        int intInput2 = toInteger(input2);

        return OPERATE.get(operator).apply(intInput1, intInput2);
    }

    private int toInteger(String input) {
        if (Objects.nonNull(input) && isNumber(input)) {
            return Integer.parseInt(input);
        }

        return 0;
    }

    private boolean isNumber(String input) {
        return NUMBER_PATTERN.matcher(input).matches();
    }

    private void checkArgumentValidation(String input) {
        if (Objects.isNull(input) || BLANK_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("유효하지 않은 입력값 입니다. 공백을 입력하지 마세요.");
        }
    }
}
