package study.racing.domain.result;

import java.util.Collections;
import java.util.List;

import study.racing.domain.car.RacingCars;

public class GameResults {

    private static final int LAST_INDEX_MAKER = 1;

    private final List<Round> results;

    public GameResults(List<Round> results) {
        this.results = results;
    }

    public List<Round> allRoundResults() {
        return Collections.unmodifiableList(results);
    }

    public RacingCars winners() {
        return lastRound().winners();
    }

    private Round lastRound() {
        return results.get(results.size() - LAST_INDEX_MAKER);
    }
}
