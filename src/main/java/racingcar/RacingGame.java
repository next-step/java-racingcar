package racingcar;

import racingcar.model.Car;
import racingcar.policy.MovingPolicy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private final int time;
    private final List<Car> cars;
    private final MovingPolicy movingPolicy;

    public RacingGame(final int time, final int count, final MovingPolicy movingPolicy) {
        this.time = time;
        this.cars = ready(count);
        this.movingPolicy = movingPolicy;
    }

    // TODO : INDET 3
    public void play() {
        int distance;
        for (int i = 0; i < time; i++) {
            for (Car car : cars) {
                distance = movingPolicy.distance();
                if (movingPolicy.isPossibleMove(distance)) {
                    car.move();
                }
            }
        }
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
