package racingcar.backend.controller;

import racingcar.backend.domain.Car;
import racingcar.backend.domain.Cars;
import racingcar.backend.domain.GameRecords;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCarGame {

    private final Cars cars;
    private final int times;
    private final GameRecords gameHistory = new GameRecords();

    public RacingCarGame(int carNum, int times) {
        this.cars = createCars(carNum);
        this.times = times;
    }

    private Cars createCars(int carNum) {
        return new Cars(Stream.generate(Car::new)
                .limit(carNum).collect(Collectors.toList()));
    }

    public GameRecords start() {
        for (int round = 0; round < times; round++) {
            gameHistory.addResult(cars.play());
        }
        return gameHistory;
    }
}
