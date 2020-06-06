package racing.domain;

import java.util.*;

public class RacingResult {
    private final List<List<Car>> racingResult = new ArrayList<>();

    public void add(final List<Car> cars) {
        if ((cars == null) || (cars.isEmpty())) {
            throw new IllegalArgumentException();
        }
        racingResult.add(cars);
    }

    public List<List<Car>> getRacingResult() {
        return racingResult;
    }

    public List<Car> getLastRoundResult() {
        return racingResult.get(racingResult.size() - 1);
    }

    public int getRacingRoundSize() {
        return racingResult.size();
    }
}
