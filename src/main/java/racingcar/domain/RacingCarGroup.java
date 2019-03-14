package racingcar.domain;

import racingcar.random.PositiveIntUnder10Generator;
import racingcar.random.RandomIntGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGroup {
    private List<Car> cars;
    private RandomIntGenerator randomIntGenerator;

    public RacingCarGroup(List<Car> cars) {
        this(cars, new PositiveIntUnder10Generator());
    }

    public RacingCarGroup(List<Car> cars, RandomIntGenerator randomIntGenerator) {
        this.cars = cars;
        this.randomIntGenerator = randomIntGenerator;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void go() {
        this.cars.forEach(car -> {
            int randomInt = this.randomIntGenerator.getRandomInt();
            car.goWhenGreaterThanThreshold(randomInt);
        });
    }

    public void initialize() {
        this.cars = this.cars.stream()
                .map(Car::getName)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
