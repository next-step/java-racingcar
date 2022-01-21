package calculator.domain;

import java.util.List;

public class Expression {

    protected static final String OPERATORS = "+-*/";

    private List<Long> terms;
    private List<String> operators;

    public Expression(List<Long> terms, List<String> operators) {
        this.terms = terms;
        this.operators = operators;
    }

    public List<Long> getTerms() {
        return this.terms;
    }

    public List<String> getOperators() {
        return this.operators;
    }
}
