package stringCalculator.operations;

public class Multiply implements OperatorInterface{

    public Multiply(){

    }

    @Override
    public int execute(int operand1, int operand2) {
        return operand1 * operand2;
    }

    @Override
    public String getSymbol() {
        return "*";
    }
}
