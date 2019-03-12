package racingcar;

import java.util.List;

public class RacingGame {
    private int times;

    public RacingGame(int times) {
        this.times = times;
    }

    public void race(List<Car> cars, NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator);
        }
    }

    public int getTimes() {
        return this.times;
    }
}
