public class Calculator {
    private final Expression e;

    public Calculator(Expression e) {
        this.e = e;
    }

    public int calculate() {
        SimpleExpression se = e.extractSimpleExpression();
        return calSimpleExp(se);
    }

    private int calSimpleExp(SimpleExpression se){
        return se.getOperator().operate(se.getOperandPair());
    }
}
