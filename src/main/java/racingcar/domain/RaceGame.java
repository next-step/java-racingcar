package racingcar.domain;

import java.util.List;

public class RaceGame {

    private final Cars cars;

    public RaceGame(List<Car> cars) {
        this.cars = new Cars(cars);
    }

    public void moveCars(final MoveStrategy moveStrategy) {
        for (Car car : cars.getCars()) {
            car.move(moveStrategy);
        }
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<String> getWinnersName() {
        return cars.getFarthestCarNames();
    }
}
