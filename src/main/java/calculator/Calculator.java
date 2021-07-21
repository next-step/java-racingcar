package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static calculator.Operator.PLUS;

public class Calculator {

    public Calculator() {

    }

    public int calculate(String input) {
        int result = 0;

        final List<String> values = getInputsBySplitWhiteSpace(input);
        final List<Integer> numbers = getNumbersByInputs(values);
        final List<Operator> operators = getOperationsByInputs(values);

        int index = 0;
        for (Operator operator : operators) {
            int prev = result;
            int next = numbers.get(index++);
            result = operator.operate(prev, next);
        }

        return result;
    }

    private List<Operator> getOperationsByInputs(List<String> values) {
        List<Operator> operators = values.stream()
                .filter(this::isNotNumber)
                .map(Operator::withSign)
                .collect(Collectors.toList());
        operators.add(0, PLUS);
        return operators;
    }

    private List<Integer> getNumbersByInputs(List<String> values) {
        return values.stream()
                .filter(this::isNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<String> getInputsBySplitWhiteSpace(String value) {
        if (isBlank(value)) {
            throw new IllegalArgumentException("입력 값이 null 이거나 빈 공백 문자일 수 없습니다.");
        }
        return Arrays.stream(value.split(" "))
                .collect(Collectors.toList());
    }

    private boolean isBlank(String value) {
        return Objects.isNull(value) || "".equalsIgnoreCase(value);
    }

    private boolean isNotNumber(String input) {
        return !isNumber(input);
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
