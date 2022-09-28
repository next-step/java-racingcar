package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(int carQuantity) {
        cars = initCars(carQuantity);
    }

    public List<Integer> play() {
        moveCars();
        return mapToPosition();
    }

    private void moveCars() {
        cars.forEach(car -> car.move(new CarCondition()));
    }

    private List<Integer> mapToPosition() {
        return cars.stream().mapToInt(Car::getPosition).boxed().collect(Collectors.toList());
    }

    private List<Car> initCars(int carQuantity) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carQuantity; i++) {
            cars.add(new Car("boost"));
        }
        return cars;
    }
}
