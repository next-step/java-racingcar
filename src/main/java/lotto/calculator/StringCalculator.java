package lotto.calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StringCalculator {
    private static final String INPUT_DELIMITER = " ";
    private static final String WRONG_INPUT_MESSAGE = "입력값이 null 또는 공백일 수 없습니다";

    private final List<Number> numbers;
    private final List<Operator> operators;

    public StringCalculator(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }

        String[] strings = input.split(INPUT_DELIMITER);
        this.numbers = Arrays.stream(strings)
                .filter(StringUtils::isNumeric)
                .map(Number::new)
                .collect(toList());
        this.operators = Arrays.stream(strings)
                .filter(string -> !StringUtils.isNumeric(string))
                .map(Operator::of)
                .collect(toList());
    }

    public Long calculate() {
        Number result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            Operator operator = operators.get(i);
            Number number = numbers.get(i + 1);
            result = operator.operate(result, number);
        }
        return result.number();
    }
}
