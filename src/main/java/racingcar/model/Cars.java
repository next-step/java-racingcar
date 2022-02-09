package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;
    private MoveStrategy moveStrategy;

    public Cars(List<String> parsedInput) {
        cars = new ArrayList<>();
        for (String carName : parsedInput) {
            cars.add(new Car(carName));
        }
    }

    public Cars(List<String> parsedInput, MoveStrategy moveStrategy) {
        this(parsedInput);
        this.moveStrategy = moveStrategy;
    }

    public List<Car> moveCars() {
        for (Car car : cars) {
            if (moveStrategy.canMove()) {
                car.moveForward();
            }
        }
        return cars;
    }

}
