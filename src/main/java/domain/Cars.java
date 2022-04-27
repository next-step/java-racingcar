package domain;

import util.MoveStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private static final String NOT_EXIST_WINNERS = "우승자가 없습니다.";
    private static final String DELIMITER = ",";
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public Cars(String name) {
        carList = Arrays.stream(name.split(DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> moveCars(MoveStrategy moveStrategy) {
        carList.forEach(car -> car.move(moveStrategy));
        return carList;
    }

    public List<Car> findWinners() {
        Car maxPositionCar = findMaxPositionCar();
        return carList.stream()
                .filter(car -> car.isEqualPosition(maxPositionCar))
                .collect(Collectors.toList());
    }

    private Car findMaxPositionCar() {
        if (carList.isEmpty()) {
            throw new IllegalArgumentException(NOT_EXIST_WINNERS);
        }
        return carList.stream()
                .max(Car::compareTo)
                .get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars carList = (Cars) o;
        return Objects.equals(this.carList, carList.carList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carList);
    }
}
