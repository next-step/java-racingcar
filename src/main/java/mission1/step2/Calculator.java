package mission1.step2;

import java.util.Objects;

public class Calculator {
    /**
     * 계산
     */
    public Integer calculate (String mathExpression) {

        if (Objects.isNull(mathExpression) || mathExpression.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] splitedMathExpression = mathExpression.split(" ");

        int result = Integer.parseInt(splitedMathExpression[0]);

        for (int i = 1; i < splitedMathExpression.length; i += 2) {
           result = OperatorType.searchOperation(splitedMathExpression[i])
                                .calculate(result, Integer.parseInt(splitedMathExpression[i + 1]));
        }

        return result;
    }
}




