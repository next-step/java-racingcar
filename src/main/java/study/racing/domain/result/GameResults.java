package study.racing.domain.result;

import java.util.Collections;
import java.util.List;

import study.racing.domain.car.RacingCars;

public class GameResults {

    public static final int LAST_INDEX_MAKER = 1;

    private final List<Round> gameResults;

    public GameResults(List<Round> gameResults) {
        this.gameResults = gameResults;
    }

    public List<Round> allRoundResults() {
        return Collections.unmodifiableList(gameResults);
    }

    public RacingCars winners() {
        return lastRound().winners();
    }

    private Round lastRound() {
        return gameResults.get(gameResults.size() - LAST_INDEX_MAKER);
    }
}
