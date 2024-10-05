package racingcar;

import java.util.List;

public class RaceResult {
    private final List<AttemptResult> attemptResults;

    public RaceResult(List<AttemptResult> attemptResults) {
        this.attemptResults = attemptResults;
    }

    public List<AttemptResult> getAttemptResults() {
        return this.attemptResults;
    }
}
