package car.domain;

import car.util.Movable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Cars {

    private List<Car> cars;

    public Cars(CarNames carNames) {
        cars = Arrays.stream(carNames.getCarNames()).map(Car::new).collect(Collectors.toList());
    }

    public void race(Movable movable) {
        cars.forEach(car -> {
            if (movable.getMovable()) {
                car.move(movable.getMovingSize());
            }
        });
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
