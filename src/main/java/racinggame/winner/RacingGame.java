package racinggame.winner;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final RacingCount count;
    private final NumberGenerator numberGenerator;

    public RacingGame(Cars cars, RacingCount count) {
        this(cars, count, new RandomNumberGenerator());
    }

    public RacingGame(Cars cars, RacingCount count, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.count = count;
        this.numberGenerator = numberGenerator;
    }

    public void race() {
        count.decrease();
        cars.move(numberGenerator);
    }

    public boolean isFinish() {
        return count.isZero();
    }

    public List<Car> getWinners() {
        return cars.getFarthestCars();
    }
}
