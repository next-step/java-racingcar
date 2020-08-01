import java.util.List;

public class ArithmeticArguments {
    private final List<Integer> operands;
    private final List<Operator> operators;

    public ArithmeticArguments(String expression) {
        this.operands = ArithmeticParser.extractOperandsFromString(expression);
        this.operators = ArithmeticParser.extractOperationsFromString(expression);
    }

    public Integer nextOperand() {return this.operands.remove(0);}

    public Operator nextOperator() {
        return this.operators.remove(0);
    }

    public boolean hasNextOperator() {
        return !operators.isEmpty();
    }
}
