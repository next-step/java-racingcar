package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isAtPosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }

    public static Cars from(String[] names) {
        List<Car> carList =
                Stream.of(names)
                        .map(name -> new Car(new CarName(name), new CarPosition(0)))
                        .collect(Collectors.toList());
        return new Cars(carList);
    }

}
