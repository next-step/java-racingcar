package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String SEPARATOR = ",";

    private final List<Car> cars;

    public Cars(List<String> names) {
        cars = initCars(names);
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

    private List<Car> initCars(List<String> names) {
        List<Car> resultCars = new ArrayList<>();
        names.forEach(
                name -> resultCars.add(new Car(name))
        );
        return resultCars;
    }
}
