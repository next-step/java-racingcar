package calc.operations;

import calc.operations.Operation;

public class Multiplication implements Operation {

    @Override
    public double calculate(double op1, double op2) {
        return op1 * op2;
    }
}
