package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class Cars {

    public static final String NEWLINE = "\n";
    private final List<Car> cars;

    private Cars(List<Car> carList) {
        this.cars = carList;
    }

    public static Cars createWithDefaults(int numberOfCars) {
        List<Car> rawCars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            rawCars.add(new Car());
        }
        return new Cars(rawCars);
    }

    public static Cars createFromList(List<Car> carList) {
        return new Cars(carList);
    }

    public Cars move(MoveStrategy moveStrategy) {
        List<Car> movedCars = cars
                .stream()
                .map(car -> car.move(moveStrategy))
                .collect(Collectors.toList());
        return new Cars(movedCars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cars)) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public String toString() {
        List<String> carStates = cars
                .stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        return String.join(NEWLINE, carStates);
    }
}
