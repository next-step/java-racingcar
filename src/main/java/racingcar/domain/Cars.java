package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        checkNullOrEmpty(cars);
        this.cars = cars;
    }

    private void checkNullOrEmpty(List<Car> cars) {
        if(Objects.isNull(cars) || cars.isEmpty()) {
            throw new IllegalArgumentException("차는 최소 1대 이상이어야 합니다.");
        }
    }

    public void moveCars(MovableStrategy movableStrategy) {
        cars.stream().forEach(car -> car.move(movableStrategy));
    }

    public List<Car> getCars() {
        return cars;
    }
}
