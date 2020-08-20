package carracing.domain;

import carracing.domain.car.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Winner {
    private List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public String getWinner() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .flatMap(car -> Stream.of(car.getCarName()))
                .collect(Collectors.joining(","));
    }
    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}
