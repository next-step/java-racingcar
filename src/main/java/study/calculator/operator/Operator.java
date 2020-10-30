package study.calculator.operator;

public interface Operator {

    boolean isOperator(String expression);
    int operate(Operand firstArg, Operand secondArg);
}
