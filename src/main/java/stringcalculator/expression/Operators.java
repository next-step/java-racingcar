package stringcalculator.expression;

import java.util.ArrayList;
import java.util.List;

public class Operators {

    private static final int FIRST_INDEX = 0;
    private List<Operator> operators = new ArrayList<>();

    Operators(Expression expression) {
        for (String item : expression.getExpression()) {
            try {
                Long.parseLong(item);
            } catch (NumberFormatException e) {
                operators.add(new Operator(item));
            }
        }
    }

    int size() {
        return operators.size();
    }

    Operator getFirstOneAndRemove() {
        Operator operator = operators.get(FIRST_INDEX);
        operators.remove(FIRST_INDEX);
        return operator;
    }

    boolean isEmpty() {
        return operators.isEmpty();
    }
}
