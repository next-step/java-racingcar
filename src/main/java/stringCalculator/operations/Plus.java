package stringCalculator.operations;

public class Plus implements OperatorInterface {

    public Plus() {

    }

    public String getSymbol() {
        return "+";
    }

    @Override
    public int execute(int operand1, int operand2) {
        return operand1 + operand2;
    }
}
