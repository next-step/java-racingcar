package calculator;

public class Calculator {
    public int calculate(Expression e) {
        Integer result = null;
        while (!e.isEmpty()) {
            SimpleExpression se = e.extractSimpleExpression();
            result = calSimpleExp(se);
            e.addOperand(result);
        }
        return result;
    }

    private int calSimpleExp(SimpleExpression se){
        return se.getOperator().operate(se.getOperandPair());
    }
}
