package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class CarMover {

    private MoveStrategy moveStrategy;

    public CarMover(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public List<Car> move(List<Car> cars) {
        cars = cars.stream()
                .map(this::move)
                .collect(Collectors.toList());

        return cars;
    }

    private Car move(Car car) {
        if (moveStrategy.canMove()) {
            return car.move();
        }

        return car;
    }
}
