package calculator;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

public class Calculator {
    private static final String SPACE = " ";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[+-]?\\d*(\\.?\\d*)$");
    private static final Pattern BLANK_PATTERN = Pattern.compile("\\s*");
    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATE = ImmutableMap.of(
            "+", (number1, number2) -> number1 + number2,
            "-", (number1, number2) -> number1 - number2,
            "*", (number1, number2) -> number1 * number2,
            "/", (number1, number2) -> {
                dividerValidator(number2);
                return number1 / number2;
            }
    );

    public int calculate(String input) {
        argumentValidation(input);

        String[] inputs = input.split(SPACE);
        int result = toInteger(inputs[0]);

        for(int i = 1; i <= inputs.length - 2; i += 2 ) {
            int nextNumber = toInteger(inputs[i+1]);
            result = calculate(result, inputs[i], nextNumber);
        }

        return result;
    }

    public int calculate(int input1, String operator, int input2) {
        operatorValidation(operator);

        return OPERATE.get(operator).apply(input1, input2);
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

    private void argumentValidation(String input) {
        if (Objects.isNull(input) || BLANK_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("유효하지 않은 입력값 입니다. 공백을 입력하지 마세요.");
        }
    }

    private void operatorValidation(String operator) {
        if (!OPERATE.containsKey(operator)) {
            throw new IllegalArgumentException(operator + " 는 유효하지 않은 사칙연산 기호입니다. +, -, *, / 중 한개를 입력하세요.");
        }
    }

    private static void dividerValidator(int divider) {
        if (divider == 0) {
            throw new ArithmeticException("0 은 나눗셈을 할 수 없습니다. 다시 입력해주세요.");
        }
    }
}
