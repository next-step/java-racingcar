package racing.refactor.domain;

import java.util.List;

public class CarRacingGame {

    private final Cars cars;

    public CarRacingGame(List<Car> cars) {
        this.cars = new Cars(cars);
    }

    public Cars nextRound(MovingStrategy strategy) {
        cars.moveCars(strategy);
        return getCars();
    }

    public Cars getWinners() {
        return cars.getWinners();
    }

    public Cars getCars() {
        return cars;
    }
}
