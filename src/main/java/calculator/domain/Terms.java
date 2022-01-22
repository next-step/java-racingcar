package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Terms {

    private final List<Double> terms = new ArrayList<>();
    private int pointer = 0;

    public Terms() {}

    protected List<Double> getTerms() {
        return terms;
    }

    public double nextTerm() {
        return terms.get(pointer++);
    }

    public void addTerm(double term) {
        terms.add(term);
    }
}
