package calculator.domain;

import java.util.InputMismatchException;

public class ExpressionParser {

    private Operators operators = new Operators();
    private Terms terms = new Terms();

    private ExpressionParser() {}

    public ExpressionParser(String userInput) {
        String[] splitUserInput = splitUserInputByWhitespace(userInput);

        for (int pos = 0; pos < splitUserInput.length; pos++) {
            try {
                parse(splitUserInput, pos);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                operators = null;
                terms = null;
                break;
            }

        }
    }

    private void parse(String[] splitUserInput, int pos) {
        String target = splitUserInput[pos];
        if (isTerm(pos)) {
            addTerm(target);
            return;
        }
        addOperator(target);
    }

    private void addTerm(String target) {
        Validator.validateIsNumber(target);
        terms.addTerm(Double.parseDouble(target));
    }

    private void addOperator(String target) {
        Validator.validateIsOperator(target);
        operators.addOperator(target);
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
