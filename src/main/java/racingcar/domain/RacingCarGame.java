package racingcar.domain;

import java.util.List;

public class RacingCarGame {
    private final List<Car> cars;

    public RacingCarGame(List<Car> cars) {
        this.cars = cars;
    }

    public GameResult execute() {
        Strategy randomStrategy = new RandomStrategy();

        cars.forEach(car -> {
            if (randomStrategy.isMove()) {
                car.move();
            }
        });

        return new GameResult(cars);
    }
}

