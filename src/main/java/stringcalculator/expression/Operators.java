package stringcalculator.expression;

import java.util.ArrayList;
import java.util.List;

public class Operators {

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
        Operator operator = operators.get(0);
        operators.remove(0);
        return operator;
    }

    boolean isEmpty() {
        return operators.isEmpty();
    }
}
