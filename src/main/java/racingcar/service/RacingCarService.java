package racingcar.service;

import racingcar.service.domain.Car;
import racingcar.service.dto.Cars;
import racingcar.service.strategy.RandomRule;
import racingcar.service.strategy.Rule;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RacingCarService {
    private final Rule rule;
    private final List<Car> cars;

    private RacingCarService(int carCount) {
        rule = new RandomRule();

        cars = IntStream.rangeClosed(1, carCount)
                .mapToObj(Car::new)
                .collect(toList());
    }

    public static RacingCarService init(int carCount) {
        return new RacingCarService(carCount);
    }

    public Cars start() {
        cars.forEach(car -> car.move(rule));
        return Cars.from(cars);
    }
}
