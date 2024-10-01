package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {
    private final List<Car> cars = new ArrayList<>();

    private final int attemptCount;
    private final ResultView resultView = new ResultView();

    public RaceGame(final int competitorCount, final int attemptCount) {
        for (int i = 0; i < competitorCount; i++) {
            cars.add(new Car());
        }
        this.attemptCount = attemptCount;
    }

    public List<Car> getCars() {
        return cars;
    }
}
