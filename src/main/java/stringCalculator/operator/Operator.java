package stringCalculator.operator;

public interface Operator {
    int calculate(int targetA, int targetB, String operation);

    int plus(int targetA, int targetB);

    int minus(int targetA, int targetB);

    int multiply(int targetA, int targetB);

    int divide(int targetA, int targetB);
}
