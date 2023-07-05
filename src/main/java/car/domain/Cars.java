package car.domain;

import car.util.Movable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class Cars {

    private List<Car> cars;

    public Cars(CarNames carNames) {
        cars = carNames.getCarNames().stream().map(car -> new Car(car.getName()))
            .collect(Collectors.toList());
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

    public List<Car> selectWinners() {
        int maxPos = cars.stream().map(Car::getPosition)
            .max(Comparator.comparing(x -> x)).orElseThrow(() -> new RuntimeException());

        return cars.stream().filter(s -> (s.getPosition() == maxPos))
            .collect(Collectors.toList());
    }
}
