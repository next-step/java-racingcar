package car.domain;

import car.util.Movable;
import java.util.Collections;
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
            movable.decideMoving();
            if (movable.getMovable()) {
                car.move(movable.getMovingSize());
            }
        });
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> selectWinners() {
        int carMaxPosition = cars.stream().mapToInt(Car::getPosition).max()
            .orElseThrow(() -> new RuntimeException("자동차 간의 최대 위치가 존재 하지 않습니다. "));
        return cars.stream().filter(car -> (car.getPosition() == carMaxPosition))
            .collect(Collectors.toList());
    }
}
