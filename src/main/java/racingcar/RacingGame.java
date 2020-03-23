package racingcar;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private final int time;
    private final List<Car> cars;

    public RacingGame(final int time, final int count) {
        this.time = time;
        this.cars = ready(count);
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> ready(final int count) {
        if (count < 1) {
            throw new IllegalArgumentException("자동차 갯수가 잘못 되었습니다.");
        }

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }

        return Collections.unmodifiableList(cars);
    }
}
