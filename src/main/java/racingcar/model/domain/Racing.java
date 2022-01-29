package racingcar.model.domain;

import java.util.List;
import java.util.stream.Collectors;
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
        cars.stream()
            .forEach(car -> racingCondition(car));
    }

    private void racingCondition(Car car) {
        if (carMoveBehavior.moveBehavior()) {
            car.moveForward();
        }
    }
}

