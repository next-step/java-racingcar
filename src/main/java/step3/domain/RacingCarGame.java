package step3.domain;

import step3.Car;
import step3.Distance;
import step3.domain.strategy.MovingStrategy;

import java.util.List;

public class RacingCarGame {
    private Cars cars;

    public RacingCarGame(int CarCount) {
        this.cars = new Cars(CarCount);
    }

    public RacingCarGame(String... names) {
        this.cars = new Cars(names);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    private Distance getMaxDistance() {
        return cars.pickDistance("max");
    }

    private Distance getMinDistance() {
        return cars.pickDistance("min");
    }

    public List<String> getWinnerCarNames() {
        return cars.getWinnerCarNames(getMaxDistance());
    }

    public void play(MovingStrategy movingStrategy) {
        cars.move(movingStrategy);
    }
}
