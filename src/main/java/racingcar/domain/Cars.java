package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(String carNames) {
        String[] names = carNames.split(",");

        List<Car> collect = Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(collect);
    }

    public void carRacing(Strategy strategy) {
        cars.forEach(car -> car.move(strategy));
    }

    public Cars getWinners() {
        int largestCarsPosition = getLargestCarsPosition();

        List<Car> cars = this.cars.stream()
                .filter(car -> car.getPosition() == largestCarsPosition)
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    private int getLargestCarsPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(new ArrayList<>(this.cars));
    }

    public int getSize() {
        return cars.size();
    }
}
