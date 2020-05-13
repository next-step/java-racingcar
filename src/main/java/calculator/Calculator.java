package calculator;

@FunctionalInterface
public interface Calculator {
    float calculate(float beforeOperand, float nextOperand);
}
