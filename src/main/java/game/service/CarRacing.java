package game.service;

import game.domain.Cars;
import game.view.ResultView;

import java.util.stream.IntStream;

public class CarRacing {
    private final int racingRep;
    private final Cars cars;

    public CarRacing(int carCount, int racingRep) {
        throwIfNegativeNumber(carCount);
        throwIfNegativeNumber(racingRep);
        this.racingRep = racingRep;
        this.cars = Cars.generate(carCount);
    }

    private void throwIfNegativeNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("입력은 0 보다 큰 양수만 가능합니다.");
        }
    }

    public void start() {
        ResultView.displayExecuteResultMessage();
        IntStream.range(0, racingRep)
                .forEach(rep -> {
                    cars.drive();
                    ResultView.displayGameResult(cars.carPositions());
                });
    }
}