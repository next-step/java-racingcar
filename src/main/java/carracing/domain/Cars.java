package carracing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 자동차 경주를 같이하는 자동차들을 표현한 클래스
 */
public class Cars {
    private final List<Car> cars;

    public Cars(int numberOfCars) {
        cars = new ArrayList<>(numberOfCars);
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars moveCars(MovementPolicy movementPolicy) {
        return new Cars(movedCars(movementPolicy));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private List<Car> movedCars(MovementPolicy movementPolicy) {
        return cars.stream()
                .map(car -> car.move(movementPolicy))
                .collect(Collectors.toList());
    }
}
