package stringCalculator.operations;

public class Divide implements OperatorInterface{
    public Divide(){

    }

    @Override
    public int execute(int operand1, int operand2) {
        return operand1 / operand2;
    }

    @Override
    public String getSymbol() {
        return "/";
    }
}
