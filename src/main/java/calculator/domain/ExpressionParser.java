package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class ExpressionParser {

    public ExpressionParser() {}

    public Expression parseExpression(String[] splitUserInput) {
        List<Long> terms = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        for (int pos = 0; pos < splitUserInput.length; pos++) {
            if (isTerm(pos)) {
                terms.add(Long.parseLong(splitUserInput[pos]));
                continue;
            }
            operators.add(splitUserInput[pos]);
        }

        return new Expression(terms, operators);
    }

    private boolean isTerm(int pos) {
        return pos % 2 == 0;
    }
}
