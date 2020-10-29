package study.calculator.operator;

public interface Operator {

    boolean isOperator(String expression);
    Integer operate(Operand firstArg, Operand secondArg);
}
