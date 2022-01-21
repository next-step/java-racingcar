package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;
    private final int LIMITED_CAR_NAME_LENGTH = 5;

    public Cars(List<String> carNames) {
        this.cars = carNames.stream()
            .map(name -> {
                validateCarName(name);
                return new Car(name);
            })
            .collect(Collectors.toList());
    }

    public List<Car> filterWinners() {
        return cars.stream()
            .filter(car -> car.distance() == calculateMax())
            .collect(Collectors.toList());
    }

    public List<Car> get() {
        return cars;
    }

    private void validateCarName(String name) {
        if (name.length() > LIMITED_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + LIMITED_CAR_NAME_LENGTH + "자를 넘을 수 없습니다.");
        }
    }

    private int calculateMax() {
        return cars.stream()
            .map(Car::distance)
            .max(Integer::compare)
            .orElseThrow(IllegalArgumentException::new);
    }
}
