package racingcar.car;

import racingcar.dto.CarDto;
import racingcar.strategy.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    public static final int MINIMUM_NUMBER_OF_CARS = 1;

    private final List<Car> cars;

    private Cars(int numberOfCars, MoveStrategy moveStrategy) {
        validate(numberOfCars);

        cars = Stream.generate(() -> Car.from(moveStrategy))
                .limit(numberOfCars)
                .collect(Collectors.toList());
    }

    public static Cars of(int numberOfCars, MoveStrategy moveStrategy) {
        return new Cars(numberOfCars, moveStrategy);
    }

    private void validate(int numberOfCars) {
        if (numberOfCars < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("Number of cars can't be under 1");
        }
    }

    public void moveCars() {
        cars.forEach(Car::move);
    }

    public List<CarDto> getCarDtos() {
        return cars.stream()
                .map(CarDto::from)
                .collect(Collectors.toList());
    }
}
