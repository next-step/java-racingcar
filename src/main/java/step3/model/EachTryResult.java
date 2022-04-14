package step3.model;

import java.util.List;

public class EachTryResult {

    private final List<Integer> successCounts;

    public EachTryResult(List<Integer> successCounts) {
        this.successCounts = successCounts;
    }

    public List<Integer> getSuccessCounts() {
        return this.successCounts;
    }
}
