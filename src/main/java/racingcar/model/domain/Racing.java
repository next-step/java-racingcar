package racingcar.model.domain;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.entity.Car;

public class Racing {

    private List<Car> cars;
    private CarMoveBehavior carMoveBehavior;

    public Racing(List<Car> cars, final CarMoveBehavior carMoveBehavior) {
        this.cars = cars;
        this.carMoveBehavior = carMoveBehavior;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void drive() {
        IntStream.range(0, cars.size())
            .forEach(idx -> {
                racingCondition(idx);
            });
    }

    private void racingCondition(int idx) {
        if (carMoveBehavior.moveBehavior()) {
            cars.get(idx).moveForward();
        }
    }
}

