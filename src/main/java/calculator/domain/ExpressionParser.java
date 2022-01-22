package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class ExpressionParser {

    private Operators operators;
    private Terms terms;

    private ExpressionParser() {}

    public ExpressionParser(String[] splitUserInput) {
        List<Double> expressionTerms = new ArrayList<>();
        List<String> expressionOperators = new ArrayList<>();

        for (int pos = 0; pos < splitUserInput.length; pos++) {
            if (isTerm(pos)) {
                expressionTerms.add(Double.parseDouble(splitUserInput[pos]));
                continue;
            }
            expressionOperators.add(splitUserInput[pos]);
        }

        terms = new Terms(expressionTerms);
        operators = new Operators(expressionOperators);
    }

    private boolean isTerm(int pos) {
        return pos % 2 == 0;
    }

    public Operators getOperator() {
        return this.operators;
    }

    public Terms getTerms() {
        return this.terms;
    }
}
