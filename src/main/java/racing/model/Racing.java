package racing.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * .
 */
public class Racing {
    private final Integer roundCount;
    private final Cars cars;
    private final RacingResult racingResult = new RacingResult();

    public Racing(String carName, Integer roundCount) {
        this.roundCount = roundCount;
        this.cars = new Cars(carName);
    }

    public RacingResult start() {
        for (int i = 1; i <= roundCount; i++) {
            List<Car> cars = this.cars.moveCars();
            racingResult.add(new RoundResult(cars));
        }
        return racingResult;
    }
}
