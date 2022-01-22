package calculator.domain;

import java.util.List;

public class Terms {
    private List<Double> terms;

    private Terms() {}

    public Terms(List<Double> terms) {
        this.terms = terms;
    }

    protected List<Double> getTerms(){
        return terms;
    }
}
