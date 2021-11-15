package racing.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class Winner {

    private RacingCar cars;
    private RacingHistory history;

    private Winner(RacingCar cars, RacingHistory history) {
        this.cars = cars;
        this.history = history;
    }

    public static Winner from(RacingCar cars, RacingHistory history) {
        return new Winner(cars, history);
    }

    public RacingHistory getRacingHistory() {
        return history;
    }

    public List<Car> getWinners() {
        int max = getMaxStep();

        return this.cars.getCars()
            .stream()
            .filter(c -> c.hasEqualTo(max))
            .collect(Collectors.toList());
    }

    private int getMaxStep() {
        return this.cars.getCars()
            .stream()
            .mapToInt(Car::getStep)
            .max()
            .orElseThrow(NoSuchElementException::new);
    }
}
