package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars;

    public Cars(int carCount) {
        cars = new ArrayList<>();
        createCars(carCount);
    }

    private List<Car> createCars(int carCount) {
        IntStream.range(0, carCount)
                .mapToObj(i -> new Car())
                .forEach(cars::add);
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
