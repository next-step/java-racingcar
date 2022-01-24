package calculator.domain;

import java.io.IOException;
import java.util.InputMismatchException;

public class ExpressionParser {

    private Operators operators = new Operators();
    private Terms terms = new Terms();

    private ExpressionParser() {}

    public ExpressionParser(String userInput) throws IOException {

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
        return userInput.split("\\s+");
    }

    private void rollback() {
        operators.getOperators().clear();
        terms.getTerms().clear();
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

    private void addOperator(String target) {
        Validator.validateIsOperator(target);
        operators.addOperator(target);
    }

    public Operators getOperators() {
        return this.operators;
    }

    public Terms getTerms() {
        return this.terms;
    }
}
