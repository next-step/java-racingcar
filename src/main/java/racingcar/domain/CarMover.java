package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarMover {

    private MoveStrategy moveStrategy;

    public CarMover(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public Cars move(Cars cars) {
        List<Car> result = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            Car newCar = move(car);
            result.add(newCar);
        }

        return new Cars(result);
    }

    private Car move(Car car) {
        if (moveStrategy.canMove()) {
            return car.move();
        }

        return car;
    }
}
