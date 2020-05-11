package stringCalculator.operator;

import stringCalculator.exception.CannotBeDividedIntoZeroException;
import stringCalculator.exception.NotSupportedOperationException;

public class FourArithmeticOperator implements Operator {

    @Override
    public int calculate(int targetA, int targetB, String operation) {
        if (operation.equals("+")) {
            return plus(targetA, targetB);
        }

        if (operation.equals("-")) {
            return minus(targetA, targetB);
        }

        if (operation.equals("*")) {
            return multiply(targetA, targetB);
        }

        if (operation.equals("/")) {
            return divide(targetA, targetB);
        }

        throw new NotSupportedOperationException();
    }

    @Override
    public int plus(int targetA, int targetB) {
        return targetA + targetB;
    }

    @Override
    public int minus(int targetA, int targetB) {
        return targetA - targetB;
    }

    @Override
    public int multiply(int targetA, int targetB) {
        return targetA * targetB;
    }

    @Override
    public int divide(int targetA, int targetB) {
        if (targetB == 0) {
            throw new CannotBeDividedIntoZeroException();
        }

        return targetA / targetB;
    }
}
