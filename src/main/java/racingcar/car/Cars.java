package racingcar.car;

import racingcar.dto.CarDto;
import racingcar.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    public static final int MINIMUM_NUMBER_OF_CARS = 1;

    private final List<Car> cars;

    private Cars(String... names) {
        validate(names);

        this.cars = Arrays.stream(names)
                .map(Car::from)
                .collect(Collectors.toList());
    }

    private Cars(int numberOfCars) {
        validate(numberOfCars);

        this.cars = Stream.generate(Car::newInstance)
                .limit(numberOfCars)
                .collect(Collectors.toList());
    }

    public static Cars from(int numberOfCars) {
        return new Cars(numberOfCars);
    }

    private void validate(int numberOfCars) {
        if (numberOfCars < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("Number of cars can't be under 1");
        }
    }

    public static Cars init(String... names) {
        return new Cars(names);
    }

    private void validate(String... names) {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException("Car names can't be null");
        }

        if (names.length < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("Number of cars can't be under 1");
        }
    }

    public void moveCars(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public List<CarDto> getCarDtos() {
        return cars.stream()
                .map(CarDto::from)
                .collect(Collectors.toList());
    }
}
