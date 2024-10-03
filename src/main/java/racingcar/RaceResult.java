package racingcar;

public class RaceResult {
    private final AttemptResult[] attemptResults;

    public RaceResult(int attemptCount) {
        this.attemptResults = new AttemptResult[attemptCount];
    }

    public void addAttemptResult(AttemptResult attemptResult, int attempt) {
        attemptResults[attempt] = attemptResult;
    }

    public AttemptResult[] getAttemptResults() {
        return this.attemptResults;
    }
}
