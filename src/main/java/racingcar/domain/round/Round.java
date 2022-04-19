package racingcar.domain.round;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Round {
    private final Cars cars;

    public Round(Cars cars) {
        validateCars(cars);
        this.cars = cars;
    }

    private void validateCars(Cars cars) {
        if (cars == null) {
            throw new IllegalArgumentException("cars없이 Round는 생성될 수 없습니다.");
        }
    }

    public Round play() {
        return new Round(cars.act());
    }

    public Cars getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int winnerPosition = getWinnerPosition();
        return cars.getCars().stream().filter(car -> car.getPosition() == winnerPosition).collect(Collectors.toList());
    }

    private int getWinnerPosition() {
        return cars.getCars().stream().mapToInt(Car::getPosition).max().orElseThrow(NoSuchElementException::new);
    }
}
