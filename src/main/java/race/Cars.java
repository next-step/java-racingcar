package race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    private Cars(Condition condition) {
        cars.addAll(
                Arrays.stream(condition.getNames())
                        .map(name -> Car.of(condition.getTryCount(), name))
                        .collect(Collectors.toList())
        );
    }

    public static Cars of(Condition condition) {
        return new Cars(condition);
    }

    public void moveAll() {
        cars.forEach(Car::move);
    }

    public String getWinner(int highDistance) {
        return cars.stream()
                .filter(car -> car.getDistanceByRound(car.getMaxTryCount()) >= highDistance)
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
