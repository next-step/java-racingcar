package calculator.domain;

import java.util.List;

public class Terms {

    private List<Double> terms;
    private int pointer = 0;


    private Terms() {}

    public Terms(List<Double> terms) {
        this.terms = terms;
    }

    protected List<Double> getTerms() {
        return terms;
    }

    public double nextTerm() {
        return terms.get(pointer++);
    }
}
