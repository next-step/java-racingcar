package car.model;

import car.model.util.NumberGenerator;
import car.model.util.RandomNumberGenerator;
import java.util.List;

public final class RacingGame {

    private Cars cars;
    private TryCount leftRound;
    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public RacingGame(Cars cars, int tryCount) {
        this.cars = cars;
        this.leftRound = new TryCount(tryCount);
    }

    public RacingGame(String carNames, int tryCount) {
        this(new Cars(new CarNames(carNames)), tryCount);
    }

    public void runRaceOnce() {
        cars = cars.race(numberGenerator);
        this.leftRound = leftRound.decreaseCount();
    }

    public List<Car> selectWinner() {
        return cars.selectWinners();
    }

    public boolean isLeftRound() {
        return leftRound.isPositive();
    }

    public List<CarResult> createCarResult() {
        return cars.createCarResult();
    }
}
