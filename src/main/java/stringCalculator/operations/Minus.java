package stringCalculator.operations;

public class Minus implements OperatorInterface {

    public Minus() {

    }

    @Override
    public int execute(int operand1, int operand2) {
        return operand1 - operand2;
    }

    @Override
    public String getSymbol() {
        return "-";
    }
}
