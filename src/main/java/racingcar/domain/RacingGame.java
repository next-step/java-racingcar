package racingcar.domain;

import racingcar.utils.NumberGenerator;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    private final int times;

    public RacingGame(final int times) {
        this.times = times;
    }

    public void repeat(List<Car> cars, NumberGenerator numberGenerator) {
        for (int i = 0; i < times; i++) {
            race(cars, numberGenerator);
            OutputView.printBody(cars);
        }
    }

    public void race(List<Car> cars, NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator);
        }
    }
}