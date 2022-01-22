package calculator.domain;

public class ExpressionParser {

    private Operators operators = new Operators();
    private Terms terms = new Terms();

    private ExpressionParser() {}

    public ExpressionParser(String userInput) {
        String[] splitUserInput = splitUserInputByWhitespace(userInput);

        for (int pos = 0; pos < splitUserInput.length; pos++) {
            String target = splitUserInput[pos];
            if (isTerm(pos)) {
                Validator.validateIsNumber(target);
                terms.addTerm(Double.parseDouble(target));
                continue;
            }
            Validator.validateIsOperator(target);
            operators.addOperator(target);
        }
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
