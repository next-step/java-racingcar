package calculator.operator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberOperator {

    private Integer value;

    public NumberOperator(Integer value) {
        validateNegative(value);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public Integer sum(NumberOperator number) {
        value += number.getValue();
        return value;
    }

    private void validateNegative(Integer number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    public List<NumberOperator> parseNumberOperators(String[] numbers) {
        return Arrays.stream(numbers)
                .map(this::stringToInt)
                .collect(Collectors.toList());
    }

    private NumberOperator stringToInt(String numberStr) {
        if (!numberStr.isBlank()) {
            return new NumberOperator(Integer.parseInt(numberStr));
        }

        return new NumberOperator(0);
    }
}
