package calculator.domain;

import java.util.InputMismatchException;

public class ExpressionParser {

    private static final String BLANK = "\\s+";

    private Terms terms;
    private Operators operators;

    public ExpressionParser(String userInput) {
        terms = new Terms();
        operators = new Operators();

        while (true) {
            String[] splitUserInput = splitUserInputByWhitespace(userInput);

            try {
                parse(splitUserInput);
                break;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                userInput = Input.getUserInput();
                rollback();
            }
        }
    }

    private String[] splitUserInputByWhitespace(String userInput) {
        return userInput.split(BLANK);
    }

    private void parse(String[] splitUserInput) {
        for (int pos = 0; pos < splitUserInput.length; pos++) {
            String target = splitUserInput[pos];

            if (isTerm(pos)) {
                addTerm(target);
                continue;
            }
            addOperator(target);
        }
    }

    private boolean isTerm(int pos) {
        return pos % 2 == 0;
    }

    private void addTerm(String target) {
        Validator.validateIsNumber(target);
        terms.addTerm(Double.parseDouble(target));
    }

    private void rollback() {
        operators.getOperators().clear();
        terms.getTerms().clear();
    }

    private void addOperator(String target) {
        Validator.validateIsOperator(target);
        operators.addOperator(Operator.get(target));
    }

    public Operators getOperators() {
        return this.operators;
    }

    public Terms getTerms() {
        return this.terms;
    }
}
