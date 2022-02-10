package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> parsedInput) {
        cars = new ArrayList<>();
        for (String carName : parsedInput) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> moveCars(MoveStrategy moveStrategy) {

        for (Car car : cars) {
            if (moveStrategy.moveOrNot()) {
                car.moveForward();
            }
        }
        return cars;
    }
}
