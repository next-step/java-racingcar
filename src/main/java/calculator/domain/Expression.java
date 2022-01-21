package calculator.domain;

import java.util.List;

public class Expression {

    private List<Double> terms;
    private List<String> operators;

    public Expression(List<Double> terms, List<String> operators) {
        this.terms = terms;
        this.operators = operators;
    }

    public List<Double> getTerms() {
        return this.terms;
    }

    public List<String> getOperators() {
        return this.operators;
    }
}
