package step2;

import java.math.BigDecimal;

public class Calculator {

    private MathematicalExpression expression;

    public Calculator(MathematicalExpression expression) {
        this.expression = expression;
    }

    public BigDecimal calculate() {
        BigDecimal result = expression.getNumber(0);
        for (int i = 0; i < expression.getOperationCount(); i++) {
            result = expression.getOperator(i).calculate(result, expression.getNumber(i + 1));
        }
        return result;
    }
}
