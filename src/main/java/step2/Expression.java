package step2;

import java.util.LinkedList;
import java.util.List;

public class Expression {

    List<Operand> operands = new LinkedList<>();
    List<Operator> operators = new LinkedList<>();

    public Expression(String expression) {
        validateExpression(expression);
        init(expression);
    }

    private void validateExpression(String expression) {
        if (expression == null || expression.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void init(String expression) {
        String[] split = expression.split(" ");
        for (int i = 0; i < split.length; i += 2) {
            operands.add(new Operand(split[i]));
        }
        for (int i = 1; i < split.length; i += 2) {
            operators.add(Operator.getOperator(split[i]));
        }
    }

    //비즈니스 메서드
    public boolean hasNext() {
        return operands.size() > 0 && operators.size() > 0;
    }

    public Operand nextOperand() {
        if (operands.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return operands.remove(0);
    }

    public Operator nextOperator() {
        if (operators.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return operators.remove(0);
    }
}
