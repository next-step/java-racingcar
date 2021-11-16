package study.racing.model.result;

import java.util.Collections;
import java.util.List;

import study.racing.model.car.Car;

public class GameResults {

    public static final int LAST_INDEX_MAKER = 1;

    private final List<Round> gameResults;

    public GameResults(List<Round> gameResults) {
        this.gameResults = gameResults;
    }

    public List<Round> allRoundResults() {
        return Collections.unmodifiableList(gameResults);
    }

    public List<Car> winners() {
        return lastRound().winners();
    }

    private Round lastRound() {
        return gameResults.get(gameResults.size() - LAST_INDEX_MAKER);
    }
}
