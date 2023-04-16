package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<RaceResult> raceResults = new ArrayList<>();
    private List<CarResult> winners;

    public void addRoundResult(final RaceResult raceResult) {
        raceResults.add(raceResult);
    }

    public void addWinner(final List<CarResult> winners) {
        this.winners = winners;
    }

    public List<RaceResult> getRaceResults() {
        return raceResults;
    }

    public List<CarResult> getWinners() {
        return winners;
    }
}
