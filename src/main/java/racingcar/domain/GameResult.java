package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<RoundResult> roundResults = new ArrayList<>();
    private List<CarResult> winners;

    public void addRoundResult(final RoundResult roundResult) {
        roundResults.add(roundResult);
    }

    public void addWinner(final List<CarResult> winners) {
        this.winners = winners;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

    public List<CarResult> getWinners() {
        return winners;
    }
}
