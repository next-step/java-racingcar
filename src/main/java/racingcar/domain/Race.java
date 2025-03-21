package racingcar.domain;

import racingcar.view.ResultView;

import java.util.List;

public class Race {
    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    public Race(List<Car> cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public void start(int attempts) {
        for (int i = 0; i < attempts; i++) {
            raceOnce();
            ResultView.printRaceStatus(cars);
        }
    }

    private void raceOnce() {
        cars.forEach(car -> car.move(moveStrategy));
    }
}

