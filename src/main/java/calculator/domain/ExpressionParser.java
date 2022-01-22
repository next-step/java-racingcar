package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class ExpressionParser {

    private Operators operators;
    private Terms terms;

    private ExpressionParser() {
    }

    public ExpressionParser(String userInput) {
        String[] splitUserInput = splitUserInputByWhitespace(userInput);

        List<Double> expressionTerms = new ArrayList<>();
        List<String> expressionOperators = new ArrayList<>();

        for (int pos = 0; pos < splitUserInput.length; pos++) {
            String target = splitUserInput[pos];
            if (isTerm(pos)) {
                Validator.validateIsNumber(target);
                expressionTerms.add(Double.parseDouble(target));
                continue;
            }
            Validator.validateIsOperator(target);
            expressionOperators.add(target);
        }

        terms = new Terms(expressionTerms);
        operators = new Operators(expressionOperators);
    }

    private String[] splitUserInputByWhitespace(String userInput) {
        return userInput.split("\\s+");
    }

    private boolean isTerm(int pos) {
        return pos % 2 == 0;
    }

    public Operators getOperators() {
        return this.operators;
    }

    public Terms getTerms() {
        return this.terms;
    }
}
