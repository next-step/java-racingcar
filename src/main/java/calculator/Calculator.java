package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Calculator {
    private static final String INPUT_IS_NULL_EXCEPTION_MESSAGE = "Input이 Null 입니다.";
    private static final String INPUT_IS_EMPTY_EXCEPTION_MESSAGE = "Input이 공백 입니다.";
    private static final String CAN_NOT_CALCULATE_STRING_FORMAT = "계산 할 수 없는 문자열 입니다.";

    private static final String INPUT_SPLIT_SEPARATOR = " ";

    private static final String PLUS_OPERATOR = "+";

    private Map<String, OperatorFunction> operators = new HashMap<>();

    public Calculator() {
        operators.put(PLUS_OPERATOR, Long::sum);
    }

    public long result(String input) {
        checkInput(input);

        String[] strings = input.split(INPUT_SPLIT_SEPARATOR);
        checkInputFormat(strings);
        return calculate(strings);
    }

    private void checkInput(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(INPUT_IS_NULL_EXCEPTION_MESSAGE);
        }

        if (input.trim().length() == 0) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY_EXCEPTION_MESSAGE);
        }
    }

    private void checkInputFormat(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            checkFormat(i, strings[i]);
        }
    }

    private void checkFormat(int index, String string) {
        if (isEven(index)) {
            checkNumberFormat(string);
            return;
        }
        checkOperator(string);
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }

    private void checkNumberFormat(String string) {
        try {
            Long.parseLong(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CAN_NOT_CALCULATE_STRING_FORMAT);
        }
    }

    private void checkOperator(String string) {
        if (!isSupportOperator(string)) {
            throw new IllegalArgumentException(CAN_NOT_CALCULATE_STRING_FORMAT);
        }
    }

    private boolean isSupportOperator(String string) {
        return operators.containsKey(string);
    }

    private long calculate(String[] strings) {
        long result = Long.parseLong(strings[0]);
        int lastIndex = !isEven(strings.length) ? strings.length : strings.length - 1;

        for (int i = 1; i < lastIndex; i += 2) {
            OperatorFunction operatorFunction = operators.get(strings[i]);
            long nextNumber = Long.parseLong(strings[i + 1]);
            result = operatorFunction.operate(result, nextNumber);
        }
        return result;
    }
}
