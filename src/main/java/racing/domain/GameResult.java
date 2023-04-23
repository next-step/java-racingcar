package racing.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameResult {
    private final List<RoundResult> roundResults = new ArrayList<>();

    public void addRound1(RoundResult currentRoundResult) {
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
