package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private final List<RoundResult> roundResults = new ArrayList<>();

    public void addRound(RoundResult currentRoundResult) {
        roundResults.add(currentRoundResult);
    }
    public List<Car> getWinners() {
        RoundResult finalResult = roundResults.get(roundResults.size() - 1);
        return finalResult.findWinners();
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }
}
