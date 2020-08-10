package racingcar.game;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    private List<RoundResult> roundResults;

    private RacingGameResult() {
        roundResults = new ArrayList<>();
    }

    public static RacingGameResult newInstance() {
        return new RacingGameResult();
    }

    public void add(RoundResult roundResult) {
        this.roundResults.add(roundResult);
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

    public List<String> getWinners() {
        int lastStage = this.roundResults.size() - 1;
        RoundResult roundResult = this.roundResults.get(lastStage);
        int winnerPosition = roundResult.maxPosition();
        return roundResult.determineWinners(winnerPosition);
    }
}
