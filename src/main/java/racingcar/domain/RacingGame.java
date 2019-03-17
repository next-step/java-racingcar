package racingcar.domain;

import racingcar.utils.NumberGenerator;

import java.util.List;

public class RacingGame {
    private int times;

    public RacingGame(int times) {
        this.times = times;
    }

    public boolean isEnd() {
        return times == 0;
    }

    public void race(List<Car> cars, NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator);
        }
        times--;
    }
}