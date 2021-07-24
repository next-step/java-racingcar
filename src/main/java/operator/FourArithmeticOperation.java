package operator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourArithmeticOperation {

    private final List<Operator> operators = Collections.unmodifiableList(Arrays.asList(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator()));

    public boolean isOperationSymbol(String input) {
        return operators.stream()
                .anyMatch(operator -> operator.isTarget(input));
    }

    public Operator findOperatorByString(String input) {
        return operators.stream()
                .filter(operator -> operator.isTarget(input))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
