package carracing.domain.game;

import carracing.domain.car.Car;
import carracing.domain.car.Cars;
import carracing.domain.car.Winners;

public class RacingGame {
    private final Cars cars;
    private final int tryNumbers;

    public RacingGame(Cars cars, int tryNumbers) {
        this.cars = cars;
        this.tryNumbers = tryNumbers;
    }

    public void race(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }

    public Winners winners(WinnerStrategy winnerStrategy) {
        return winnerStrategy.winners(cars);
    }

    public Cars cars() {
        return this.cars;
    }

    public int tryNumbers() {
        return this.tryNumbers;
    }

}
