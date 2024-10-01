package racing.model.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racing.model.RoundResult;

public class GameResult {
    private final List<RoundResult> roundResults;

    public GameResult() {
        this.roundResults = new ArrayList<>();
    }

    public void addRoundResult(RoundResult roundResult) {
        roundResults.add(roundResult);
    }

    public List<RoundResult> getRoundResults() {
        return Collections.unmodifiableList(roundResults);
    }
}
