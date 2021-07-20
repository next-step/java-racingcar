package racingcar.car;

import racingcar.dto.CarDto;
import racingcar.strategy.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;

    public Cars(int numberOfCars, MoveStrategy moveStrategy) {
        cars = Stream.generate(() -> Car.from(moveStrategy))
                .limit(numberOfCars)
                .collect(Collectors.toList());
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
