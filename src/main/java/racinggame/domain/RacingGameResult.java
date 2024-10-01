package racinggame.domain;

import java.util.List;

public class RacingGameResult {
    private final List<Integer> results;

    public RacingGameResult(final List<Integer> results) {
        this.results = results;
    }

    public List<Integer> getResults() {
        return results;
    }
}
