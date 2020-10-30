public class Calculator {
    public int calculate(Expression e) {
        SimpleExpression se = e.extractSimpleExpression();
        return calSimpleExp(se);
    }

    private int calSimpleExp(SimpleExpression se){
        return se.getOperator().operate(se.getOperandPair());
    }
}
