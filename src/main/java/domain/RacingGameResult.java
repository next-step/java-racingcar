package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    private final List<RoundResult> roundResult;

    public RacingGameResult() {
        this.roundResult = new ArrayList<>();
    }

    public void addRoundResult(RoundResult roundResult) {
        this.roundResult.add(roundResult);
    }

    public List<RoundResult> getAllRoundResults() {
        return roundResult;
    }

    public RoundResult getLastRoundResult() {
        return roundResult.get(roundResult.size() - 1);
    }
}
