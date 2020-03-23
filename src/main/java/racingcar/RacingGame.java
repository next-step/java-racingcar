package racingcar;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.policy.MovingPolicy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final int time;
    private final Cars cars;
    private final MovingPolicy movingPolicy;
    private int round;

    public RacingGame(final int time, final int count, final MovingPolicy movingPolicy) {
        this.time = time;
        this.cars = ready(count);
        this.movingPolicy = movingPolicy;
        round = 0;
    }

    public void play() {
        cars.move(movingPolicy);
        round++;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public boolean isGameOver() {
        return round == time;
    }

    private Cars ready(final int count) {
        if (count < 1) {
            throw new IllegalArgumentException("자동차 갯수가 잘못 되었습니다.");
        }

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }

        return new Cars(cars);
    }
}
