package racingcar.domain;

import java.util.List;

public class RoundResult {
    private final List<Integer> results;

    public RoundResult(List<Integer> results) {
        this.results = results;
    }

    public List<Integer> getResults() {
        return results;
    }
}
