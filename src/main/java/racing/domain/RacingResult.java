package racing.domain;

import java.util.*;

public class RacingResult {
    private final Map<Integer, List<Car>> racingResult = new HashMap<>();

    public void put(final int racingRound, final List<Car> cars) {
        if (cars == null || cars.isEmpty()) throw new IllegalArgumentException();
        racingResult.put(racingRound, cars);
    }

    public List<Car> getRoundResult(final int round) {
        if (!isValid(round)) throw new IllegalArgumentException();
        return racingResult.get(round);
    }

    public List<Car> getLastRoundResult() {
        return racingResult.get(getRacingRoundSize());
    }

    public int getRacingRoundSize() {
        return racingResult.size();
    }

    private boolean isValid(final int round) {
        return round > 0 || round <= getRacingRoundSize();
    }
}
