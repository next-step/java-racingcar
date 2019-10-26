package calc.operations;

public class Addition implements Operation {

    @Override
    public double calculate(double op1, double op2) {
        return op1 + op2;
    }
}
