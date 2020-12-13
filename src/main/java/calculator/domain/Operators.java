package calculator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Operators {
    private static final String VALID_EMPTY_NUMBERS_MESSAGE = "입력 값이 없습니다.";
    private static final String VALID_MIN_SIZE_MESSAGE = "공백을 기준으로 최소 3개 이상 입력바랍니다.";
    private static final int MIN_SIZE = 3;
    private List<Operator> operators;

    public Operators(String[] inputs) {
        validOperators(inputs);
        this.operators = mapOperators(inputs);
    }

    private void validOperators(String[] inputs) {
        validEmpty(inputs);
        validMinSize(inputs);
    }

    private List<Operator> mapOperators(String[] inputs) {
        List<Operator> operators = new ArrayList<>();
        for (int i = 0; i < inputs.length - 2; i += 2) {
            operators.add(Operator.valueOfOperator(inputs[i + 1]));
        }
        return Collections.unmodifiableList(operators);
    }

    private void validEmpty(String[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException(VALID_EMPTY_NUMBERS_MESSAGE);
        }
    }

    private void validMinSize(String[] numbers) {
        if (numbers.length > 0 && numbers.length < MIN_SIZE)
            throw new IllegalArgumentException(VALID_MIN_SIZE_MESSAGE);
    }

    public List<Operator> operators() {
        return this.operators;
    }
}



