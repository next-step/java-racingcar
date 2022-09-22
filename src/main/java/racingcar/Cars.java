package racingcar;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Cars {
    private static final Integer MIN_NUM = 0;
    private static final Integer MAX_NUM = 10;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars initialize(int carCount) {
        List<Car> cars = IntStream.range(0, carCount)
                .map(integer -> 0)
                .mapToObj(Car::positionOf)
                .collect(toList());
        return new Cars(cars);
    }

    public List<Car> currentCars() {
        return cars;
    }

    public Cars next() {
        List<Car> nextCars = cars.stream()
                .map(car -> {
                    int randomNumber = ThreadLocalRandom.current().nextInt(MIN_NUM, MAX_NUM);
                    return Car.positionOf(car.nextPosition(randomNumber));
                }).collect(toList());
        return new Cars(nextCars);
    }
}
