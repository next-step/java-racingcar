import java.util.LinkedList;
import java.util.List;

public class ArithmeticArguments {
    private final LinkedList<Integer> operands;
    private final List<Operator> operators;

    public ArithmeticArguments(String expression) {
        this.operands = new LinkedList<>(ArithmeticParser.extractOperandsFromString(expression));
        this.operators = ArithmeticParser.extractOperationsFromString(expression);
    }

    public ArithmeticArguments(List<Integer> operands, List<Operator> operators) {
        this.operators = operators;
        this.operands = new LinkedList<>(operands);
    }

    public Integer[] nextOperands() {
        return new Integer[]{this.operands.remove(), this.operands.remove()};
    }

    public Operator nextOperator() {
        return operators.remove(0);
    }

    public boolean hasNextOperator() {
        return !operators.isEmpty();
    }

    public void setResult(Integer result) {
        this.operands.addFirst(result);
    }

    public int getResult() {
        return operands.remove();
    }
}
