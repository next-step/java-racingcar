package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;
    private List<Car> winners;

    public Cars(String[] carNames, Engine engine) {
        cars = Arrays.stream(carNames)
            .map(name -> new Car(name, engine))
            .collect(Collectors.toList());
    }

    public void moveAll() {
        cars.forEach(Car::move);
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public void findWinners() {
        int maxPosition = findMaxPosition(cars);
        winners = cars.stream()
            .filter(car -> car.position() == maxPosition)
            .collect(Collectors.toList());
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(winners);
    }

    private static int findMaxPosition(List<Car> cars) {
        return cars.stream()
            .mapToInt(Car::position)
            .max()
            .orElse(0);
    }
}
