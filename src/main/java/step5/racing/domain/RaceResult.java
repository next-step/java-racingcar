package step5.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {

    private final List<RoundResult> raceResult;

    public RaceResult() {
        this.raceResult = new ArrayList<>();
    }

    public void addRoundResult(RoundResult roundResult) {
        this.raceResult.add(roundResult);
    }

    public List<RoundResult> getRaceResult() {
        return this.raceResult;
    }

    public List<CarName> winners() {
        List<CarName> winners = new ArrayList<>();
        RoundResult lastRound = raceResult.getLast();

        for (CarResult result : lastRound.winners()) {
            winners.add(result.name());
        }
        return winners;
    }
}
