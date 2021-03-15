package study.step5.domain;

import study.step4.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(String[] carNames) {
        return new Cars(
                Arrays.stream(carNames)
                        .map(study.step4.Car::of)
                        .collect(Collectors.toList()));
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public int getSize() {
        return cars.size();
    }
}
