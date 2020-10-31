package stringCalculator;


import stringCalculator.operations.Divide;
import stringCalculator.operations.Minus;
import stringCalculator.operations.Multiply;
import stringCalculator.operations.OperatorInterface;
import stringCalculator.operations.Plus;

import java.util.HashMap;
import java.util.Map;

public class Operator {

    private Map<String, OperatorInterface> symbolExpressionMatching;

    private Operator() {
        symbolExpressionMatching = new HashMap<>();
    }

    static Operator getInstance() {
        Operator operator = new Operator();

        operator.register(new Plus());
        operator.register(new Minus());
        operator.register(new Multiply());
        operator.register(new Divide());

        return operator;
    }

    void register(OperatorInterface operatorInterface) {
        this.symbolExpressionMatching.put(operatorInterface.getSymbol(), operatorInterface);
    }

    boolean isValidOperator(String operator) {
        return symbolExpressionMatching.containsKey(operator);
    }

    int calculateWithOperator(int operand1, String operator, int operand2) {
        OperatorInterface operatorInterface = this.symbolExpressionMatching.get(operator);
        return operatorInterface.execute(operand1, operand2);
    }

}
