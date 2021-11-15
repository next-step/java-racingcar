package study.racing.model.result;

import java.util.Collections;
import java.util.List;

import study.racing.model.car.Car;

public class GameResults {

    private final List<RoundResult> gameResults;

    public GameResults(List<RoundResult> gameResults) {
        this.gameResults = gameResults;
    }

    public int round() {
        return gameResults.size();
    }

    public List<RoundResult> allRoundResults() {
        return Collections.unmodifiableList(gameResults);
    }

    public List<Car> winners() {
        return lastRound().result().mostMovedCars();
    }

    private RoundResult lastRound() {
        int lastRoundIndex = gameResults.size() - 1;
        return gameResults.get(lastRoundIndex);
    }
}
