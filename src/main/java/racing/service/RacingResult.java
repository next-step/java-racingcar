package racing.service;

import racing.domain.Winners;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
    private List<RoundResult> roundResults = new ArrayList<>();

    private Winners winners;

    public void addRoundResult(RoundResult roundResult) {
        roundResults.add(roundResult);
    }

    public void reportWinners(Winners winners) {
        this.winners = winners;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

    public Winners getWinners() {
        return winners;
    }
}
