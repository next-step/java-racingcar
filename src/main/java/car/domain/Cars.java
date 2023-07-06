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
        int carMaxPosition = cars.stream().map(Car::getPosition)
            .max(Comparator.comparing(car-> car)).orElseThrow(() -> new RuntimeException("주어진 Winner의 최대 위치를 구하지 못합니다."));

        return cars.stream().filter(car-> (car.getPosition() == carMaxPosition))
            .collect(Collectors.toList());
    }
}
