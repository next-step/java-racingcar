package racingcar.domain;

import racingcar.dto.RoundResult;

import java.util.List;

public class Round {
    private List<Car> cars;

    public Round(List<Car> cars) {
        this.cars = cars;
    }

    public RoundResult play() {
        for (Car car : cars) {
            car.act();
        }

        return new RoundResult(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
