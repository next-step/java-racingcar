package calculator;

import java.util.ArrayList;
import java.util.List;

public class Operators extends InputValid {
    private static final String WRONG_INPUT = "입력값이 잘못되었습니다.";
    private final List<Operator> operators = new ArrayList<>();;

    public Operators(String[] inputArray) {
        operatorsValidation(inputArray);
        for (int i = 1; i < inputArray.length; i += 2) {
            operators.add(Operator.getOperator(inputArray[i]));
        }
    }

    public Operator get(int index) {
        return operators.get(index);
    }

    private void operatorsValidation(String[] input) {
        if (isNull(input) || isEmpty(input) || isNotAble(input)) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }
}
