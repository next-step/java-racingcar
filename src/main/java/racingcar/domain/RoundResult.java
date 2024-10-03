package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {
    private final List<Integer> results = new ArrayList<>();

    public RoundResult() {
    }

    public void addResult(int position) {
        this.results.add(position);
    }

    public List<Integer> getResults() {
        return results;
    }
}
