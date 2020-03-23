package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Result;
import racingcar.model.Winners;
import racingcar.view.InputView;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class RacingCar {
    private int tryCount;
    private int currentCount = 0;
    private static Cars cars;
    private Result result;

    public RacingCar(InputView inputView) {
        this.tryCount = inputView.getTryCount();
    }

    public static RacingCar ready(InputView inputView) {
        cars = inputView.getCarNames().stream()
                .map(Car::new)
                .collect(collectingAndThen(toList(), Cars::new));
        return new RacingCar(inputView);
    }

    public void start() {
        this.result = cars.moveOnce();
        this.currentCount++;
    }

    public Winners findWinners() {
        return new Winners(cars.findWinner());
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public List<Car> getWinners() {
        return findWinners().getWinners();
    }

    public boolean isNotEnd() {
        return this.tryCount > this.currentCount;
    }
}