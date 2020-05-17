package stringcalculator;

@FunctionalInterface
public interface BinaryExpression {
    int operate(int a, int b);
}
