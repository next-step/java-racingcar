package racingcar.car;

import racingcar.util.RandomNumber;

import java.util.List;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        for (Car car : cars) {
            car.move(RandomNumber.pick());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
