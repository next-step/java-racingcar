package step3.model;

import java.util.List;

public class EachTryResult {

    private final List<Integer> moveCounts;

    public EachTryResult(List<Integer> moveCounts) {
        this.moveCounts = moveCounts;
    }

    public List<Integer> getMoveCounts() {
        return this.moveCounts;
    }
}
